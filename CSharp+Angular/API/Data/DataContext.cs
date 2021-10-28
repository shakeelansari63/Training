using API.Entities;
using Microsoft.EntityFrameworkCore;

namespace API.Data
{
    // We will create a Data COntext which will be derived from DnContext class of Entity Framework
    public class DataContext : DbContext
    {
        // And we will need a Constructor of Data Context to initialize DbContext as well
        public DataContext(DbContextOptions option)
           : base(option) // We call the Constructor of Base class to initialize DBContext
        {
        }

        // And a property for Each Database table
        public DbSet<AppUser> User { get; set; }
    }
}