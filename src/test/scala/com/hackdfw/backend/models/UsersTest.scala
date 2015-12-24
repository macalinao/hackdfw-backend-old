package com.hackdfw.backend.models

import com.hackdfw.backend.{MyPostgresDriver, DB, ApplicationServer}
import com.twitter.finatra.http.test.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest
import MyPostgresDriver.api._
import org.json4s.JsonAST.JNull

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class UsersTest extends FeatureTest {

  override val server = new EmbeddedHttpServer(new ApplicationServer)

  override def beforeAll(): Unit = {
    DB.create()
  }

  override def afterAll(): Unit = {
    DB.drop()
  }

  "Users" should {

    "support confirmation" in {

      val email = "me@ian.pw"
      val token = "test"

      // Prepare confirmed user
      Await.ready(DB.connection.run(DBIO.seq(
        Users += (0, email, None, Some(token), None, JNull)
      )), Duration.Inf)

      val userOption = Users.confirmedUser(email, token)
      assert(userOption.isDefined)

      val user = userOption.get
      assert(user.email == email)
      assert(user.confirmationToken.get == token)

    }

  }

}
