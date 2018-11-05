import org.scalatest.FunSuite



class IntTreeTest extends FunSuite {
  test("insert an element and check same element") {
    val intTree:IntTree = Node(1, EmptyTree, EmptyTree)
    assert(IntTree.contains(intTree, 1))
  }

  test("insert four element and check all element with a non element") {
    val intTree:IntTree = Node(2, Node(1, EmptyTree, EmptyTree), Node(3, EmptyTree, Node(4, EmptyTree, EmptyTree)))
    assert(IntTree.contains(intTree, 1))
    assert(IntTree.contains(intTree, 2))
    assert(IntTree.contains(intTree, 3))
    assert(IntTree.contains(intTree, 4))
    assert(!IntTree.contains(intTree, 5))
  }

  test("insert two element and check inserted element") {
    val intTree:IntTree = Node(2, Node(1, EmptyTree, EmptyTree), Node(3, EmptyTree, Node(4, EmptyTree, EmptyTree)))
    val tree0 = IntTree.insert(intTree, 0)
    val tree6 = IntTree.insert(intTree, 6)
    println(intTree)
    assert(IntTree.contains(tree6, 6))
    assert(IntTree.contains(tree0, 0))
  }

  test("Test emptyTree") {
    val treeEmptyTree = EmptyTree
    val tree0 = IntTree.insert(treeEmptyTree, 0)
    assert(IntTree.contains(tree0, 0))
  }

}
