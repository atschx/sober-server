# Sober Ad Network

> 外部协议
>
> - 针对外网用户部分，分为广告主 advertiser 和流量主 publisher .
>
> 内部协议：
>
> - 针对运营及管理人员
>
> 核心流程：
>
> [**广告主**创建 offer ](#1创建offer)
>
> [**流量主**申请 offer](#2申请offer)
>
> **管理员**审核广告主创建的offer、处理流量主的申请、同时控制账号的使用权。
>
> [](#)
>
> ​	

注：内部协议与外部协议不通，因此单独列出：

[内部协议](https://github.com/atschx/sober-server/tree/master/sober-server-adnetwork/sober-adnetwork-internal.md)

[外部协议](https://github.com/atschx/sober-server/tree/master/sober-server-adnetwork/sober-adnetwork-external.md)

## 1.创建offer

> 广告主根据自己需求，在系统中创建offer

offer的基础字段(此部分存在信息即可提交)：

- cover 用户依据需要上传offer对应的图片，可选。
- name 必填
- desc  必填 描述性说明
- price 价格 ¥ 人名币价格
- price-model  计价模式 CPA/CPS/CPM
- clearing-cycle 结算周期 month/week/day
- status 状态
  - 0 pending for approval
  - 1 approval 
  - 2 rejected 
- advertiser (a offer belongs to one advertiser) 

### 1.1 子流程：上传附加资源

> 因广告主创建offer时需要提供各种个样的文件(如小版本应用包)，server存储路径
>
> /adviser/offer/文件列表(一个文件对应一个多个文件时需要自行打包zip)
>
> 上传成功后，server生成对应的短链。

offer-attachment 基础字段：

- server-path
- short-url
- hash

**注意** 此部分文件生命周期随offer周期，过期之后由后台作业定时删除。

### 1.2 offer 管理

> 广告主可以对创建的 offer 进行下架。

检索条件：offer's advertiser = current login advertiser

monitor 部分待考虑

## 2.申请offer

> 流量主 `publisher` 按分类、按价格、按状态 检索 管理员 已审核过的offer 

选中一个指定的 offer 后，点击 apply，即产生一次申请 offer 请求。

​	

- 渠道备注（因目前流程原因此部必不可少）

系统产生的记录为：

offer_apply_list

- apply id 申请事务号
- offer id 
- publisher 
- status (目前申请的状态
  - 0 pending 
  - 1 approval
  - 2 rejected 
- remark (流量主申请offer时 填写)
- replay （在offer被拒绝时由管理员填写）

对于同一个 offer ，publisher 不可重复申请（但在展示界面依然展示已申请的offer)

