using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using API.Data;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

namespace API.Extensions
{
    public static class ApplicationExtension
    {
        public static IServiceCollection AddApplicationExtension(this IServiceCollection services, IConfiguration config)
        {
            // Inject DBContext
            services.AddDbContext<DataContext>(option =>
            {
                // Use Sqlite Provider with Connection String
                option.UseSqlite(config.GetConnectionString("DefaultConnection"));
            });
            
            return services;
        }
    }
}