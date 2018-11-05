sealed trait IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(x: IntSet): IntSet
  def intersect(x: IntSet): IntSet
  def excl(x: Int): IntSet
  def isEmpty = false
}

object EmptySet extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmptySet(x, EmptySet,  EmptySet)
  def union(x: IntSet): IntSet = x
  def intersect(x: IntSet): IntSet = this
  override def isEmpty = true
  def excl(x: Int):IntSet = this
}

class NonEmptySet(val elem: Int, val left: IntSet, val right: IntSet) extends IntSet {

  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmptySet(elem, left incl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right incl x)
    else this


  def excl(x: Int) = {
    if (x < elem) new NonEmptySet(elem, left.excl(x), right)
    if (x > elem) new NonEmptySet(elem, left, right.excl(x))
    else left union right
  }

  def union(other: IntSet) = ((left union other) union right) incl elem


  def intersect(other: IntSet): IntSet = {
    val newSet = (right intersect other) union (left intersect other)
    if (other contains elem) newSet incl elem
    else newSet
  }

}

