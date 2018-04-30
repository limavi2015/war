resolvers ++= {
  implicit val basePatterns: Patterns = Resolver.ivyStylePatterns
  Seq(
    Resolver.sonatypeRepo("releases"),
    Resolver.typesafeRepo("releases")
  )
}

libraryDependencies += "com.trueaccord.scalapb" %% "compilerplugin" % "0.5.47"

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.3")

// Sorted alphabetically by name for better readability
addSbtPlugin("com.typesafe.sbt"       % "sbt-native-packager"  % "1.2.0")
addSbtPlugin("com.lucidchart"         % "sbt-scalafmt"         % "1.14")
addSbtPlugin("org.scoverage"          % "sbt-scoverage"        % "1.5.0")
