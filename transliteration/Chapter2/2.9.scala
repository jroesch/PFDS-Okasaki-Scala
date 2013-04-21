package chapter2

trait Ordered {
  type T

  def eq(x: T, y: T): Boolean
  def lt(x: T, y: T): Boolean
  def lteq(x: T, y: T): Boolean
}

object IntOrdered extends Ordered {
  type T = Int

  def eq(x: T, y: T) = x == y
  def lt(x: T, y: T) = x < y
  def lteq(x: T, y: T) = x <= y
}

object UnbalancedSet { 
  def apply(Element: Ordered): Set { type Elem = Element.T } = new Set {
    type Elem = Element.T

    sealed trait Tree
    case object E extends Tree
    case class T(right: Tree, elem: Elem, left: Tree) extends Tree

    type Set = Tree

    def empty = E

    def member(e: Elem, s: Set) = (e, s) match {
      case (x, E) => false
      case (x, T(a, y, b)) =>
        if (Element.lt(x,y)) member(x, a)
        else if (Element.lt(y, x)) member(x, b)
        else true
    }

    def insert(e: Elem, s: Set) = (e, s) match {
      case (x, E) => T(E, x, E)
      case (x, s@T(a, y, b)) =>
        if (Element.lt(x,y)) T(insert(x, a), y, b)
        else if (Element.lt(y, x)) T(a, y, insert(x, b))
        else s
    }
  }
}

 
