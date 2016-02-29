# Sober Ad Network

> 外部协议
>
> - 针对外网用户部分，分为广告主advertiser和流量主publisher.
>
> 内部协议：
>
> - 针对运营及管理人员
>
> 流程设计：
>
> [创建offer](#广告主创建offer流程)
>
> [](#)
>
> ​	

注：内部协议与外部协议不通。

[内部协议](https://github.com/atschx/sober-server/tree/master/sober-server-adnetwork/sober-adnetwork-internal.md)

[外部协议](https://github.com/atschx/sober-server/tree/master/sober-server-adnetwork/sober-adnetwork-external.md)

## 广告主创建offer流程

> 广告主根据自己需求，在系统中创建offer。

offer的基础字段(此部分存在信息即可提交)：

- image（offer图片）此部分考虑由用户上传
- name
- desc
- price 价格
- priceModel (计价模式)
- clearingCycle (结算周期)
- status(状态：
  - 0 pending for approval
  - 1 approval 
  - 2 rejected 
- advertiser (所属广告主)  一个offer只能由一个用户创建

### 子流程：添加offer附加资源

> 有时需广告主添加offer的附加素材：如小版本应用包

offer-attchment

- short url (每个文件需要存在对应的下载短链，供流量主申请时使用）
- ​

