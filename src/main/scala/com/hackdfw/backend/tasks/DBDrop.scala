package com.hackdfw.backend.tasks

import com.hackdfw.backend.MyPostgresDriver.api._
import com.hackdfw.backend.{DB, models}

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext}

object DBDrop {

  def main(args: Array[String]): Unit = {

    implicit val ec = ExecutionContext.global
    val result = DB.connection.run(DBIO.seq(
      models.schema.drop
    ))
    Await.result(result, Duration.Inf)

  }

}
