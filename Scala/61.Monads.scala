import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

object Monads extends App {
    // Lets say we have a class where we wrap some values
    case class SafeValue[T](private val internalVal: T) {
        // This is a method to get the value from object
        def get: T = internalVal

        // And we have a method to transform the internal Value with some transformation
        def transform(transformer: T => SafeValue[T]): SafeValue[T] = transformer(internalVal)
    }

    // Now lets say we have some externaal API which gives us object wrapped in Safe value
    def giveMeSomeSafeValue[T](value: T): SafeValue[T] = SafeValue(value)

    // Now here is interesting part..
    // We get a value from this external api
    val someString = giveMeSomeSafeValue("safeString") // This give SafeValue[String]
    println(someString)

    // Now we waant to extract the string from safe value, convert it to upper case and again wrap it in SafeValue
    // So we can do this
    val extractedSafeValue = someString.get
    println(extractedSafeValue)
    val upperString = extractedSafeValue.toUpperCase
    println(upperString)
    val safeStringInUpperCase = SafeValue(upperString)
    println(safeStringInUpperCase)

    // This is call ETW pattern, or Extract-Transform-Wrap
    // We can also use the Transform method to do same
    val transformedSafeVal = someString.transform((x: String) => SafeValue(x.toUpperCase))
    println(transformedSafeVal)

    // These cases where we have the ETW pattern, we need a Monad
    // Here are some examples of ETW Pattern

    // ETW Pattern 1 -
    // Lets say we have a classfor which parameters are required
    // It throws an exception if null is passed
    case class Person(fname: String, lname: String) {
        assert(fname != null && lname != null)
    }

    // Now we need to create an API, where we take user Inputs and return Person Object
    def personApi(fname: String, lname: String): Person =
        // And we write some defensive code to avoid nulls
        if (fname == null || lname == null) null
        else Person(fname, lname)

    println(personApi(null, "Doe"))
    println(personApi("John", null))
    println(personApi("John", "Doe"))

    // This will work, but what if there are many parameters in Person class, wwe will have to write defence against all scenarios
    // But defining return as Person and returning null is not right
    // In this case the user of this API will also have to write defensive code

    // We can resolve this with Options
    def betterPersonApi(fname: String, lname: String): Option[Person] =
        // Now we know fname and lname can be Null, so we can wrap them in Option and use flatMap on Option to get and trasnform value
        Option(fname).flatMap { firstN =>
            Option(lname).flatMap { lastN =>
                Option(Person(firstN, lastN))
            }
        }

    println(betterPersonApi(null, "Doe"))
    println(betterPersonApi("John", null))
    println(betterPersonApi("John", "Doe"))

    // Or we can do For Comprehension
    def betterPersonApiFor(fname: String, lname: String): Option[Person] = for {
        firstN <- Option(fname)
        lastN <- Option(lname)
    } yield Person(firstN, lastN)

    println(betterPersonApiFor(null, "Doe"))
    println(betterPersonApiFor("John", null))
    println(betterPersonApiFor("John", "Doe"))

    // So how is this ETW, Because we have wrapped fname and lname in Options
    // Then we Extract Option, Create Object of Person and Again Wrap object in Option

    // ETW Pattern 2 -
    // Lets say we have some Async Methods
    // These are models
    case class User(name: String)
    case class Product(sku: String, price: Double)

    // And we have 2 Async APIs
    def getUser(url: String): Future[User] = Future {
        User("denise") // Just example, the code can be complex
    }

    def getUserProduct(username: String): Future[Product] = Future {
        Product("soap", 9.99)
    }

    // Now we have a URL, and we first want to get user and then user product
    // But since these calls are async, we may write something like this
    val url = "mystore.com/user/2"

    getUser(url).onComplete {
        case Success(User(name)) =>
            getUserProduct(name).onComplete {
                case Success(Product(sku, price)) => {
                    println(s"Total price is ${price * 1.02}") // 2% tax
                }
                case Failure(exception) => println(s"Error - ${exception.getMessage}")
            }
        case Failure(exception) => println(s"Error - ${exception.getMessage}")
    }

    // But this way to waiting for completion can be clumsy, and and easier way would be to use flatMap on Futures
    val totalPrice: Future[Double] = getUser(url).flatMap(u => getUserProduct(u.name).map(p => p.price * 1.02))

    totalPrice.onComplete {
        case Success(value)     => println(s"Total price is $value")
        case Failure(exception) => println(s"Error - ${exception.getMessage}")
    }

    // Or we can use for comprehension
    val totalPriceFor: Future[Double] = for {
        user <- getUser(url)
        product <- getUserProduct(user.name)
    } yield product.price * 1.02

    totalPriceFor.onComplete {
        case Success(value)     => println(s"Total price is $value")
        case Failure(exception) => println(s"Error - ${exception.getMessage}")
    }

    // So where is the ETW pattern here?
    // It is with Futures, we need to extract value from future, transform price by adding 2% tax and again wrap it in Future

    // These Options, Futures or even Lists (as we know we can flatMap and for comprehension on Lists) are monads

    // Properties of Monads
    // 1 - Monads have a pure / Unit which convert a literal value to Monad
    // e.g. Constructors of Options/Future/List convert plain value to object of that type
    // Meaning they wrap the value in container
    // In our SafeValue class, its constructor is Pure/Unit

    // 2 - Mondas have a transform method which can perform ETW task
    // e.g. flatMap methon on Options/Futures/Lists perform ETW
    // In our case our trasnform method was performing ETW in SafeValue class

    // 3 - Left Identity
    // It simply says, if we have a Monad(x) and we apply flatMap on it with function `f` the result will be f(x)
    // i.e. Monad(x).flatMap(f) = f(x)
    // This property can be explained with following example
    val twoConsecutive: Int => List[Int] = x => List(x, x + 1)
    // So if we apply twoConsecutive function on 3, we will get List(3, 4)
    println(twoConsecutive(3)) // List(3, 4)
    // And if we have a monad i.e. List(3) and we apply flatmap with twoConsecutive function result will be same
    println(List(3).flatMap(twoConsecutive)) // List(3, 4)

    // 4 - Right Identity
    // If we have Monad(x) and we apply a flatMap with Function which return Pure/Unit the operation has no efffect
    // i.e. Monad(x).flatMap(y => Monad(y)) = Monad(x)
    // e.g.
    println(List(1, 2, 3).flatMap(x => List(x))) // List(1,2,3)

    // 5 - Associativity
    // This is a complex one to wrap our head arround
    // What associativity says is if we chain flatmaps with 2 functions, it should be equal to single flatmap where
    // first function is applied and then second function will be applied to every result of first method
    // i.e. Monad(x).flatMap(f).flatMap(g) == Monad(x).flatMap(y => f(y).flatMap(g)) == Monad(x).flatMap(y => f(y).flatMap(z => g(z)))
    // Lets see this with example
    val incrementor: Int => List[Int] = x => List(x, x + 1)
    val doubler: Int => List[Int] = x => List(x, x * 2)
    println(List(1, 2, 3).flatMap(incrementor).flatMap(doubler)) // List(1,2,2,4, 2,4,3,6, 3,6,4,8)
    println(List(1, 2, 3).flatMap(x => incrementor(x).flatMap(doubler))) // List(1,2,2,4, 2,4,3,6, 3,6,4,8)
    println(List(1, 2, 3).flatMap(x => incrementor(x).flatMap(y => doubler(y)))) // List(1,2,2,4, 2,4,3,6, 3,6,4,8)
    /*
     * So List(1,2,3).flatMap(incrementor).flatMap(doubler))
     * Is same as
     * List(
     *  incrementor(1).flatMap(doubler),
     *  incrementor(2).flatMap(doubler),
     *  incrementor(3).flatMap(doubler),
     * )
     */
}
