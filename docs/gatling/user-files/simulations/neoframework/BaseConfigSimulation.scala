/**
 * Copyright 2011-2018 Neo
 *
 * 压测脚本配置公共类，其他类都继承本类，包括：服务器地址端口、认证token、http protocal等
 */
package neoframework

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BaseConfigSimulation extends Simulation {

  val server = "http://localhost"

  var apiPort = ":8081"
  var resourcePort = ":8084"
  var tracePort = ":8085"
  var authPort = ":8899"

  // TODO：目前未有前置更新 token ，所以要测试哪个平台先手动在 postman 请求，再更新到这里。
  val authToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MzE5MjU3OTYsInVzZXJfbmFtZSI6Imxhb3NoaTEiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiLCJST0xFX1RFQUNIRVIiXSwianRpIjoiMzc4ODYwNGYtOTQzMC00NTM4LTk0ZWEtYTEyYzUyOTVlMjYxIiwiY2xpZW50X2lkIjoiYWNtZSIsInNjb3BlIjpbIm9wZW5pZCJdfQ.YEv9_AIzASmJXhSH8dmf2xXL080A1Xe6g8hDsJTITp9QtYlNtf9ThnyJLsR44fA6s591spDLGQQJApMGJRZ1FEtTlKxGqVRrnEBDP5L5EGWKDt6prj2kOBrP02yq4Jnzboq6kEvHYfymWMT7xusgUqS3kHNOQWg2lwoHJYtZbL7KK0LgJcxLf3-Mu6bIQqefKa_5q-4oHt80A2IUHxryC152-cp8VYUUKyJHsjuoNzUpR9EkNVtN_bf-uaVgFUtwj6hHYIOqfQIJ0wlwYb2-FTKXz3jsIb8I4XPwDWfDvCyoYnNzpTgJqZdaDGXC7e0Lw7kZijqBC5gnOWdCLwkB9g";

  // api-service
  val httpConfApi = http
    .baseURL(server + apiPort) // Here is the root for all relative URLs
    //.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .doNotTrackHeader("1")
    //.acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
	.header("Authorization", "Bearer " + authToken)

  // resource-service
  val httpConfResource = http
    .baseURL(server + resourcePort)
    //.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    //.acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
	.header("Authorization", "Bearer " + authToken)

  // trace-service
  val httpConfTrace = http
    .baseURL(server + tracePort)
    //.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    //.acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
	.header("Authorization", "Bearer " + authToken)

  // auth-server
  val httpConfAuth = http
    .baseURL(server + authPort)
    //.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    //.acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

}
