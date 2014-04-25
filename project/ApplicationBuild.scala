import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "test"
  val appVersion      = "1.0"

  val appDependencies = Seq(

    //"org.scala-tools" %% "scala-stm" % "0.3",
    //"org.apache.derby" % "derby" % "10.4.1.3" % "test"

  )

  val main = play.Project(appName, appVersion, appDependencies).settings(defaultScalaSettings:_*).settings(

    /** resolvers += "JBoss repository" at "https://repository.jboss.org/nexus/content/repositories/",*/
    //resolvers += "my-nexus Repository" at "http://127.0.0.1:8084/nexus/content/groups/public"

  )

}