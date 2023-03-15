package u02;

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import u02.Lab03.Shape
import u02.ProductTypes.Point2D

class ShapeExTests {
  
  val circleRadius = 10
  val squareSide = 10
  val rectHeight = 10
  val rectWidth = 20

  val rectangle: Shape = Shape.Rectangle(rectHeight, rectWidth)
  val circle: Shape = Shape.Circle(circleRadius)
  val square: Shape = Shape.Square(squareSide)


  @Test def testPerimeter() =
    assertEquals(rectWidth * 2 + rectHeight * 2, Shape.perimeter(rectangle))
    assertEquals(circleRadius * 2 * Math.PI, Shape.perimeter(circle))
    assertEquals(squareSide * 4, Shape.perimeter(square))

  @Test def testContains() =
    val p = Point2D(0, 0)
    assertTrue(Shape.contains(rectangle, p))
    assertTrue(Shape.contains(circle, p))
    assertTrue(Shape.contains(square, p))

    val p2 = Point2D(100, 100)
    assertFalse(Shape.contains(rectangle, p2))
    assertFalse(Shape.contains(circle, p2))
    assertFalse(Shape.contains(square, p2))
    // edge cases
    assertFalse(Shape.contains(rectangle, Point2D(0, 10)))
    assertTrue(Shape.contains(rectangle, Point2D(10, 0)))
    assertFalse(Shape.contains(circle, Point2D(11, 0)))
    assertFalse(Shape.contains(square, Point2D(11, 0)))

}
