package chapter2

object CustomStack extends Stack {
  trait Stack[+A]
  case object Nil extends Stack[Nothing]
  case class Cons[A](x: A, xs: Stack[A]) extends Stack[A]

  def empty[A] = Nil

  def isEmpty[A](xs: Stack[A]) = xs match {
    case Nil => true
    case _   => false 
  }

  def cons[A](x: A, xs: Stack[A]) = Cons(x, xs)

  def head[A](xs: Stack[A]) = xs match {
    case Cons(x, _) => x
    case _          => throw new Exception("calling head on empty list")
  }

  def tail[A](xs: Stack[A]) = xs match {
    case Cons(_, ys) => ys
    case _           => throw new Exception("calling tail on empty list")
  }
}
