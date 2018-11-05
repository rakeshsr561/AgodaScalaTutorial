import org.scalatest.FunSuite



class SetOpTest extends FunSuite {

  test("test contains") {
    val intSet = new NonEmptySet(1, EmptySet, EmptySet)
    assert(intSet.contains(1))
  }

  test("intersect") {
    val intSet1 = EmptySet.incl(1).incl(2)
    val intSet2 = EmptySet.incl(2)
    val intersect = intSet1.intersect(intSet2)
    assert(intersect.contains(2))
    assert(!intersect.contains(1))
  }

  test("union") {
    val intSet1 = EmptySet.incl(1).incl(2).incl(3)
    val intSet2 = EmptySet.incl(4).incl(5).incl(6)
    val intSet = intSet1.union(intSet2)
    assert(intSet.contains(1))
    assert(intSet.contains(2))
    assert(intSet.contains(3))
    assert(intSet.contains(4))
    assert(intSet.contains(5))
    assert(intSet.contains(6))
  }

  test("include exclude") {
    val intSet1 = EmptySet.incl(1).incl(2).incl(3)
    assert(intSet1.contains(1))
    assert(intSet1.contains(2))
    assert(intSet1.contains(3))
    val intSet2 = intSet1.excl(1)
    assert(!intSet2.contains(1))
    assert(intSet2.contains(2))
    assert(intSet2.contains(3))
  }
}
