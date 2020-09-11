
## 快速开始
直接打开 run.bat ，输入 1 启动 nginx 服务，监听 80 端口，目前已配置好如下几个服务。

<pre>
  [1] 启动Nginx
  [2] 关闭Nginx
  [3] 重启Nginx
  [4] 刷新控制台
  [5] 重新加载Nginx配置文件
  [6] 检查测试nginx配置文件
  [7] 查看nginx version
  [0] 退 出

请输入选择的序号: 1
</pre>

## 配置说明及测试访问路径
只需要在 \docs\nginx\nginx_1.11.11\conf\vhosts 下新增或修改虚拟站点。为了尽量接近生产环境，建议设置好 server_name 为本地测试域名，并在 hosts 解释这些域名到 127.0.0.1 。

```
server {
    listen  80 ;
    server_name neoframework-reports-site.local.cn;

    # 如果使用相对路径，注意是基于 nginx.exe 的位置，而不是 nginx.conf
    root ../www/neoframework-reports-site;
```

hosts（/etc/hosts 或 c:\Windows\system32\drivers\etc\hosts）
```
127.0.0.1 neoframework-reports-site.local.cn

# prod-site-demo.cn
127.0.0.1 prod-site-demo.cn
127.0.0.1 www.prod-site-demo.cn
127.0.0.1 test-manage.prod-site-demo.cn
127.0.0.1 test-b.prod-site-demo.cn
127.0.0.1 test-xb.prod-site-demo.cn
127.0.0.1 test-login.prod-site-demo.cn
127.0.0.1 test-h5.prod-site-demo.cn
127.0.0.1 ptx-m.prod-site-demo.cn
127.0.0.1 test-s.prod-site-demo.cn
```

访问路径则为： ```http://neoframework-reports-site.local.cn/```

### 目前 vhosts 下有以下站点：

#### 1. neoframework-reports-site.conf

静态 html 站点。一个默认站点和一个子站点。

* http://neoframework-reports-site.local.cn/
* http://neoframework-reports-site.local.cn/neo-site2/

#### 2. image-server.conf

简单的，反向代理到一个提供静态资源服务的应用。

#### 3. prod-site-demo.cn.conf

接近生产环境、反向代理到基于 docker 的一组相关服务应用，也有静态站点，静态图片服务。部署在域名 prod-site-demo.cn 下。

* http://prod-site-demo.cn
* http://www.prod-site-demo.cn
* http://test-manage.prod-site-demo.cn
* http://test-b.prod-site-demo.cn
* http://test-xb.prod-site-demo.cn
* http://test-login.prod-site-demo.cn
* http://test-h5.prod-site-demo.cn
* http://ptx-m.prod-site-demo.cn
* http://test-s.prod-site-demo.cn

#### 4. neoframework-wsdemo.localhost-spring-websocket-demo.conf

一个 Spring Cloud 多模块微服务，其中包含一个 WebSocket 模块多实例部署的配置。

```
# Websocket 模块多实例部署，本地测试
upstream lb_api {
        # 默认 round_robin ，其他 ip_hash, hash, least_conn 等;
        # ip_hash; # 不符合本地测试
        hash $remote_addr;
        server 127.0.0.1:8082;
        server 127.0.0.1:8083;
}

server {
        listen       80;
        server_name  wsdemo.localhost, localhost;

        # websocket实例
        location ^~ /api/ {
                # proxy_pass http://127.0.0.1:8082/api/;
                proxy_pass http://lb_api/api/;

                proxy_http_version 1.1;
                proxy_set_header Upgrade $http_upgrade;
                proxy_set_header Connection "upgrade";
                keepalive_requests 500;
        }
}
```

这个配置的相关项目：

* [spring-websocket-example](https://github.com/mingt/spring-websocket-example) Spring websocket 完整例子，参考、指引
* [neoframework-cloud-demo](https://github.com/mingt/neoframework-cloud-demo) 演示 Spring Cloud 基础功能和若干增强，如注册中心，配置中心， 认证中心等

## 其他

* Windows 下切换 hosts 推荐 [oldj/SwitchHosts](https://github.com/oldj/SwitchHosts)
