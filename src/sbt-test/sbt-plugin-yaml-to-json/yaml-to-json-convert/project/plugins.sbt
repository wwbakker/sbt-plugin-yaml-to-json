resolvers += Resolver.bintrayIvyRepo("wwbakker", "sbt-plugins")

addSbtPlugin("nl.wwbakker" % "sbt-yaml-to-json" % sys.props("plugin.version"))
