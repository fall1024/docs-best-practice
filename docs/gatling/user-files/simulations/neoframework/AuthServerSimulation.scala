/**
 * Copyright 2011-2018 Boxuebao
 *
 * 认证中心 oauth/token 和 /me 接口.
 *
 * 保留注释方便初次查看
 */
package neoframework

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class AuthServerSimulation extends BaseConfigSimulation {

  val userFeeder = csv("neoframework-auth-users.csv").random

  val headers_10 = Map("Content-Type" -> "application/x-www-form-urlencoded",
	"Authorization" -> "Basic YWNtZTphY21lc2VjcmV0") // Note the headers specific to a given request

  val authScene = scenario("Auth Server Scene") // A scenario is a chain of requests and pauses
	.feed(userFeeder)
    .exec(http("oauth/token") // Here's an example of a POST request
      .post("/userauth/oauth/token")
	  .formParamMap(Map(
			"grant_type" -> "password",
			"username" -> "${username}",
			"password" -> "${password}"))
      .headers(headers_10)

	  .check(jsonPath("$.access_token").saveAs("accessToken")))
	  .pause(2)
	  .exec(http("userauth/me")
      .get("/userauth/me")
	  .headers(Map("Authorization" -> "Bearer ${accessToken}")))

    setUp(authScene.inject(
	atOnceUsers(10), // warm up
	rampUsers(100) over (20 seconds),
	nothingFor(10 seconds),
	rampUsers(500) over (20 seconds),
	nothingFor(10 seconds),
	rampUsers(1000) over (20 seconds),
	nothingFor(20 seconds),
	rampUsers(2000) over (20 seconds)
//	,nothingFor(40 seconds),
//	rampUsers(3000) over (20 seconds)
//	,nothingFor(60 seconds),
//	rampUsers(5000) over (20 seconds)
	).protocols(httpConfAuth))
}
