import scala.collection.mutable.ListBuffer

object ListMapAdder {
  def listMapAdded(list:List[Int], map:Map[Int, Int]): List[Int] = {
    var listr:ListBuffer[Int] =  ListBuffer[Int]()
    for(e<-list) {
      if (map.contains(e)) {
        listr += e * map(e)
      }

    }
    listr.toList
  }

  def main(args: Array[String]): Unit = {
    println(listMapAdded(List(1,2,3,4), Map(1 -> 3, 3-> 5)))
  }
}