package chapter2

object List extends Stack {
  type Stack[A] = List[A]

  def empty[A] = Nil

  def isEmpty[A](xs: Stack[A]) = xs match {
    case Nil => true
    case _   => false 
  }

  def cons[A](x: A, xs: Stack[A]) = x :: xs

  def head[A](xs: Stack[A]) = xs.head

  def tail[A](xs: Stack[A]) = xs.tail
}

