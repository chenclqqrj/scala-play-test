package models

/**
 * Created by crjun on 14-4-22.
 */
case class Person(i:Int, n:String, a:Int) extends View {
  @MyTitle(name = "MMM")
  var id = i
  var name = n
  var age = a

  override def getAttributeNames {
    editable = true;

    val m = Map("ID" -> id, "姓名" -> name, "年龄" -> age)
    m.foreach(u => {
      println("---" + u.toString())
    })
  }

}
