package example

object Lists:

  /**
   * This method computes the sum of all elements in the list xs. There are
   * multiple techniques that can be used for implementing this method, and
   * you will learn during the class.
   *
   * For this example assignment you can use the following methods in class
   * `List`:
   *
   *  - `xs.isEmpty: Boolean` returns `true` if the list `xs` is empty
   *  - `xs.head: Int` returns the head element of the list `xs`. If the list
   *    is empty an exception is thrown
   *  - `xs.tail: List[Int]` returns the tail of the list `xs`, i.e. the the
   *    list `xs` without its `head` element
   *
   *  ''Hint:'' instead of writing a `for` or `while` loop, think of a recursive
   *  solution.
   *
   * @param xs A list of natural numbers
   * @return The sum of all elements in `xs`
   */
  def generateSum(acc: Int, idx: Int, lst: List[Int]): Int = 
    if (idx >= lst.length) acc
    else generateSum(acc + lst(idx), idx+1, lst)

  def sum(xs: List[Int]): Int = generateSum(0, 0, xs)

  /**
   * This method returns the largest element in a list of integers. If the
   * list `xs` is empty it throws a `java.util.NoSuchElementException`.
   *
   * You can use the same methods of the class `List` as mentioned above.
   *
   * ''Hint:'' Again, think of a recursive solution instead of using looping
   * constructs. You might need to define an auxiliary method.
   *
   * @param xs A list of natural numbers
   * @return The largest element in `xs`
   * @throws java.util.NoSuchElementException if `xs` is an empty list
   */
  def genearteMax(acc: Int, idx: Int, lst: List[Int]): Int = 
    if (lst.length == 0) throw java.util.NoSuchElementException("No max in empty list")
    else if (idx >= lst.length) acc
    else genearteMax(if (acc > lst(idx)) acc else lst(idx), idx + 1, lst)

  def max(xs: List[Int]): Int = genearteMax(Int.MinValue, 0, xs)
