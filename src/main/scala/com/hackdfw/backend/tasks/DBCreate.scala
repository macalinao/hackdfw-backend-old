package com.hackdfw.backend.tasks

import com.hackdfw.backend.DB

object DBCreate {

  def main(args: Array[String]): Unit = {
    DB.drop()
  }

}
