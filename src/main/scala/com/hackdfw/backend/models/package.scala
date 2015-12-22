package com.hackdfw.backend

import com.hackdfw.backend.MyPostgresDriver.api._

package object models {

  lazy val all = {
    Users :: Nil
  }

  lazy val schema = {
    all.map(_.schema).reduceLeft(_ ++ _)
  }

}
