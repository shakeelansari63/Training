object SelfTypes extends App {
    // Lets start with some Traits/Types
    sealed trait Edible
    case object Fish extends Edible
    case object Chicken extends Edible
    case object Spinach extends Edible
    case object Bread extends Edible

    trait Person {
        def hasAllergies(thing: Edible): Boolean
    }

    trait Diet {
        def canEat(thing: Edible): Boolean
    }

    // Now the 2 types Diet and Person are seperate, but we need to have a requires relation between then
    // What that mean is, if we extend a Diet Trait, we must also extend a person, so Diet requires Person
    // And that is because CanEat method of Diet depends on if person has allergy to a thing or not
    // So how can we achieve it
    // Here are 3 options

    // Option 1 - Subtype Diet from Person
    trait Person1 {
        def hasAllergies(thing: Edible): Boolean
    }

    trait Diet1 extends Person1 {
        def canEat(thing: Edible): Boolean
    }

    // So we can now add some more traits
    trait Adult1 extends Person1
    trait Child1 extends Person1
    trait Vegetarian1 extends Diet1
    trait Carnivore1 extends Diet1

    // And wee can create a concrete class/object
    case object VegetarianAthlete1 extends Vegetarian1 {
        override def hasAllergies(thing: Edible): Boolean = thing match {
            case Fish | Chicken  => true
            case Spinach | Bread => false
        }

        override def canEat(thing: Edible): Boolean =
            if (hasAllergies(thing)) false
            else true
    }

    println(VegetarianAthlete1.canEat(Fish))

    // And we have achieved what we need, we have made canEat Dependent on hasAllergies
    // But this approach is not right.
    // And the reason is subclassing Diet from Person
    // Inheritance is always used for Is A Relation. But here Diet is not a Person
    // So this is wrong

    // Option 2 - Using Generic Type
    trait Person2 {
        def hasAllergies(thing: Edible): Boolean
    }

    trait Diet2[T <: Person2] {
        def canEat(thing: Edible): Boolean
    }

    // Here the Generic Type Annotation makes sure that Diet can only be extended by class/object of type Person
    // So our further traits will look like
    trait Adult2 extends Person2
    trait Child2 extends Person2
    trait Vegetarian2[T <: Person2] extends Diet2[T]
    trait Carnivore2[T <: Person2] extends Diet2[T]

    // Now we can create concrete Class/Object
    case object VegetarianAthlete2 extends Vegetarian2[Adult2] {
        override def canEat(thing: Edible): Boolean = ???
    }

    // Now we have only used Generic Type, but that does not give us access to Person objects hasAllergies method

    // Option 3 - Self Types
    trait Person3 {
        def hasAllergies(thing: Edible): Boolean
    }

    trait Diet3 { self: Person3 => // This is self type
        def canEat(thing: Edible): Boolean
    }

    // The self:Person => Notation on traits tells compiler that the Diet trait required Person Trait
    // meaning if any class / object extend Diet, it must also extend person
    // So now other traits can be
    trait Adult3 extends Person3
    trait Child3 extends Person3
    trait Vegetarian3 extends Diet3 with Person3
    trait Carnivore3 extends Diet3 with Person3

    // And out concrete class/object can look like
    case object VegetarianAthlete3 extends Vegetarian3 with Adult3 {
        override def hasAllergies(thing: Edible): Boolean = thing match {
            case Fish | Chicken  => true
            case Spinach | Bread => false
        }

        override def canEat(thing: Edible): Boolean =
            if (hasAllergies(thing)) false
            else true
    }
    println(VegetarianAthlete3.canEat(Chicken))
    println(VegetarianAthlete3.canEat(Bread))

    // So in Short, Self Types are used for creting required relation between 2 classes/ traits

    // What self type also allows us to do is, implements some methods in trait itself with help of Injected Class
    // e.g.
    trait Person4 {
        def hasAllergies(thing: Edible): Boolean
    }

    trait Diet4 { self: Person4 => // This is self type
        def canEat(thing: Edible): Boolean =
            if (self.hasAllergies(thing)) false
            else true
    }

    // So when we create the child traits an actually implement the traits, we don't have to implement the canEat method
    trait Adult4 extends Person4
    trait Child4 extends Person4
    trait Vegetarian4 extends Diet4 with Person4
    trait Carnivore4 extends Diet4 with Person4

    case object VegetarianAthlete4 extends Vegetarian4 with Adult4 {
        override def hasAllergies(thing: Edible): Boolean = thing match {
            case Fish | Chicken  => true
            case Spinach | Bread => false
        }
    }

    println(VegetarianAthlete4.canEat(Fish))
    println(VegetarianAthlete4.canEat(Spinach))
}
