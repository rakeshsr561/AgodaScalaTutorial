

sealed class IntTree

case object EmptyTree extends IntTree

case class Node(elem: Int, var left: IntTree, var right: IntTree) extends IntTree



object IntTree {
  def contains(t: IntTree, v: Int): Boolean = t match {
    case EmptyTree => false
    case Node(e,l,r) =>
      if (v == e) {
      true
    } else if (v > e) {
      contains(r, v)
    } else {
      contains(l, v)
    }

  }

  def insert(t: IntTree, v: Int): IntTree = t match {
    case EmptyTree =>  Node(v, EmptyTree, EmptyTree)
    case Node(e,l,r) =>
      if (e > v) {
        Node(v, insert(l,v),r)
      } else {
        Node(v, l, insert(r, v))
      }
  }
}