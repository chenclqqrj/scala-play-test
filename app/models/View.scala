package models

/**
 * Created by crjun on 14-4-25.
 */
trait View {
  // 属性的中文标题
  def getAttributeNames = {}
  // 是否可以编辑
  var editable = false
  // 是否有增加操作
  var addOperate = true
  // 是否有更新操作
  var updateOperate = true
  // 是否有删除操作
  var deleteOperate = true
}
