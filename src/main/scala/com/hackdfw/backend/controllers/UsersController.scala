package com.hackdfw.backend.controllers

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class UsersController extends Controller {

  get("/users") { request: Request =>
    "Hello, world!"
  }

}
