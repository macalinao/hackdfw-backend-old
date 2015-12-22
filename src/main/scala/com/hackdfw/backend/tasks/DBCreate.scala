package com.hackdfw.backend.tasks

import com.hackdfw.backend.DB
import com.hackdfw.backend.models
import com.hackdfw.backend.MyPostgresDriver.api._
import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Await}

object DBCreate {

  def main(args: Array[String]): Unit = {

    implicit val ec = ExecutionContext.global
    val result = DB.connection.run(DBIO.seq(
      models.schema.create
    ))
    Await.result(result, Duration.Inf)

  }

}
