package u02

object Lab extends App:
  private def positive(x: Int): String = x match
    case n if n >= 0 => "positive"
    case n if n < 0 => "negative"

  private def neg(predicate :(String => Boolean)) : String => Boolean =
    !predicate(_)

  val empty: String => Boolean = _ == "" // predicate on strings
  val notEmpty = neg(empty) // which type of notEmpty?
  notEmpty("foo") // true
  notEmpty("") // false
  notEmpty("foo") && !notEmpty("") // true.. a comprehensive test

  private def genericNeg [T] (predicate: (T => Boolean)) : (T => Boolean) =
    !predicate(_)
  println(positive(5))

  //takes 3 ints and returns a boolean, curryfied and using val
  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  val p2: (Int, Int, Int) => Boolean = (x: Int, y: Int, z: Int) => x <= y && y == z

  def p3(x : Int) (y : Int) (z : Int) : Boolean =
    x <= y && y == z
  def p4(x : Int, y : Int, z : Int) : Boolean =
    x <= y && y == z

  println(p1(1)(1)(1))
  println(p2(1,1,1))
  println(p3(1)(1)(1))
  println(p4(1,1,1))

  def compose(f : Int => Int, g : Int => Int) : Int => Int
  = n => f(g(n))

  def genericCompose[A, B, C] (f : B => C, g : A => B) : A => C
  = n => f(g(n))

  val f: Int => Int = x => x + 1
  val g: Int => Int = x => x + 2
  println(genericCompose(f, g) (5))



  def gcd(a: Int, b: Int) : Int = (a, b) match
    case (_, b) if b == 0 => a
    case _ => gcd(b, a%b)


