import scala.collection.mutable.ArrayBuffer

trait Queue {
  def get():Option[String]
  def put(string: String)
}

trait reverseString extends Queue {
  abstract override def put(string: String): Unit ={
    super.put(string.reverse)
  }
}

class StringQueue extends Queue {
  private val array = new ArrayBuffer[String]
  def get(): Option[String] = {
    if (array.nonEmpty) {
      Some(array.remove(0))
    } else {
      None
    }
  }

  def put(string: String): Unit = {
    array += string
  }
}

object StringQueue {
  def main(args: Array[String]): Unit = {
    //Example 1
    val stringQueue = new StringQueue()
    stringQueue.put("Rakesh")
    stringQueue.put("Rahul")
    stringQueue.put("Madhu")
    stringQueue.put("Manu")
    println(stringQueue.get())
    println(stringQueue.get())
    println(stringQueue.get())
    stringQueue.put("Vidhya")
    stringQueue.put("Resmi")
    println(stringQueue.get())
    println(stringQueue.get())
    println(stringQueue.get())
    println(stringQueue.get())

    //Example 2
    val reverseQueue = new StringQueue with reverseString
    reverseQueue.put("Rakesh")
    reverseQueue.put("Madhu")
    reverseQueue.put("Resmi")
    println(reverseQueue.get())
    println(reverseQueue.get())
    println(reverseQueue.get())
    println(reverseQueue.get())
  }
}