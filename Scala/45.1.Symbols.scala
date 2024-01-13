// Symbols are like Strings but they are always interned
// e.g.
object Symbols extends App {
    // Lets say we have 2 string with same value
    val s1 = new String("CO")
    val s2 = new String("CO")

    // Now are these 2 strings same, lets compare
    println(s1 == s2) // == only compares values - True
    println(s1 eq s2) // eq compares references - False

    // Now lets create Strings in traditional way
    val s3 = "COP"
    val s4 = "COP"

    // And compare now
    println(s3 == s4) // == only compares values - True
    println(s3 eq s4) // eq compares references. This is unsure. Sometime it can be true/ sometime it can be false

    // The reason s3 eq s3 sometime can be true and sometime cna be false id due to being interned.
    // Scala has ways to save memory, if strings have save value,
    // they can be said as interned and scala will not create new reference always.
    // But this interned method is not deterministic. This is where Symbols come in
    // Symbol are Strings which are always interned

    val ss1 = Symbol("CO") // Create Symbol using Symbol.apply
    // Until scala 2, symbols can also be created using short hand val ss1 = 'CO -- Note only leading quote no trailing.
    // To use it in scala 3 version, we have to import deprecated symbols
    // import scala.language.deprecated.symbolLiterals
    val ss2 = 'CO // Only work in Scala 2

    // Now lets compare
    println(ss1 == ss2) // == only compares values - True
    println(ss1 eq ss2) // eq compares references - True
}
