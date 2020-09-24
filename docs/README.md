# docs-best-practice
开发项目 docs 目录的一些最佳实践：常用文档、结构、工具、脚本等

## 概述

一方面，团队新成员加入时，这些内容有助于他们尽快了解项目、代码库相关，为他们下一步加入开发测试提供准备。另一方面，一些开箱即用的常用工具可实现本地快速部署，尽量减少本地开发环境与生产环境差异的影响，节省开发人员一些精力和时间。

## 目录

* [dependencies](#dependencies) 项目模块依赖输出文档，例如由 genDependenciesDocs.sh 生成的 Gradle 模块依赖。
* [gatling](#gatling) 负载测试工具 Gatling 的测试脚本。这里提供一些 token 请求的例子。
* [nginx](#nginx) 开箱即用的 Nginx 1.11.11 windows 版。提供带辅助功能的运行脚本，提供多站点、接近生产环境部署的例子。
* [postman](#postman) 请求测试工具 Postman 的导出文件，导入后快速开始测试，了解服务接口。例子包括 Spring Cloud + OAuth2.0 获取 access token ，刷新 token ，使用 token 请求，等等。
* [redis](#redis) 开箱即用的 Redis 2.8.19 windows 版。支持单实例、哨兵多实例部署启动。
* [scripts](#scripts) 项目常用测试、运行脚本。
* [sql](#sql) 一些必要的数据库文件。
* [styleguide](#styleguide) 一份较完整齐备的代码风格规范及说明。

## 详情

### dependencies
项目模块依赖输出文档，例如由 genDependenciesDocs.sh 生成的 Gradle 模块依赖。

### gatling
负载测试工具 Gatling 的测试脚本。这里提供一些 token 请求的例子。

### nginx
开箱即用的 Nginx 1.11.11 windows 版。提供带辅助功能的运行脚本，提供多站点、接近生产环境部署的例子。

详情请跳转 [nginx/README.md](nginx/README.md)

### postman
请求测试工具 Postman 的导出文件，导入后快速开始测试，了解服务接口。

* neoframework-dev.postman_environment.json 环境变量 Environment 处导入
* neoframework.postman_collection.json 接口列表 Collection

包括使用 Oauth2 获取 token ，刷新 token，使用 token 请求等的例子。

### redis
开箱即用的 Redis 2.8.19 windows 版。支持单实例、哨兵多实例部署启动。

解压后见下面的 redis/readme.txt

```
建议使用下面方法二，直接解压到相应的位置 D:\server\ 下 ，就不需要更改配置（包括端口和文件位置）。
之后双击 D:\server\redis\redis-bat\startMaster.vbe 开始启动就只有一个端口为 6379 的 redis 实例。
（可能需要允许系统的运行权限提示，或加到杀毒软件的白名单去）。

如果使用 *.vbe 的确没有正常使用，可考虑双击 redis-server-master.bat 来运行，同时可能有助于排查问题
```

### scripts
项目常用测试、运行脚本。

* genDependenciesDocs.sh 使用 Gradle 构建的项目生成依赖树文档到 docs/dependencies 下
* build
    - build-all-projects.sh 快速开始的编译脚本
* demo
    - curl-sys-version.sh 其他一些脚本
    - curl-trace-statCrashLog-without-token.sh
    - curl-trace-statCrashLog.sh
* run
    - run-local-auth-server.sh 运行认证中心的脚本
    - run-local-trace-service.sh 运行行为上报服务的脚本

### sql
一些必要的数据库文件。

### styleguide
一份较完整齐备的代码风格规范及说明。

详情见 [styleguide/README.md](styleguide/README.md)

> 这份“代码风格规范”（style guide）的思路来源于 [google/styleguide 文档](https://google.github.io/styleguide/) ，目前只响应了 Java 语言，即基于其中的 [Java Style Guide](https://google.github.io/styleguide/javaguide.html) 进行调整，结合相关的工具实施。
