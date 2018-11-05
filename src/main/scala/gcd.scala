object Gcd {

  def findGCD(x:Int, y:Int): Int = y match {
    case 0 => x
    case _ => findGCD(y, x%y)
  }

  def main(args: Array[String]): Unit = {
    println(findGCD(5,10))
    println(findGCD(4,10))
    println(findGCD(6,9))
    println(findGCD(120,80))
  }
}