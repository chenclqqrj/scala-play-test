package controllers

import play.api.mvc.{Action, Controller}
import views.html
import models.Person

object Application extends Controller {
  var ps = List[Person](new Person(1, "张三", 35), new Person(2, "李四", 40))

  def index = Action {
    //    ps.+:(new Person(3, "旺旺", 55))
    //    Ok(html.index(ps))
    Ok(html.test(ps))
  }

}
