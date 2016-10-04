
name := """despina-market"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

// https://mvnrepository.com/artifact/org.eclipse.persistence/eclipselink
libraryDependencies += "org.eclipse.persistence" % "eclipselink" % "2.6.3"

// https://mvnrepository.com/artifact/mysql/mysql-connector-java
libraryDependencies += "mysql" % "mysql-connector-java" % "6.0.4"

//// https://mvnrepository.com/artifact/mysql/mysql-connector-java
//libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.35"

// https://mvnrepository.com/artifact/org.springframework/spring-core
libraryDependencies += "org.springframework" % "spring-core" % "4.3.2.RELEASE"

// https://mvnrepository.com/artifact/org.springframework/spring-context
libraryDependencies += "org.springframework" % "spring-context" % "4.3.2.RELEASE"

// https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa
libraryDependencies += "org.springframework.data" % "spring-data-jpa" % "1.10.2.RELEASE"

// https://mvnrepository.com/artifact/org.springframework/spring-instrument
libraryDependencies += "org.springframework" % "spring-instrument" % "4.3.2.RELEASE"

// https://mvnrepository.com/artifact/junit/junit
libraryDependencies += "junit" % "junit" % "4.12"

// https://mvnrepository.com/artifact/org.webjars/jquery
libraryDependencies += "org.webjars" % "jquery" % "3.1.0"

// https://mvnrepository.com/artifact/org.webjars/requirejs
libraryDependencies += "org.webjars" % "requirejs" % "2.3.0"

// https://mvnrepository.com/artifact/org.webjars/react
libraryDependencies += "org.webjars" % "react" % "15.2.1"

