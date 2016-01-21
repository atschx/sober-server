# Sober Ad Network `外`网协议

协议列表

1. 用户注册（支持Advertiser、Publisher两种角色）
2. ajax邮箱唯一性校验
3. 获取Advertiser列表
4. 获取offer列表

## 1.用户注册(signup)

> 第一阶段仅支持email＋password注册

**POST** http://192.168.1.195:8080/signup-with-email

> 请求参数
> 
> name
> 
> email(必填)
> 
> password(必填)

注册成功之后，引导用户激活（第一阶段基于邮箱，后期基于手机验证）

``` JSON
{
  ret:"0",
  uid:xxxx
}
```

提示用户去激活或者验证。（此部分回收到邮件）

PS：填写注册时，email字段需要ajax判断是否适用。

## 2.Ajax校验email的唯一性

> 同一个邮箱仅允许一个帐号

**GET** http://192.168.1.195:8080/signup-with-email?email=xxx

参数：email 必填

返回

”true“ 可用 “false” 不可用



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