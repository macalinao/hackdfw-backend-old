package com.hackdfw.backend.controllers

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class RootController extends Controller {

  // Serve static files
  get("/:*") { request: Request =>
    response.ok.fileOrIndex(
      filePath = request.params("*"),
      indexPath = "index.html")
  }

}
