package com.hackdfw.backend

import com.github.tminglei.slickpg.{PgDateSupport, PgJson4sSupport, ExPostgresDriver}
import org.json4s.JsonAST.JValue
import slick.driver.PostgresDriver.api._
import org.json4s.jackson.JsonMethods
import scala.concurrent.ExecutionContext.Implicits.global

trait MyPostgresDriver extends ExPostgresDriver
  with PgJson4sSupport with PgDateSupport {

  override val pgjson = "json"
  type DOCType = JValue
  val jsonMethods = JsonMethods
  override val api = MyAPI

  object MyAPI extends API
  with JsonImplicits with DateTimeImplicits

}

object MyPostgresDriver extends MyPostgresDriver
