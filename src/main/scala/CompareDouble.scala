import scala.language.implicitConversions
case class Precision(p: Double)

class withAlmostEquals(d: Double) {
  def ~=(d2: Double)(implicit p: Precision):Boolean = (d - d2).abs <= p.p

}

object CompareDouble {
  def main(args: Array[String]): Unit = {
    implicit def add_~=(d: Double):withAlmostEquals = new withAlmostEquals(d)
    implicit val precision:Precision = Precision(0.001)
    println(0.001~=0.0004)
    println(0.001~=0.0021)
  }
}