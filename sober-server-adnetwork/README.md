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

注：内部协议与外部协议不通，因此单独列出：

[内部协议](https://github.com/atschx/sober-server/tree/master/sober-server-adnetwork/sober-adnetwork-internal.md)

[外部协议](https://github.com/atschx/sober-server/tree/master/sober-server-adnetwork/sober-adnetwork-external.md)

## 1.创建offer

> 广告主根据自己需求，在系统中创建offer

offers 数据结构说明

- id 唯一性标识
- name 必填
- cover 用户依据需要上传offer对应的图片，可选。
- price 价格 ¥ 人名币价格
- price_model  计价模式 CPA/CPS/CPM
- clearing_cycle 结算周期 month/week/day
- eff_desc  必填 有效定义
- status 状态
  - 0 pending 
  - 1 approved 
  - 2 rejected
- advertiser_id (a offer belongs to one advertiser) 
- replay

### 1.1 offer 附加资源

> 因广告主创建offer时需要提供各种个样的文件(如小版本应用包)，server存储路径
>
> /adviser/offer/文件列表(一个文件对应一个多个文件时需要自行打包zip)
>
> 上传成功后，server生成对应的短链。

offer-attachments 数据结构说明：

- id  附件id
- name 附件名称 一般为文件名
- offer_id 关联的offer
- store_path server对附件的存储路径
- short_url 每个附件对应的下载短链
- checksum 文件校验码

**注意** 此部分文件生命周期随offer周期，过期之后由后台作业定时删除。

### 1.2 offer 管理（广告主对自己创建的 offer ）

> 广告主可以对创建的 offer 进行下架。

检索条件：offer's advertiser = current login (user) advertiser

monitor 部分待考虑

## 2.申请offer

> 流量主 `publisher` 按分类、按价格、按状态 检索 管理员 已审核过的offer 

选中一个指定的 offer 后，点击 apply，即产生一次申请 offer 请求。​

系统产生的记录为：

offer_apply_list

- apply id 申请事务号
- offer id 
- publisher 
- status (目前申请的状态
  - 0 pending  挂起
  - 1 approved 通过
  - 2 rejected 驳回
- remark （ 流量主申请 offer 时 填写 ）
- replay （ 拒绝 publisher 的申请时 管理员填写）

对于同一个 offer ，publisher 不可重复申请（但在展示界面依然展示已申请的offer)

##3.管理员操作

> 管理员 可以负责几个指定账号的管理权限。因此在展示数据时，需要先获取到当前管理员 incharge的账号列表，然后获取相应的数据。可以K号等

批准 offer 

按创建时间，按价格，按广告主，按分类 展示所有未审核的offer（同时支持按状态查询offer）。

批准 申请

按申请时间，按流量主，展示等待通过的申请

用户管理

禁用某个用户，同时停止掉所有相关的offer及列表。