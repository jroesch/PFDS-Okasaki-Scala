package chapter2 

import scala.language.higherKinds

trait Stack {
  type Stack[A]

  def empty[A]: Stack[A]

  def isEmpty[A](xs: Stack[A]): Boolean

  def cons[A](x: A, xs: Stack[A]): Stack[A]

  def head[A](xs: Stack[A]): A /* throws EmptyException */

  def tail[A](xs: Stack[A]): Stack[A] /* throws EmptyException */
}
