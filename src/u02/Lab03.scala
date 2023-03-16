package u02

import u02.Optionals.Option
import u02.Optionals.Option.{None, Some}
import u02.ProductTypes.Point2D

import scala.annotation.tailrec

object Lab03 extends App {

  //Task 3a
  def isPositive(x: Int): String = x match
    case n if n >= 0 => "positive"
    case _ => "negative"

  val isPos: Int => String = _ match
    case n if n >= 0 => "positive"
    case _ => "negative"

  println("3a-Example of isPositive: ")
  println(isPositive(1) + " (should be positive)")
  println(isPositive(-1) + " (should be negative)")
  println(isPos(1) + " (should be positive)")
  println(isPos(-1) + " (should be negative)")

  //Task 3b
  private def negFun(p: String => Boolean): String => Boolean =
    !p(_)

  private val negVal: (String => Boolean) => String => Boolean =
    p => !p(_)

  val empty: String => Boolean = _ == "" // predicate on strings
  val notEmpty = negVal(empty) // which type of notEmpty?
  notEmpty("foo") // true
  notEmpty("") // false
  println("3b-Example of negVal: (should be true)")
  println(notEmpty("foo") && !notEmpty(""))

  //Task 3c
  private def negFunGeneric[A](p: A => Boolean): A => Boolean = !p(_)

  private val isNotANumber: Int => Boolean = _ => false
  private val isANumber = negFunGeneric(isNotANumber)
  println("3c-Example of negFunGeneric: (should be true)")
  println(isANumber(5))

  //Task 4
  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z

  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z

  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z

  println("4-Example of p1, p2, p3, p4: (should be true all of them))")
  println(p1(1)(2)(2))
  println(p2(1, 2, 2))
  println(p3(1)(2)(2))
  println(p4(1, 2, 2))

  // Task 5
  // As we want to return a function, we need to define the type of the function
  private def compose(f: Int => Int, g: Int => Int): Int => Int =
    n => f(g(n))

  private def genericCompose[A, B, C](f: A => B, g: C => A): C => B =
    n => f(g(n))

  val f: Int => Int = x => x + 1
  val g: Int => Int = x => x + 1

  println("5-Example of compose: " + compose(f, g)(1) + " (should be 3)")
  println("5-Example of genericCompose: " + genericCompose(f, g)(1) + " (should be 3)")

  // Task 6
  @tailrec
  private def gcd(a: Int, b: Int): Int = b match
    case b if b == 0 => a
    case _ => gcd(b, a % b)

  println("6-Test GCD of 14 and 7: " + gcd(14, 7) + " (should be 7)")

  //Task 7
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
      case Rectangle(h, w) => Math.abs(point.x) <= w / 2 && Math.abs(point.y) <= h / 2
      case Circle(r) => Math.abs(point.x) <= r && Math.abs(point.y) <= r
      case Square(s) => Math.abs(point.x) <= s / 2 && Math.abs(point.y) <= s / 2

  //Task 8
  enum Option[A]:
    case Some(a: A)
    case None() // here parens are needed because of genericity

  object Option:
    def filter[A](opt: Option[A])(pred: (A => Boolean)): Option[A] = opt match
      case Some(a) if pred(a) => Some(a)
      case _ => None()

    def map[A, B](opt: Option[A])(m: (A => B)): Option[B] = opt match
      case Some(a) => Some(m(a))
      case _ => None()

    def fold[A, B](opt: Option[A])(default: B)(lambda: A => B): B = opt match
      case Some(a) => lambda(a)
      case _ => default

}
