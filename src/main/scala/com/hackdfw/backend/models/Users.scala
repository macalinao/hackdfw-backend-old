package com.hackdfw.backend.models

import java.sql.Date

import com.hackdfw.backend.DB
import org.json4s.JsonAST.{JNull, JValue}
import com.hackdfw.backend.MyPostgresDriver.api._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

case class User(id: Int, email: String, password: Option[String],
                confirmationToken: Option[String], confirmedAt: Option[Date], fields: JValue)

class Users(tag: Tag) extends Table[(Int, String, Option[String], Option[String], Option[Date], JValue)](tag, "users") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def email = column[String]("email")

  def password = column[Option[String]]("password")

  def confirmationToken = column[Option[String]]("confirmation_token")

  def confirmedAt = column[Option[Date]]("confirmed_at")

  def fields = column[JValue]("fields", O.Default(JNull))

  def * = (id, email, password, confirmationToken, confirmedAt, fields)

}

object Users extends TableQuery(new Users(_)) {

  def confirmedUser(email: String, confirmationToken: String): Option[User] = {
    val fut = DB.connection.run(filter { user =>
      user.email === email && user.confirmationToken === confirmationToken
    }.result.headOption)
    Await.result(fut, Duration.Inf) match {
      case Some(x) => Some((User.apply _).tupled(x))
      case None => None
    }
  }

}

