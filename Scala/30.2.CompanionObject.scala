// Here we will see how Companion object have access to private members of class
case class NormalPerson(name: String, private val superheroName: String)

object NormalPerson {
  // Though superheroName is private, it can be accessed in companion object
  def revealSecretIdentity(x: NormalPerson) = x.superheroName
}

// Main method
object SuperHeroRunner extends App {
  val clarke = NormalPerson("Clark Kent", "Superman")
  val natasha = NormalPerson("Natasha Romanohf", "Black Widow")
  val diana = NormalPerson("Diana Prince", "Wonder Woman")

  // Lets reweal
  println(NormalPerson.revealSecretIdentity(clarke))
  println(NormalPerson.revealSecretIdentity(natasha))
  println(NormalPerson.revealSecretIdentity(diana))
}
