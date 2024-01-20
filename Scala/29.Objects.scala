// In Scala we do not have Static class or static method
// In Scala we have Object, Object is just object which is not created from any class
// An object will have only 1 instance meaning it is singleton / static
// e.g.
object myObejct {
    def sayHello = println("Hello")
}

myObejct.sayHello

println(myObejct)

// We cannot inherit from Object, But Object can inherit from other class object
case class T1Class(msg: String)
object myObject2 extends T1Class("How are you??") {
    def greet = println(msg)
}

myObject2.greet
println(myObject2)
// Since toSring is overriden in T1Class and myObject2 inherit from it, it will print T1Class(How are you??)
// So if we print object it shows obejct without any formatting
// And to tackle it, just Like Case classes, we can also have case Objects which come with benefits of case class
// e.g.
class Weather(val name: String)

// Some basic Objects of Trait
object Sunny extends Weather("Sunny")

// Some case Objects of Trait
case object SunnyX extends Weather("Sunny")

// Lets print the objects
println(Sunny)
println(SunnyX)
