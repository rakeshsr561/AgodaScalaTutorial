object Retry {

  def retry[T](n: Int)(fn: => T)(implicit sTime:Int): T = {
    try {
      fn
    } catch {
      case e =>
        if (n > 1) {
          Thread.sleep(sTime)
          retry(n - 1)(fn)
        }
        else throw e
    }
  }

  def main(args: Array[String]): Unit = {
    implicit val sTime = 1000
    var a = 0
    var b = -1
    retry(3) {
      a += 1
      b += 1
      val c = a/b

    }
  }
}

