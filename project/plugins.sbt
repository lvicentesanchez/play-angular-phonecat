// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository 
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"


// Assembly
//
//addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.9.0")

// Dependency graph
//
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")

// Play plugin
//
addSbtPlugin("play" % "sbt-plugin" % "2.1.2")

// Scalariform
//
addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.0.1")

// Sublime2 + Ensime plugins
//
addSbtPlugin("com.orrsella" % "sbt-sublime" % "1.0.5")

addSbtPlugin("org.ensime" % "ensime-sbt-cmd" % "0.1.1")

// Update plugin
//
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.1.1")
