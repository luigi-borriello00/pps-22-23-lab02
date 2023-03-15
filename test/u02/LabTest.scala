package u02;

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import u02.Lab03.Shape
import u02.ProductTypes.Point2D

class LabTest {
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

}
