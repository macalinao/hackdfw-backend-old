package com.hackdfw.backend

import slick.driver.PostgresDriver.api._

object DB {

  val url = "jdbc:" + Option(System.getenv("HEROKU_POSTGRESQL_CRIMSON_URL")).getOrElse("postgres://localhost")

  val connection = Database.forURL(url, driver = "org.postgresql.Driver")

}
