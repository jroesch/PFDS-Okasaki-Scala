package chapter2

trait Set {
  type Elem
  type Set

  def empty: Set
  def insert(e: Elem, s: Set): Set
  def member(e: Elem, s: Set): Boolean
}
