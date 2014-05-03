package models
import scala.reflect.runtime._
import scala.reflect.runtime.universe._
import scala.collection.immutable.ListMap

/**
 * author: CHENCYTTTL 
 * date: 2014/5/3
 */
object MyHelper {
  // 获取到View的完整类路径 如 models.View
  val viewPath = universe.typeOf[View].typeSymbol.owner.name + ".View"
  //
  def generateDataGridHeader[tpe:TypeTag] = {
    val ty:Type = universe.typeOf[tpe]
    val ty_as:List[universe.Annotation] = ty.typeSymbol.annotations
    val view_anno:Option[Annotation] = ty_as.find(_.toString.startsWith(viewPath))
    view_anno match {
      case Some(content) => {
        val args:ListMap[Name, JavaArgument] = content.javaArgs
        var flag = false;
        args.foreach(arg => {
          arg._1.toString() match {
            case "editable" => {
              if (arg._2.toString.equalsIgnoreCase("true")) {
                flag = true;
                println(arg._1.toString + "----" + arg._2.toString)
              }
            }
            case "hasAddOperate" => {
//              if (flag) {
                println(arg._1.toString + "----" + arg._2.toString)
//              }
            }
            case "hasRemoveOperate" => {
              if (flag) {
                println(arg._1.toString + "----" + arg._2.toString)
              }
            }
            case "hasUpdateOperate" => {
              if (flag) {
                println(arg._1.toString + "----" + arg._2.toString)
              }
            }
          }
        })
      }
      case None =>
    }
    println("---" + view_anno.getOrElse(""))
  }

  def main(args:Array[String]) {
    generateDataGridHeader[Person]
  }


}
