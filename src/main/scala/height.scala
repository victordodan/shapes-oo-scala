package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object height:
  def apply(s: Shape): Int = s match
    case Rectangle(_, _) => 0
    case Ellipse(_, _) => 0
    case Location(_, _, shape) => 1 + apply(shape)
    case Group(shapes*) =>
      if shapes.isEmpty then 0
      else 1 + shapes.map(apply).max

end height
