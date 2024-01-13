import scala.util.matching._
import java.time._

// In Scala String as values in double quotes ""
val a: String = "Hello"
println(a)

// But for Multiline Strings, we have to Concatenate multiple lines with \n at end
val b: String = "Hello \n" +
    "Hi \n" +
    "Buh Bye"
println(b)

// But there are smart strings in Scala where we can generate multi line strings easily
val c: String = """Hello
                   Hi
                   Buh Bye"""
println(c)

// As you can see. the spaces in new line are considered part of string. But we can strip it easily using stripMargin method
val d: String = """Hello
                   |Hi
                   |Buh Bye""".stripMargin('|')
println(d)

// As these smart strings does not have special meanng for \, it makes regex easy
val data: String = "Hello Its 03:00 PM"
val regex1: Regex = "\\s*\\d?\\d:\\d\\d\\s*(AM|PM)".r
println(regex1.findAllIn(data).toList)

// Now same can be written with smart string without useless \\
val regex2: Regex = """\s*\d?\d:\d\d\s*(AM|PM)""".r
println(regex2.findAllIn(data).toList)

// String Formatting
// We can use .format method on Stiring for parameter replacement
// example
println("Hey there, this is %s".format("Test"))

// And position of parameter can speficied as - %{position}:${format}
println("Hey there... %3$s, %2$s, %1$s ... Go".format("One", "Two", "Three"))

// And it also support Date Time replacement wth %t{format}
println("Today is %1$te %1$tB of year %1$tY".format(LocalDate.now))

// String Interpolation
// Scala also has string using s or f string
// s"" String as basic interpolation without lot of format options
// Example
val e: Int = 32
println(s"Your age is ${e}")

// f"" string is advanced and can be used for more formating. It combines s string and String Format
// example - We can define a float precission format.
println(f"Your age is ${e}%1.2f")
