import scala.util.matching._

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
