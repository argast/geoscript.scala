import sbt._

class GeoScalaProject(info: ProjectInfo) extends ParentProject(info) {
  lazy val library = 
    project("geoscala", "GeoScala Library", new GeoScalaLibrary(_))
  lazy val examples = project("examples", "GeoScala Example Programs", library)

  class GeoScalaLibrary(info: ProjectInfo) extends DefaultProject(info) {
    val osgeo = "OSGeo Maven Repository" at 
        "http://download.osgeo.org/webdav/geotools/"
    val java_net = "Java.net Maven Repository" at 
        "http://download.java.net/maven/2/"

    val gtVersion = "[2.6.0,2.7.0["
        
    val gtMain = "org.geotools" % "gt-main" % gtVersion
    val gtReferencing = "org.geotools" % "gt-epsg-hsql" % gtVersion
    val gtShapefile = "org.geotools" % "gt-shapefile" % gtVersion
    val gtJDBC = "org.geotools" % "gt-jdbc" % gtVersion
    val gtDirectory = "org.geotools" % "gt-directory" % gtVersion 

    val scalaTest = "org.scalatest" % "scalatest" % "1.0" % "test"
  }
}
