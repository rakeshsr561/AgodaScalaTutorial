import org.scalatest.FunSuite


class GcdTest extends FunSuite {
  test("Gcd x < y") {
    assert(Gcd.findGCD(5,10) == 5)
  }

  test("Gcd x > y") {
    assert(Gcd.findGCD(10, 5) == 5)
  }

  test("Gcd x == y") {
    assert(Gcd.findGCD(5,5) == 5)
  }

  //It should be not defined?
  test("Gcd x == y == 0") {
    assert(Gcd.findGCD(0,0) == 0)
  }

  test("Gcd x==0 ") {
    assert(Gcd.findGCD(0,10) == 10)
  }

  test("Gcd y==0 ") {
    assert(Gcd.findGCD(10,0) == 10)
  }
}
