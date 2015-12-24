package com.hackdfw.backend

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import MyPostgresDriver.api._

object DB {

  val url = Option(System.getenv("JDBC_DATABASE_URL")).getOrElse("jdbc:postgresql://localhost/hackdfw_backend_devel")

  val connection = Database.forURL(url, driver = "org.postgresql.Driver")

  def create(): Unit = {
    val result = DB.connection.run(DBIO.seq(
      models.schema.create
    ))
    Await.result(result, Duration.Inf)
  }

  def drop(): Unit = {
    val result = DB.connection.run(DBIO.seq(
      models.schema.drop
    ))
    Await.result(result, Duration.Inf)
  }

}
