# Sober Ad Network `外`网协议

协议列表

1. 用户注册（支持Advertiser、Publisher两种角色）
2. 用户登录
3. 获取Advertiser列表
4. 获取offer列表

## 1.用户注册(signup)

**PUT** http://localhost:8080/signup

`请求结构`

``` JSON
{
  email:"",
  password:"",
  mobile:"",
  name:"",
  qq:""
}
```

注册成功之后，引导用户激活（第一阶段基于邮箱，后期基于手机验证）

``` JSON
{
  ret:"0",
  uid:xxxx
}
```

提示用户去激活或者验证。

## 2.用户登录获取access_token

> 第一阶段仅支持基于email和password进行登录

**POST** http://localhost:8080/login

`请求参数`

* email 
* password

`返回`

``` json
{"ret":"0","access_token":null,"expires_in":null}
```