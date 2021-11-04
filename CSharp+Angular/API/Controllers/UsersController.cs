using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using API.Data;
using API.Entities;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace API.Controllers
{
    // This is Users Controller which will server api/users endpoint
    
    public class UsersController : BaseController
    {
        // Constructor for initializing Database Context
        private readonly DataContext _context;
        public UsersController(DataContext context)
        {
            _context = context;
        }

        // Http Get handler for api/users
        [HttpGet]
        public async Task<ActionResult<IEnumerable<AppUser>>> GetUsers()
        {
            return await _context.User.ToListAsync();
        }

        // HttpGet handler for api/users/{id}
        [HttpGet("{id}")]
        public async Task<ActionResult<AppUser>> GetUserById(int id)
        {
            return await _context.User.FindAsync(id);
        }
    }
}