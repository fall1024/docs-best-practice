/**
 * Copyright 2011-2018 Boxuebao
 *
	学生：获取作业列表
	学生：查看作业详情
	学生：获取考试作业统计
	学生：获取错题列表
 */
package neoframework

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class CommonSimulation extends BaseConfigSimulation {

  object TestString {
	val get = exec(http("testString")
      .get("/api/testString"))
  }

  object TestEchoString {
	val get = exec(http("testEchoString")
      .get("/api/testEchoString?echo=%e4%b8%ad%e6%96%87%e4%bf%a1%e6%81%af")) // 中文信息
  }

  object TestBean {
	val get = exec(http("testBean")
      .get("/api/testBean?name=someName"))
  }

  // 测试对数据库简单查询 获取班级和学校信息
  object TestGetSchoolClassByOid {
	val get = exec(http("getSchoolClassByOid")
      .get("/api/getSchoolClassByOid?id=4"))
  }

  // 测试对数据库简单查询 获取班级和学校信息
  object TestUserVersionOnNginxLb {
	val get = exec(http("sys/version")
      .get("/api/sys/version"))
  }

  val commonScn = scenario("Common TestBean Scene")
    .exec(TestUserVersionOnNginxLb.get)

  setUp(commonScn.inject(
	atOnceUsers(10), // warm up
	rampUsers(800) over (20 seconds)
	,nothingFor(10 seconds),
	rampUsers(1200) over (20 seconds)
	,nothingFor(10 seconds),
	rampUsers(1600) over (20 seconds)
	,nothingFor(10 seconds),
	rampUsers(2000) over (20 seconds)
	,nothingFor(10 seconds),
	rampUsers(2400) over (20 seconds)
	,nothingFor(10 seconds),
	rampUsers(2800) over (20 seconds)
	,nothingFor(10 seconds),
	rampUsers(3200) over (20 seconds)
	).protocols(httpConfApi))
}
