package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

import TestFixtures.*
import Shape.*

class TestScale:

  @Test
  def testSimpleRectangle(): Unit =
    assertEquals(Rectangle(120, 180), scale(simpleRectangle, 1.5))
    assertEquals(Rectangle(160, 240), scale(simpleRectangle, 2.0))

  @Test
  def testSimpleEllipse(): Unit =
    assertEquals(Ellipse(75, 45), scale(simpleEllipse, 1.5))
    assertEquals(Ellipse(100, 60), scale(simpleEllipse, 2.0))

  @Test
  def testSimpleLocation(): Unit =
    assertEquals(Location(105, 45, Rectangle(120, 180)), scale(simpleLocation, 1.5))
    assertEquals(Location(140, 60, Rectangle(160, 240)), scale(simpleLocation, 2.0))

  @Test
  def testBasicGroup(): Unit =
    assertEquals(Group(Ellipse(75, 45), Rectangle(30, 60)), scale(basicGroup, 1.5))
    assertEquals(Group(Ellipse(100, 60), Rectangle(40, 80)), scale(basicGroup, 2.0))

  @Test
  def testSimpleGroup(): Unit =
    assertEquals(
      Group(
        Location(300, 150, Ellipse(75, 45)),
        Location(600, 450, Rectangle(150, 75))
      ),
      scale(simpleGroup, 1.5)
    )
    assertEquals(
      Group(
        Location(400, 200, Ellipse(100, 60)),
        Location(800, 600, Rectangle(200, 100))
      ),
      scale(simpleGroup, 2.0)
    )

  @Test
  def testComplexGroup(): Unit =
    assertEquals(
      Location(75, 150,
        Group(
          Ellipse(30, 60),
          Location(225, 75,
          Group(
            Rectangle(75, 45),
            Rectangle(450, 90),
            Location(150, 300,
              Ellipse(75, 45)
            )
        )),
        Rectangle(150, 300)
      )),
      scale(complexGroup, 1.5)
    )
    
    assertEquals(
      Location(100, 200,
        Group(
          Ellipse(40, 80),
          Location(300, 100,
          Group(
            Rectangle(100, 60),
            Rectangle(600, 120),
            Location(200, 400,
              Ellipse(100, 60)
            )
        )),
        Rectangle(200, 400)
      )),
      scale(complexGroup, 2.0)
    )

end TestScale
