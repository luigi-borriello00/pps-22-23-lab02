package u02

import u02.ProductTypes.Point2D

object Lab03 extends App {

  //3a
  def isPositive(x: Int): String = x match
    case n if n >= 0 => "positive"
    case _ => "negative"

  val isPos: Int => String = _ match
    case n if n >= 0 => "positive"
    case _ => "negative"

  println(isPositive(1))
  println(isPositive(-1))
  println(isPos(1))
  println(isPos(-1))

  //3b
  private def negFun(p: String => Boolean): String => Boolean =
    !p(_)

  private val negVal: (String => Boolean) => String => Boolean =
    p => !p(_)

  val empty: String => Boolean = _ == "" // predicate on strings
  val notEmpty = negVal(empty) // which type of notEmpty?
  notEmpty("foo") // true
  notEmpty("") // false
  println(notEmpty("foo") && !notEmpty(""))

  //3c
  private def negFunGeneric[A](p: A => Boolean): A => Boolean = !p(_)

  private val isNotANumber: Int => Boolean = _ => false
  private val isANumber = negFunGeneric(isNotANumber)
  println(isANumber(5))

  //4
  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z

  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z

  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z

  //5
  // As we want to return a function, we need to define the type of the function
  private def compose(f: Int => Int, g: Int => Int): Int => Int =
    n => f(g(n))

  private def genericCompose[A, B, C](f: A => B, g: C => A): C => B =
    n => f(g(n))

  val f: Int => Int = x => x + 1
  val g: Int => Int = x => x + 1
  println("Compose Function: " + compose(f, g)(1))
  println("Generic Compose Function: " + compose(f, g)(1))

  //6
  def gcd(a: Int, b: Int): Int = (a, b) match
    case (_, b) if b == 0 => a
    case _ => gcd(b, a % b)

  println("Test GCD of 14 and 7: " + gcd(14, 7))

  //7
  enum Shape:
    case Rectangle(h: Double, w: Double)
    case Circle(r: Double)
    case Square(s: Double)

  object Shape:
    def perimeter(shape: Shape): Double = shape match
      case Rectangle(h, w) => (h * 2) + (w * 2)
      case Circle(r) => 2 * r * Math.PI
      case Square(s) => s * 4
    def contains(shape: Shape, point: Point2D): Boolean = shape match
      case Rectangle(h, w) => Math.abs(point.x) <= w/2 && Math.abs(point.y) <= h/2
      case Circle(r) => Math.abs(point.x) <= r && Math.abs(point.y) <= r
      case Square(s) => Math.abs(point.x) <= s/2 && Math.abs(point.y) <= s/2
}
