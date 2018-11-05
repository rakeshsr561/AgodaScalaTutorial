
object TimeIt {

  def timeit[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }

  def print_agoda:Int = {
    println("Agoda")
    return 1
  }


  def main(args: Array[String]): Unit = {
    val result = timeit {print_agoda}
    println(result)
  }
}