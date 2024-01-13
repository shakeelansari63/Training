// Traits are like Java Interfaces. They can define behaviour
// And Traits are used for multiple Inheritance and building loosely coupled apps
// e.g.
abstract class Bike(val model: String) {
    // Implemented method
    def fuelCapacity = 30.0

    // Un-implemented method
    def gearType: Double
}

// And these are traits
trait Speed {
    def maxSpeed: Double
}

trait Engine {
    def engineType: String
    def engineOil: String
}

// Some differences between Abstract type and traits are
// 1) Abstract type can have constructor, but Traits have no constructor
// 2) Abstratc type can have implemented methods, but traits cannot have any implemented method

// Lets create a class using these Abstract type and traits
class Pulsar(model: String) extends Bike(model) with Speed with Engine {
    override def gearType: Double = 5.0
    override def fuelCapacity: Double = 35.0
    override def maxSpeed: Double = 300.00
    override def engineOil: String = "Castrol"
    override def engineType: String = "4 Stroke"
    override def toString(): String = s"Pulsar($model)"
}

// Now I can create object
val xp = new Pulsar("xp")
println(xp)
println(xp.gearType)
println(xp.maxSpeed)
println(xp.fuelCapacity)
println(xp.engineOil)
