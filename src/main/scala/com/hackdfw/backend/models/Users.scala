package com.hackdfw.backend.models

import org.json4s.JsonAST.JValue
import com.hackdfw.backend.MyPostgresDriver.api._

class Users(tag: Tag) extends Table[(Int, String, String, JValue)](tag, "users") {

  def id = column[Int]("id", O.PrimaryKey)

  def email = column[String]("email")

  def password = column[String]("password")

  def fields = column[JValue]("fields")

  def * = (id, email, password, fields)

}
