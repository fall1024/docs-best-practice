/*
 * Copyright 2011-2018 Boxuebao
 *
 	空间：获取人人通空间动态列表
	空间：获取个人空间动态列表
	空间：获取学校空间动态列表
	空间：获取人人通空间详情
	空间：获取用户空间详情
 */
package neoframework

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class SpaceSimulation extends BaseConfigSimulation {

  object PublicSpaceMsg { // 人人通
	// 范围类型：0-所有、1-个人、2-班级、3-学校、4-教师、5-人人通
	var get = exec(http("getScopeSpaceMsg")
      .get("/api/space/msg/read?pageNo=1&pageSize=10&scopeType=5"))
	  .pause(2)

  }

  object PublicInfo {
    // 人人通详情
	var get = exec(http("getPublicInfo")
      .get("/api/space/public/info?id=d1eebce8a0534d119a85aadeb81e37d0"))
	  .pause(2)
  }

  val spaceScn = scenario("Space Scene")
//	.feed(userFeeder)
    .exec(PublicInfo.get)
//	.pause(2)
//    .exec(http("userauth/me")
//      .get("/userauth/me")
//      .headers(Map("Authorization" -> "Bearer ${accessToken}")))

	// setUp(spaceScn.inject(rampUsers(1000) over (10 seconds)).protocols(httpConfApi))
	setUp(spaceScn.inject(rampUsers(50) over (20 seconds)).protocols(httpConfApi))
}
