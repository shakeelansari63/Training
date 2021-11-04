using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using API.Data;
using API.DTOs;
using API.Entities;
using API.Interfaces;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace API.Controllers
{
    [AllowAnonymous]
    public class AccountController : BaseController
    {
        private readonly DataContext _context;
        private readonly ITokenService _token;
        public AccountController(DataContext context, ITokenService token)
        {
            _token = token;
            _context = context;
        }

        // api/account/register
        [HttpPost("register")]
        public async Task<ActionResult<UserLoginDTO>> Register(RegisterDTO reg)
        {
            if (await UserExists(reg.UserName)) return BadRequest("Username already exist");

            using var hmac = new HMACSHA512();

            var newUser = new AppUser()
            {
                UserName = reg.UserName.ToLower(),
                PasswordHash = hmac.ComputeHash(Encoding.UTF8.GetBytes(reg.Password)),
                PasswordSalt = hmac.Key
            };

            _context.Add(newUser);

            await _context.SaveChangesAsync();

            return new UserLoginDTO
            {
                UserName = newUser.UserName,
                Token = _token.CreateToken(newUser)
            };
        }

        // api/account/login
        [HttpPost("login")]
        public async Task<ActionResult<UserLoginDTO>> Login(LoginDTO login)
        {
            var user = await _context.User.SingleOrDefaultAsync(u => u.UserName == login.UserName);

            if (user == null) return Unauthorized("Invalid User Name");

            using var hmac = new HMACSHA512(user.PasswordSalt);

            var computedHash = hmac.ComputeHash(Encoding.UTF8.GetBytes(login.Password));

            for (var i = 0; i < computedHash.Length; i++) 
            {
                if (computedHash[i] != user.PasswordHash[i]) return Unauthorized("Invalid Password");
            }

            return new UserLoginDTO
            {
                UserName = user.UserName,
                Token = _token.CreateToken(user)
            };
        }

        // Helper Method
        private async Task<bool> UserExists(string username)
        {
            return await _context.User.AnyAsync(u => u.UserName.ToLower() == username.ToLower());
        }
    }
}