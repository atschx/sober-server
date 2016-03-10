# Sober Ad Network `外`网协议

> 协议列表
>
> 1. 用户注册（支持Advertiser、Publisher两种角色）
> 2. ajax邮箱唯一性校验
> 3. 激活用户账号（用户点击邮箱中的链接直接激活）
> 4. 获取user列表（按角色查询）

注意：

1. 所有协议均支持跨域访问。
2. 全局基于token校验操作合法性及安全性
3. 登录之后的请求协议头中统一添加 uid属性

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

`返回数据`

成功登录

``` JSON
{
  "ret": "0", 
  "token": "273ae6e812ac4ccfb7677ab8ae9dacf5", 
  "expires": 1453441218073
}
```

登录失败

``` JSON
{
  "ret": "1", 
  "token": null, 
  "expires": null
}
```

## 5.用户退出(signout)

> 此部分操作很简单：直接清空用户对应的token.

**GET** http://192.168.1.195:8080/signout?uid=xxxx&token=xxxx

> 参数说明：
>
> uid & token

返回结果：true or false 

## 6.用户列表

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

## 7.修改密码

**POST** http://192.168.1.195:8080/change-password

> 参数列表(必填),前缀加下划线用于区分 Header中的uid数据
>
> uid
>
> _old
>
> _new

返回ret值说明

``` JAVA
		if (user != null) {
			if(!user.getPassword().equals(oldPassword)){
				ret.setRet("1");// 密码不对
			}else{
				if(oldPassword.equals(newPassword)){
					ret.setRet("2");// 新密码不能和就密码一致
				}else{
					try {
						//update 
						user.setPassword(newPassword);
						userRepository.saveAndFlush(user);
					} catch (Exception e) {
						ret.setRet("500");
					}
				}
			}
		}else{
			ret.setRet("-1");// 不存在此用户
		}
```

## 8.查看用户详情

**GET** http://192.168.1.195:8080/user?uid=60000

``` JSON
{
  "id": 60000, 
  "name": "astchx", 
  "email": "atschx@gmail.com", 
  "password": "atschx", 
  "mobile": "13800001101", 
  "qq": null, 
  "status": 0, 
  "type": 1, 
  "accountManager": null
}
```



## 9.修改用户资料

**PUT** http://192.168.1.195:8080/user?uid=60000

请求结构

``` JSON
{
  "id": 60000, 
  "name": "astchx", 
  "email": "atschx@gmail.com", 
  "password": "atschx", 
  "mobile": "13800001101", 
  "qq": null, 
  "status": 0, 
  "type": 1, 
  "accountManager": null
}
```

返回结构

``` JSON
{
  "ret":"0"
}
```



## 10.Offer列表

**GET** http://192.168.1.195:8080/offers

> offer列表
>
> - 管理员可看到所有（可冻结及驳回）
> - 广告主可看到所有自己发布的offer(我的offer)
> - 流量主可以看到所有已通过审核正在竞价的offer(可申请)

参数列表(参数全部可选)

> page
>
> size
>
> owner
>
> status

`返回数据` (http://192.168.1.195:8080/offers?owner=60000&page=0&size=1 样例数据)

``` JSON
{
  "content": [
    {
      "id": 10, 
      "logo": null, 
      "name": "下载并注册QQ9", 
      "price": 2.2, 
      "priceModel": "CPA", 
      "clearingCycle": "WEEK", 
      "platform": "ANDROID", 
      "effDef": "下载注册用户，留存2周算作一个", 
      "status": 0, 
      "createdDate": 1453692772324, 
      "lastModifiedDate": 1453692772324
    }
  ], 
  "last": false, 
  "totalPages": 10, 
  "totalElements": 10, 
  "size": 1, 
  "number": 0, 
  "first": true, 
  "sort": [
    {
      "direction": "DESC", 
      "property": "id", 
      "ignoreCase": false, 
      "nullHandling": "NATIVE", 
      "ascending": false
    }
  ], 
  "numberOfElements": 1
}
```

## 11.创建Offer

> 广告主可以在系统中创建offer。第一阶段，offer对应的附件信息单独提供。

**POST** http://192.168.1.195:8080/offer

请求结构：

``` JSON
{
  "id": 10, 
  "logo": null, 
  "name": "下载并注册QQ9", 
  "price": 2.2, 
  "priceModel": "CPA", 
  "clearingCycle": "WEEK", 
  "platform": "ANDROID", 
  "effDef": "下载注册用户，留存2周算作一个"
}
```

PS：请求的Header中需要带uid

`返回结构`

## 12.查看Offer详情

> 用户点击对应的Offer可以获取到所有Offer相关的信息

**GET** http://192.168.1.195:8080/offer?offerId=10

> 参数说明：offerId

返回数据(第一阶段)

``` JSON
{
  "id": 10, 
  "logo": null, 
  "name": "下载并注册QQ9", 
  "price": 2.2, 
  "priceModel": "CPA", 
  "clearingCycle": "WEEK", 
  "platform": "ANDROID", 
  "effDef": "下载注册用户，留存2周算作一个", 
  "status": 0, 
  "createdDate": 1453693769314, 
  "lastModifiedDate": 1453693769314
}
```

## 13.修改Offer信息

> 广告主可以适当的调整Offer中的内容，但不能处理价格信息？？

**PUT**  http://192.168.1.195:8080/offer?offerId=10

``` JSON
{
  "id": 10, 
  "logo": null, 
  "name": "下载并注册QQ9", 
  "price": 2.2, 
  "priceModel": "CPA", 
  "clearingCycle": "WEEK", 
  "platform": "ANDROID", 
  "effDef": "下载注册用户，留存2周算作一个", 
  "status": 0, 
}
```

## 14.流量主申请Offer

**POST** http://192.168.1.195:8080/apply-offer?publisher=1111&offer=xxx

> 参数说明
>
> publisher  流量主id
>
> offer 被申请的offerId

返回值

``` JSON
{
  "ret":"0",
  "aid":zxxxxx
}
```

## 15.流量主申请的Offer列表

**GET** http://192.168.1.195:8080/publisher-apply-offers?page=1&size=2&publisher=1111&status=1&offer=xxx

> 参数说明
>
> publisher 
>
> status
>
> offer

返回列表数据

> 暂无