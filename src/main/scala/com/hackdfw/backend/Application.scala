package com.hackdfw.backend

import com.hackdfw.backend.controllers.{RootController, UsersController}
import com.twitter.finagle.http.{Response, Request}
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.CommonFilters
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.finatra.logging.filter.{TraceIdMDCFilter, LoggingMDCFilter}
import com.twitter.finatra.logging.modules.Slf4jBridgeModule

object Application extends ApplicationServer

class ApplicationServer extends HttpServer {

  override def modules = Seq(Slf4jBridgeModule)

  override def configureHttp(router: HttpRouter) {
    router
      .filter[LoggingMDCFilter[Request, Response]]
      .filter[TraceIdMDCFilter[Request, Response]]
      .filter[CommonFilters]

      .add[RootController]
      .add[UsersController]
  }

}
