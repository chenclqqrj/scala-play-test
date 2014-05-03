package models

import scala.beans.BeanProperty
/**
 * author: CHENCYTTTL 
 * date: 2014/5/3
 */
@MyTitle(name = "Dogggg")
case class Dog(@MyTitle(name = "idddd")var id:Int, @MyTitle(name = "nooooo")val no:String) {
  @MyTitle(name = "nameee")
  var name:String = ""
  @MyTitle(name = "ageee")
  val age:Int = 20
  @MyTitle(name = "colorrr")
  @BeanProperty var color:String = ""

  //def this() = this(1, "", "")

  @MyTitle(name = "wanggg")
  def wang(){
    println("wang wang...")
  }

}
