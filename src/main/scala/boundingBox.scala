package edu.luc.cs.laufer.cs371.shapes 

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case Rectangle(w, h) =>
      Location(0, 0, Rectangle(w, h))
    
    case Ellipse(w, h) =>
      Location(-w, -h, Rectangle(2 * w, 2 * h))
    
    case Location(x, y, shape) =>
      val Location(bx, by, Rectangle(bw, bh)) = apply(shape) : @unchecked
      Location(x + bx, y + by, Rectangle(bw, bh))
    
    case Group(shapes*) =>
      if shapes.isEmpty then
        Location(0, 0, Rectangle(0, 0))
      else
        val boxes = shapes.map(apply)
        val minX = boxes.map { case Location(x, _, _) => x }.min
        val minY = boxes.map { case Location(_, y, _) => y }.min
        val maxX = boxes.map { case Location(x, _, Rectangle(w, _)) => x + w }.max
        val maxY = boxes.map { case Location(_, y, Rectangle(_, h)) => y + h }.max
        Location(minX, minY, Rectangle(maxX - minX, maxY - minY))

end boundingBox
