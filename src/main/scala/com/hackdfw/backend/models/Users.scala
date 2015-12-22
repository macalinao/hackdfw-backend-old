package com.hackdfw.backend.models

import java.sql.Date

import org.json4s.JsonAST.JValue
import com.hackdfw.backend.MyPostgresDriver.api._

class User(tag: Tag) extends Table[(Int, String, String, String, Date, JValue)](tag, "users") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def email = column[String]("email")

  def password = column[String]("password")

  def confirmationToken = column[String]("confirmation_token")

  def confirmedAt = column[Date]("confirmed_at")

  def fields = column[JValue]("fields")

  def * = (id, email, password, confirmationToken, confirmedAt, fields)

}

object Users extends TableQuery(new User(_))

