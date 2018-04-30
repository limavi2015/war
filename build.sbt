
name := "war"

version := "1.0"

scalaVersion := "2.12.5"

lazy val `reto` = project in file(".")

resolvers ++= Seq(
  Resolver.bintrayRepo("hseeberger", "maven"),
  Resolver.bintrayRepo("outworkers", "oss-releases"),
  Resolver.sonatypeRepo("public"),
  Resolver.sonatypeRepo("snapshots"),
  DefaultMavenRepository
)

val Json4sVersion = "3.5.2"

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-http"            % "10.1.1",
    "de.heikoseeberger" %% "akka-http-circe"      % "1.16.1" withSources () withJavadoc (),
    "de.heikoseeberger" %% "akka-http-json4s"     % "1.16.0",
    "com.typesafe.akka" %% "akka-http-testkit"    % "10.1.1" % Test,
    "de.heikoseeberger" %% "akka-log4j"           % "1.6.1",
    "com.typesafe.akka" %% "akka-actor"           % "2.5.11",
    "com.typesafe.akka" %% "akka-slf4j"           % "2.4.18",
    "com.typesafe.akka" %% "akka-stream"          % "2.5.11",
    "com.typesafe.akka" %% "akka-testkit"         % "2.5.11" % Test,
    "org.json4s"        %% "json4s-native"        % Json4sVersion,
    "org.json4s"        %% "json4s-ext"           % Json4sVersion,
    "org.scalatest"     %% "scalatest"            % "3.0.3" % "test"
  )
}