import org.scalatest.FunSuite



class RetryTest extends FunSuite {

  test("timeIt repeat till the count") {
    implicit val sTime = 1000
    var a = 0
    try {
      Retry.retry(3) {
        a += 1
        a / 0
      }
    }catch{
      case _:Exception => {

      }
        assert(a == 3)
    }
  }

  test("timeIt repeat < count") {
    implicit val sTime = 1000
    var a = 0
    var b = -1
    try {
      Retry.retry(5) {
        a += 1
        b += 1
        a / b

      }
    }catch{
      case _:Exception => {

      }
        assert(a == 2)
    }
  }


}