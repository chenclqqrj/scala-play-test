package models

import java.util.Date;
/**
 * Created by crjun on 14-4-22.
 */
@View(editable = true)
case class Person(@FieldView(title = "ID")var id:Int, @FieldView(title = "名称")var name:String) {
  @FieldView(title = "年龄")
  var age:Int = 0
  @FieldView(title = "生日")
  var birthday:Date = null
}
