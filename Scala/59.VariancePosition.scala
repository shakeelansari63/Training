object VariancePosition extends App {
    // Lets say we have some class and subclasses
    class Animal
    class Dog extends Animal
    class Cat extends Animal
    class Rat extends Animal

    // That was good, Now we create a new class which can accept generic type
    class SomeThing[T]
    // So, now the question is, if we substitute T with Dog, the is Something[Dog] same as Something[Animal]
    // Lets wrap our heads around this, what we are saying is if Dog is Animal, then is Something[Dog] a Something[Animal]?
    // On Other Words id `x: Animal = Dog` works, does y: `Something[Animal] = Something[Dog]` work?
    // This is called variance Problem
    // And we can have 3 answers to this question

    // Answer 1 - Yes Something[Dog] is Something[Animal] => This is called Covariant
    // e.g.
    class SomeList[+T] // +T denotes that SomeList is Covariant
    val a: SomeList[Animal] = new SomeList[Dog] // And this works

    // Answer 2 - Something[Dog] is not Something[Animal] => This is called Invariant
    // e.g.
    class SomePet[T] // T without + indicate it is invariant
    // val b: SomePet[Animal] = new SomePet[Dog] // This raise Error

    // Answer 3 - No but reverse is true i.e. Something[Animal] is Something[Dog] => This is called Contravariant
    // e.g.
    class Vet[-T] // -T indicate contravariant class
    // val c: Vet[Animal] = new Vet[Dog] // This will raise error
    val c: Vet[Dog] = new Vet[Animal] // This will work

    // Regular Issues we may see with Variance Position

    // 1 - Contravariant Type in Covariant Position (Class parameter)
    // Lets see following Example - It is commented as it raise error, Uncomemnt below lines
    // class VetX[-T](val favouriteAnimal: T) // We will see error here
    // // And why does error occur? because it allows us to do following
    // val garfield: Cat = new Cat
    // val theVet: VetX[Animal] = new VetX[Animal](favouriteAnimal = garfield)
    // // Here we have only initialized VetX[Animal], just set favouriteAnimal = garfield as Cat is also Animal
    // val lesslieVet: VetX[Dog] = theVet // This is possible due to Contarvariant class
    // // Now if we ask,
    // println(lesslieVet.favouriteAnimal) // As leslie is VetX dog, this should be Dog
    // // But lesslieVet points to theVet which is VetX[Animal] and its favouriteAnimal is Garfield which is Cat
    // // So this raises Type Mismatch.
    // // This is why, class VetX[-T](val favouriteAnimal: T) is wrong and compiler will not allow it to run.
    // // So Val fields in class are CoVariant positions, so we cannot have T type argument in Contravariant Class
    // // And Same is True to Var, they are also in CoVariant Position
    // // Which means following class will also raise error
    // class VetY[-T](var favouriteAnimal: T)

    // 2 - Covariant Type in Contravariant Position (Class parameter)
    // Lets take a List, as we know lists are covaraiant
    // Lets see following Example - It is commented as it raise error, Uncomemnt below lines
    // class SomeListX[+T](var first: T) // This will raise error
    // // And we can see as follow
    // val myList: SomeListX[Animal] = new SomeListX[Animal](new Dog) // So we have
    // // But Since first is var, we can re-assign it
    // myList.first = new Cat // And thsi is also possible
    // // But Cat Type is not Same as Dog Type, so this raises type mismatch
    // // This is why class SomeListX[+T](var first: T) is wrong
    // // And var is in Contravariant position
    // // But Didn't we already say that Var is CoVariant position?
    // // So Var is Invariant Position, and will only work with Invariant Types

    // 3 - Covariant Type in Contravariant Position (Method parameter)
    // Lets take a Covariant List and have some method
    // Lets see following Example - It is commented as it raise error, Uncomemnt below lines
    // class SomeListY[+T] {
    //     def add(element: T) = ??? // This raise error
    // }
    // // This raise an error as it allows us to do this
    // val myList2: SomeListY[Animal] = new SomeListY[Dog] // This is valid for covariant class
    // // Now since myList2 is SomeList[Animal], it will allow us to do following
    // myList2.add(new Dog) // This is valid as it is initialised with new SomeList[Dog]
    // myList2.add(new Cat) // This is also valid for Animal but raise type mismatch
    // // This tells us that Method Paramater is Contravariant position

    // 4 - Covariant Type in Contravariant Position (Method Return Type)
    // Lets see following Example - It is commented as it raise error, Uncomemnt below lines
    // abstract class VetZ[-T] {
    //     def rescueAnimal(): T // This will raise error
    // }
    // // This is because it allows us to do following
    // val vetZ1 = new VetZ[Animal] {
    //     override def rescueAnimal(): Animal = new Cat // This is allowed since Cat is Animal
    // }
    // // And now if we create another vet
    // val lesslieVetZ1: VetZ[Dog] = vetZ1 // This is allowed due to Contravariant
    // println(lesslieVetZ1.rescueAnimal) // This should return Dog type, but due to vetZ1, it returns Cat
    // // And this raise type mismatch
    // // So Method return Types are Contravariant
}
