using System;
using System.Collections.Generic;
using System.IdentityModel.Tokens.Jwt;
using System.Linq;
using System.Security.Claims;
using System.Text;
using System.Threading.Tasks;
using API.Entities;
using API.Interfaces;
using Microsoft.Extensions.Configuration;
using Microsoft.IdentityModel.Tokens;

namespace API.Services
{
    public class TokenService : ITokenService
    {
        // Create symmetric key 
        private readonly SymmetricSecurityKey _key;
        public TokenService(IConfiguration config)
        {
            // Get the key value from AppSetting
            _key = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(config["TokenKey"]));
        }
        
        public string CreateToken(AppUser user)
        {
            // Create a new Claim
            var claim = new List<Claim>
            {
                new Claim(JwtRegisteredClaimNames.NameId, user.UserName)
            };

            // Create credentials for JWT Signature
            var cred = new SigningCredentials(_key, SecurityAlgorithms.HmacSha512Signature);

            // Create Token Descriptor for JWT
            var tokenDescriptor = new SecurityTokenDescriptor
            {
                Subject = new ClaimsIdentity(claim),
                Expires = DateTime.Now.AddHours(24),
                SigningCredentials = cred
            };

            // Create new token Handler
            var tokenHandler = new JwtSecurityTokenHandler();

            // Create a Token from Descriptor
            var token = tokenHandler.CreateToken(tokenDescriptor);

            return tokenHandler.WriteToken(token);
        }
    }
}