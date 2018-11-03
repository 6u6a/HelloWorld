/**
  * Created by wutianxiong on 2016/10/9.
  */
object test {

  def main(args: Array[String]): Unit = {
//    var li = List(1,2,3,4)
//    var res=li.map(x=>x match {
//      case 3 =>List(4.2,34)
//      case _ =>x*2
//    })
//    print(res)
    val text = List("Homeway,25,Male","XSDYM,23,Female")
    val usersList = text.map(_.split(",")(2))
    for (i<-text){
      println(i)
    }


    val test=Map('a'->4,'b'->3,'c'->5,'d'->1)
    val threshold=2
    val result=test.filter(_._2>=threshold)
    result.foreach(println(_))
  }
}
