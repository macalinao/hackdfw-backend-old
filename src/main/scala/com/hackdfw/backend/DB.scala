package com.hackdfw.backend

import com.github.tminglei.slickpg.{PgDateSupport, PgJson4sSupport, ExPostgresDriver}
import org.json4s.JsonAST.JValue
import slick.driver.PostgresDriver.api._
import org.json4s.jackson.JsonMethods

object DB {

  val url = Option(System.getenv("JDBC_DATABASE_URL")).getOrElse("jdbc:postgresql://localhost/hackdfw_backend_devel")

  val connection = Database.forURL(url, driver = "org.postgresql.Driver")

}

trait MyPostgresDriver extends ExPostgresDriver
  with PgJson4sSupport with PgDateSupport {

  def pgjson = "jsonb"
  type DOCType = JValue
  val jsonMethods = JsonMethods
  override val api = MyAPI

  object MyAPI extends API
    with JsonImplicits with DateTimeImplicits

}

object MyPostgresDriver extends MyPostgresDriver