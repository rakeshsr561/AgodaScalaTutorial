import scala.collection.mutable.ListBuffer

class VectorCalc(vector: Vector[Int]) {

  var list:ListBuffer[Int] = ListBuffer()
  var y = 0
  var xflag = false
  var yflag = false

  def getX(): Vector[Int] = {
    if (!xflag) {
      for(e<-vector) {
        list += (e * e)
      }
      xflag = true
    }
    list.toVector
  }

  def getY(): Int = {
    if (!yflag) {
      val vx:Vector[Int] = getX()
      for(e<-vx) {
        y += e
      }
      yflag = true
    }
    y
  }

  def getZ():Double = {
    Math.sqrt(getY())
  }


}

