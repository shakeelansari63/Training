import scala.concurrent.Future
import scala.util.Success
import scala.util.Failure
import scala.concurrent.Await
object AsyncAndFutures extends App {
    // This is a blocking Method
    def blockingMethod(x: Int): Int = {
        println("Sleeping for 5 seconds...")
        Thread.sleep(5000) // Sleep 5 Sec
        x + 42
    }

    // So when we call it, it will wait for 5 seconds before returning value
    println(blockingMethod(22))
    // This will also block following statement, until it is complete
    println("Done Waiting...1")

    // Now To make this Asynchronous, we can use Future
    // Following implicit line is needed for providing Excutin context for Future Executins
    import scala.concurrent.ExecutionContext.Implicits.global

    // Async Method
    def asyncMethod(x: Int): Future[Int] = Future {
        println("Sleeping for 5 seconds...")
        Thread.sleep(5000) // Sleep 5 Sec
        x + 42
    }

    // So when we call it, the asyncMethod will be spawned on its own thread.
    println(asyncMethod(22))
    // And following Statement will be executed immediately
    println("Done Waiting...2")

    // But in Async function you will notice some issue in Print, it did not print the the value 22 + 42, but it printed Future object
    // So how to avoid this issue, to avoid this, we have to tell scala to do something when Future is complete and evaluated.
    // This si done with onComplete. it returns Try object. Meaning, it can either be success or failure
    asyncMethod(22).onComplete {
        case Success(value)     => println(value)
        case Failure(exception) => println(s"something went wrong - ${exception.getMessage}")
    }
    println("Done Waiting...3")

    // Though we have added onComplete, our code block is not allowed to complete, since it reach end of script before it can be complete
    // And our Project ends
    // So if you want to wait till a future is completed, use Await

    // With println
    import scala.concurrent.duration._
    println(Await.result(asyncMethod(22), atMost = 10.seconds))
    // This will wait maximum 10 second for Future to complete and print result
    // Now you will also notice, since we allowed our last statement to wait, previous statement also got time to complete
    // And it also printed 64

    // Future object also support some methods like map, which will be applied on result once future is complete
    println(Await.result(asyncMethod(22).map(x => x + 10), atMost = 10.seconds))

    // Scala also provide some useful methods to work with multiple futures / collection of futures
    // Lets create a list of futures
    val f1: () => Future[String] = () =>
        Future {
            Thread.sleep(500)
            "This is Future 1"
        }

    val f2: () => Future[String] = () =>
        Future {
            Thread.sleep(500)
            "This is Future 2"
        }

    val f3: () => Future[String] = () =>
        Future {
            Thread.sleep(500)
            "This is Future 3"
        }

    // Now if we want to run these but need data from only 1st Future, we can do following
    println(
      Await.result(
        Future.firstCompletedOf(List(f1(), f2(), f3())),
        1.second
      )
    )

    // And if we need data from all in a collection, that is done with sequence
    println(
      Await.result(
        Future.sequence(List(f1(), f2(), f3())),
        1.second
      )
    )
}
