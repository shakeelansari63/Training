// Following Pre existing Data types exist in Scala
// Byte:       8 bit (-128 to 127)
val a: Byte = 124

// Short:     16 bit (-32768 to 32767)
val b: Short = 300

// Int:       32 bit
val c: Int = 123667

// Long:      64 bit
val d: Long = 32L

// Float:     32 bit
val e: Float = 32.8f   // Float value should end with F otherwise it can be considered double and you will see type mismatch
// Following will fail
// val f: Float = 32.8

// Double:    64 bit
val g: Double = 36.98D // The D at end of double is optional. Without D any floating point number is considered Double