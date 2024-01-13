// Companion Objects are object which work with class and they have same name as class
// Companion objects can access Class' private member and Class can access companion object's private memebers

// Here is example where class has access
case class SecretAgent(name: String) {
    // though redduceBullets is private, it can be accessed in this class
    def shoot(n: Int) = SecretAgent.reduceBullet(n)
}

// This is inventory which is static
object SecretAgent {
    private var b: Int = 3000

    private def reduceBullet(n: Int) = if (b - n < 0) b = 0 else b = b - n

    def bullets: Int = b
}

// Lets have main object
object RunnerX extends App {
    // Create  some agents obejcts
    val jason = SecretAgent("Jason Bourne")
    val james = SecretAgent("James Bond")
    val jagga = SecretAgent("Jagga Jasoos")

    // Shoot will reduce bullets
    jason.shoot(300)
    james.shoot(500)
    jagga.shoot(200)

    // Lets see left bullets
    println(SecretAgent.bullets)
}
