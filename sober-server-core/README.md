# sober-server-core

> 基本包结构说明：config , domain , service , xxxApplication 

*config:* 配置

domain: DDD

service:

xxxApplication 样例代码

`正式环境运行`

``` bash
java -jar -Dspring.profiles.active=prod sober-server-core.jar
```

Feature

* 基于Hibernate的 enhanced TableGenerator生成ID
* HikariCP
* Profile机制

业务领域：

1. 注册用户
2. 广告设置
3. 投放代码
4. 支付佣金