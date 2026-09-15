package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

import TestFixtures.*
import Shape.*

class TestHeight:

  @Test
  def testSimpleRectangle(): Unit =
    assertEquals(0, height(simpleRectangle))

  @Test
  def testSimpleEllipse(): Unit =
    assertEquals(0, height(simpleEllipse))

  @Test
  def testSimpleLocation(): Unit =
    assertEquals(1, height(simpleLocation))

  @Test
  def testBasicGroup(): Unit =
    assertEquals(1, height(basicGroup))

  @Test
  def testSimpleGroup(): Unit =
    assertEquals(2, height(simpleGroup))

  @Test
  def testComplexGroup(): Unit =
    assertEquals(5, height(complexGroup))

end TestHeight
