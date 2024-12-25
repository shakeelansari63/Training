package main

import (
	"fmt"
	"log"
	"os"
	"time"

	"gorm.io/driver/postgres"
	"gorm.io/gorm"
	"gorm.io/gorm/logger"
)

// Models are defined by Structs in Gorm
// And specific field options are provided in struct tags
type User struct {
	gorm.Model
	ID   int    `gorm:"primaryKey"`
	Name string `gorm:"size:255"`
}

// We can create instance of DB using gorm
var DB *gorm.DB

// Lets have a method to connect to DB
func connectDatabase() {
	// Create logger for Database connetion
	logWriter := log.New(os.Stdout, "\n", log.LstdFlags)
	loggerConfig := logger.Config{
		SlowThreshold:             time.Second, // Slow SQL threshold
		LogLevel:                  logger.Info, // Log level
		IgnoreRecordNotFoundError: true,        // Ignore ErrRecordNotFound error for logger
		Colorful:                  true,        // Disable color
	}
	newLogger := logger.New(logWriter, loggerConfig)

	// Connection string for Database
	dbConnectionDSN := "host=localhost user=postgres password=Freak@123 dbname=postgres port=5432 sslmode=disable"

	// Create database connection
	database, err := gorm.Open(postgres.Open(dbConnectionDSN), &gorm.Config{Logger: newLogger})
	if err != nil {
		fmt.Println(err.Error())
		panic("Failed to connect Database...")
	}

	// If there is no error, return Db object
	DB = database
}

func main() {
	// Connect to Database
	connectDatabase()

	// Add Models in DB
	DB.AutoMigrate(&User{})

	// Delete everything from Table.
	// Unscoped Perform Hard Delete. Otherwise default behaviour is soft delete.
	DB.Where("1 = 1").Unscoped().Delete(&User{})

	// Create some Data
	u1 := User{
		ID:   1,
		Name: "John",
	}
	u2 := User{
		ID:   2,
		Name: "James",
	}
	u3 := User{
		ID:   3,
		Name: "Katie",
	}
	DB.Create(&u1)
	DB.Create(&u2)
	DB.Create(&u3)

	// Find Some Row
	var users []User
	DB.Where("name like ?", "J%").Find(&users)
	fmt.Println(users)

	// Get 1 Row from Table
	var u4 User
	DB.Where("id = ?", 2).First(&u4)
	fmt.Println(u4)

	// Update some Row
	u4.Name = "James C"
	DB.Save(&u4)
	// Check Updated user
	var u5 User
	DB.Where("id = ?", 2).First(&u5)
	fmt.Println(u5)
}
