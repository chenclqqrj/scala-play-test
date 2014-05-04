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
//  val viewPath = universe.typeOf[View].typeSymbol.owner.name + ".View"
  val viewType = universe.typeOf[View]

  def jarg(jargs, name: String) = jargs(newTermName(name)) match {
    // Constant is always wrapped in a Literal or LiteralArgument tree node
    case LiteralArgument(ct: Constant) => value
    case _ => sys.error("Not a constant")
  }

  def generateDataGridHeader[tpe:TypeTag] = {
    val ty:Type = universe.typeOf[tpe]
    val ty_as:List[universe.Annotation] = ty.typeSymbol.annotations
    ty_as.foreach(ty_a => {
      ty_a match {
        case viewType =>
          val args:ListMap[Name, JavaArgument] = ty_a.javaArgs
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
        case _ => println("#############" + ty_a.tpe)
      }
    })
  }

  def main(args:Array[String]) {
    generateDataGridHeader[Person]
  }


}
