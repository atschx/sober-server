# Sober Ad Network `外`网协议

> 协议列表
> 
> 1. 用户注册（支持Advertiser、Publisher两种角色）
> 2. ajax邮箱唯一性校验
> 3. 激活用户账号（用户点击邮箱中的链接直接激活）
> 4. 获取user列表（按角色查询）

注意：所有协议均支持跨域访问。目前未做全局token可用性校验。

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

**GET** http://192.168.1.195:8080/check-email?email=xxx

参数：email 必填

返回

”true“ 可用 “false” 不可用

## 3.激活帐号(signup-verify)

> 邮箱中的链接用于激活帐号

**GET** http://192.168.1.195:8080/signup-verify

`请求参数`

* token (必填)

`返回`

”true“ 可用 “false” 不可用

## 4.用户登录(Signin)

> 第一阶段：仅支持用户邮箱及密码登录。

**POST** http://192.168.1.195:8080/signin-with-email/{role}

> PathParam
> 
> 参数列表：
> 
> email & password 必填

返回参数

``` JSON

```



## 5.用户列表

> 分页请求，统一返回如下JSON结构。

**GET** http://192.168.1.195:8080/users?role=ROLE_ADVERTISER&page=1&size=2

> 参数列表(全部可选):
> 
> role  取值 ：ROLE_ADVERTISER,ROLE_PUBLISHER,ROLE_SUPERVISOR
> 
> page 第几页
> 
> size   每页条数

返回数据

``` JSON
{
  "content": [
    {
      "id": 60007, 
      "name": "advertiser-5", 
      "email": "advertiser-5@advertiser.com", 
      "password": "advertiser", 
      "mobile": null, 
      "qq": null, 
      "status": 0, 
      "type": 1, 
      "accountManager": null
    }, 
    {
      "id": 60006, 
      "name": "advertiser-4", 
      "email": "advertiser-4@advertiser.com", 
      "password": "advertiser", 
      "mobile": null, 
      "qq": null, 
      "status": 0, 
      "type": 1, 
      "accountManager": null
    }
  ], 
  "last": false, 
  "totalElements": 8, 
  "totalPages": 4, 
  "size": 2, 
  "number": 1, 
  "sort": [
    {
      "direction": "DESC", 
      "property": "id", 
      "ignoreCase": false, 
      "nullHandling": "NATIVE", 
      "ascending": false
    }
  ], 
  "first": false, 
  "numberOfElements": 2
}
```

