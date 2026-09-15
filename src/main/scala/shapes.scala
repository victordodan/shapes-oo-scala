package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) |
         Ellpise(w, h)           | Group(Shape)
*/

enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  case Ellipse(width: Int, height: Int)
  case Location(x: Int, y: Int, shape: Shape)
  case Group(shapes: Shape*)
  // TODO add missing cases (see test fixtures)
