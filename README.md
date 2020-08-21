# docs-best-practice
开发项目 docs 目录的一些最佳实践：常用文档、结构、工具、脚本等

## 概述

一方面，团队新成员加入时，这些内容有助于他们尽快了解项目、代码库相关，为他们下一步加入开发测试提供准备。另一方面，一些开箱即用的常用工具可实现本地快速部署，尽量减少本地开发环境与生产环境差异的影响，节省开发人员一些精力和时间。

## 目录

* [dependencies](#dependencies) 项目模块依赖输出文档，例如由 genDependenciesDocs.sh 生成的 Gradle 模块依赖。
* [gatling](#gatling) 负载测试工具 Gatling 的测试脚本。这里提供一些 token 请求的例子。
* [nginx](#nginx) 开箱即用的 Nginx 1.11.11 windows 版。提供带辅助功能的运行脚本，提供多站点、接近生产环境部署的例子。
* [postman](#postman) 请求测试工具 Postman 的导出文件，导入后快速开始测试，了解服务接口。
* [redis](#redis) 开箱即用的 Redis 2.8.19 windows 版。支持单实例、哨兵多实例部署启动。
* [scripts](#scripts) 项目常用测试、运行脚本。
* [sql](#sql) 一些必要的数据库文件。
* [styleguide](#styleguide) 一份较完整齐备的代码风格规范及说明。

## 详情

详情请跳转 [docs/README.md](docs/README.md)