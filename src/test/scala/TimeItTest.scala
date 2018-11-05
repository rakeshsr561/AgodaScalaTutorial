import org.scalatest.FunSuite



class TimeItTest extends FunSuite {

  test("timeIt test the result") {
    val result = TimeIt.timeit {1 to 10 sum}
    assert(result == 55)
  }
}
