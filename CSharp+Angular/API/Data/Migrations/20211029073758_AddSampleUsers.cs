using Microsoft.EntityFrameworkCore.Migrations;

namespace API.Data.Migrations
{
    public partial class AddSampleUsers : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            //Sql("Insert into User (Id, UserName) values (1, 'Bob');");
            migrationBuilder.InsertData(
                table: "User",
                columns: new string[] { "Id", "UserName" },
                values: new string[] { "1", "Bob" }
            );

            migrationBuilder.InsertData(
                table: "User",
                columns: new string[] { "Id", "UserName" },
                values: new string[] { "2", "Tom" }
            );

            migrationBuilder.InsertData(
                table: "User",
                columns: new string[] { "Id", "UserName" },
                values: new string[] { "3", "Jane" }
            );
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {

        }
    }
}
