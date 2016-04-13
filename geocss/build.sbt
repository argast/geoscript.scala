name := "geocss"

libraryDependencies <++= gtVersion { v =>
  Seq(
    "org.geotools" % "gt-main" % v,
    "org.geotools" % "gt-cql" % v
  )
}

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.5",
  "org.scalacheck" %% "scalacheck" % "1.12.5" % "test",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test")

initialCommands += """
import org.{ geotools => gt }
import org.opengis.{ filter => ogc }
import org.geoscript._
import gt.filter.text.ecql.ECQL.{ toFilter => cql }
import geocss.filter.FiltersAreSentential
import support.logic.{ given, reduce }
def in(path: String) = new java.io.FileReader(new java.io.File(path))
def load(path: String) = 
  geocss.CssParser.parseAll(
    geocss.CssParser.styleSheet, in(path)
  ).get
val tx = new geocss.Translator()
"""
