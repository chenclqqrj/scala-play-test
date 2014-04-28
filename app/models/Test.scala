package models
import scala.reflect.runtime._
import models._
object Test {
  def main(args:Array[String]) {
    // 调用java
//    val h = new Hello("AAAA");
//    h.say();
//    val m = Map("ID" -> "A", "姓名" -> "B", "年龄" -> "C")
//    m.foreach(u => {
//      println("---" + u._2)
//    })
    val pm = Person(1, "bb", 3)

    val ty = universe.typeOf[Person]
    val constructors = ty.member(universe.nme.CONSTRUCTOR)
    for (constructor<-constructors.asTerm.alternatives.map{_.asMethod}) {
      println("Constructor = "+constructor)
      println("Overloaded = "+constructor.isOverloaded)
      for (pp<-constructor.paramss) {
        println("Constructor params")
        for (p<-pp) {
          println("  name="+p.name)
          println("  type="+p.typeSignature)
                  for (a<-p.annotations) {
                    println("  annotation "+a)
//                    for ((aname,av)<-a.assocs) {
                    //                      println("     "+aname.decoded+"="+av)
                    //                    }
                  }
        }
      }
    }
  }
}
