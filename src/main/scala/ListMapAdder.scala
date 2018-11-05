object ListMapAdder {
  def listMapAdded(list:List[Int], map1:Map[Int, Int]): List[Int] = {
    list.filter(x => {map1.contains(x)}).map(x => x * map1(x))
  }



  def main(args: Array[String]): Unit = {
    println(listMapAdded(List(1,2,3,4), Map(1 -> 3, 3-> 5)))
  }
}