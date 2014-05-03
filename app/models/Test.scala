package models
import scala.reflect.runtime._
import scala.reflect.runtime.universe._
import models._
import java.lang.reflect.Method
import java.lang.reflect.Field

object Test {
  def main(args:Array[String]) {
    // 调用java
//    val h = new Hello("AAAA");
//    h.say();
//    val m = Map("ID" -> "A", "姓名" -> "B", "年龄" -> "C")
//    m.foreach(u => {
//      println("---" + u._2)
//    })
    val dog = new Dog(1, "tom")
    dog.wang()
    println("DOG NO..." + dog.no)
    val ty1 = universe.typeOf[MyTitle]
    println(ty1.typeSymbol.owner.name)
    val ty = universe.typeOf[Dog]
    val c:List[universe.Annotation] = ty.typeSymbol.annotations
    c.foreach(k => println("类注解：：" + k.toString))

    val a = ty.member(newTermName("name")).asTerm.accessed.annotations
//    val a = ty.member("name":TermName).asMethod
    a.foreach(k => println("属性注解：：" + k.toString))
    val color = ty.member(newTermName("color")).asTerm.accessed.annotations
    color.foreach(k => println("color属性注解：：" + k.toString))
    val m = ty.member("wang":TermName).asTerm.annotations
    m.foreach(k => println("方法注解：：" + k.toString))
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
                    println("  annotation "+a.javaArgs)
                    println("  annotation "+a.tpe.members)
//                    for ((aname,av)<-a.assocs) {
                    //                      println("     "+aname.decoded+"="+av)
                    //                    }
                  }
        }
      }
    }
  }
}
