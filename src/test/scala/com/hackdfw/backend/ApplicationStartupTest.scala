package com.hackdfw.backend

import com.google.inject.Stage
import com.twitter.finatra.http.test.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest

class ApplicationStartupTest extends FeatureTest {

  override val server = new EmbeddedHttpServer(
    twitterServer = new ApplicationServer,
    stage = Stage.PRODUCTION,
    verbose = false)

  "Server" should {
    "startup" in {
      server.assertAppStarted()
    }
  }
}
