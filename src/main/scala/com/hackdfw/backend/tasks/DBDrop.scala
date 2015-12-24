package com.hackdfw.backend.tasks

import com.hackdfw.backend.DB

object DBDrop {

  def main(args: Array[String]): Unit = {
    DB.create()
  }

}
