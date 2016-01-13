# sober-server-adnetwork

> Ad Network `外`网通讯协议

协议列表

1. 用户注册（advisiters、流量主）
2. 用户登录
3. 获取Advertiser列表
4. 获取offer列表

## 2.用户登录

> 第一阶段仅支持基于email和password进行登录

**POST** http://localhost:8080/login

`请求参数`

* email 
* password

`返回`

``` json
{"ret":"0","token":null,"expiresIn":null}
```

