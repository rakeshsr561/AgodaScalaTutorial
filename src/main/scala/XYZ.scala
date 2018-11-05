object xyz {
  def firstNonNull(x:Option[Any], y:Option[Any], z:Option[Any]): Option[Any] = {
    (x,y,z) match {
      case (None,None,None) => None
      case (None,None, _) => z
      case (None,_,_) => y
      case (_,_,_) => x
    }
  }

  def main(args: Array[String]): Unit = {
    println(firstNonNull(None,None,None))
    println(firstNonNull(None,Some("B"),None))
    println(firstNonNull(Some("A"),Some("B"),Some("C")))
    println(firstNonNull(None,None,Some("C")))
    println(firstNonNull(None,Some("B"),Some("C")))
    println(firstNonNull(None,None,None))
  }
}