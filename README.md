# :gift: Lottery 抽奖系统 - 基于领域驱动设计的四层架构实践

<br/>
<div align="center">
    <a href="https://bugstack.cn" style="text-decoration:none"><img src="https://codechina.csdn.net/KnowledgePlanet/Lottery/-/raw/210804_xfg_buildFramework/doc/_media/lottery.png" width="128px"></a>
</div>
<br/> 

>小傅哥，一线互联网 Java 工程师、架构师，开发过交易、营销类项目，实现过运营、活动类项目，设计过中间件，组织过系统重构，编写过技术专利。不仅从事业务系统的开发工作，也经常做一些字节码插桩类的设计和实现，对架构的设计和落地有丰富的经验。在热衷于Java语言的同时，也喜欢研究中继器、I/O板卡、C#和PHP，是一个技术活跃的折腾者。
>[:pencil2: 虫洞 · 科技栈，博主](https://bugstack.cn)，[:blue_book: 《重学Java设计模式》图书作者](https://item.jd.com/13218336.html)


⛳ **目录**

- 学习说明
- 项目介绍
- 系统架构
- 开发规范(分支、提交)
- 开发日记
- 问题交流
- 感谢支持

## 学习说明

`在此项目中你会学习到互联网公司关于C端项目开发时候用到的一些，技术、架构、规范等内容。由于项目为实战类编程项目，在学习的过程中需要上手操作，小傅哥会把系统的搭建拉不同的分支列为每一个章节进行设计和实现并记录到开发日记中，读者在学习的过程中可以结合这部分内容边看文章边写代码实践。`

- 技术：SpringBoot、Mybatis、Dubbo、MQ、Redis、Mysql、ELK、分库分表、Otter
- 架构：DDD 领域驱动设计、充血模型、设计模式
- 规范：分支提交规范、代码编写规范

## 项目介绍

这是一款互联网面向C端人群营销活动类的抽奖系统，它可以提供抽奖活动玩法策略的创建、参与、记账、发奖等逻辑功能。

运营人员通过创建概率类奖品的抽奖玩法，对用户进行拉新、促活、留存，通常这样的系统会用在电商、外卖、出行、公众号运营等各类场景中。

## 系统架构

- 待编写，当设计和输出完第一章节后，陆续补全系统架构

## 开发规范

**分支命名**：日期_姓名首字母缩写_功能单词，如：`210804_xfg_buildFramework`

**提交规范**：`作者，type: desc` 如：`小傅哥，fix：修复查询用户信息逻辑问题` *参考Commit message 规范*

```java
# 主要type
feat:     增加新功能
fix:      修复bug

# 特殊type
docs:     只改动了文档相关的内容
style:    不影响代码含义的改动，例如去掉空格、改变缩进、增删分号
build:    构造工具的或者外部依赖的改动，例如webpack，npm
refactor: 代码重构时使用
revert:   执行git revert打印的message

# 暂不使用type
test:     添加测试或者修改现有测试
perf:     提高性能的改动
ci:       与CI（持续集成服务）有关的改动
chore:    不修改src或者test的其余修改，例如构建过程或辅助工具的变动
```

## 	:octocat: 开发日记

- [x] [`第 01 章：`](#)
- [x] [`第 02 章：`](#)
- [ ] [`第 03 章：待归档`]()

## 🐾 问题交流

![](https://github.com/fuzhengwei/small-spring/blob/main/docs/assets/img/bugstack-md.png?raw=true)

<br/>
<div align="center">
    <a href="https://github.com/fuzhengwei/CodeGuide/wiki">关注小傅哥，你可以学到的更多！</a>
</div>
<br/>  

- **加群交流**

    本群的宗旨是给大家提供一个良好的技术学习交流平台，所以杜绝一切广告！由于微信群人满 100 之后无法加入，请扫描下方二维码先添加作者 “小傅哥” 微信(fustack)，备注：`Spring学习加群`。
    
    <img src="https://itedus.cn/_media/fustack.png?x-oss-process=style/may" width="180" height="180"/>

- **公众号(bugstack虫洞栈)**

    沉淀、分享、成长，专注于原创专题案例，以最易学习编程的方式分享知识，让自己和他人都能有所收获。目前已完成的专题有；Netty4.x实战专题案例、用Java实现JVM、基于JavaAgent的全链路监控、手写RPC框架、DDD专题案例、源码分析等。
    
    <img src="https://itedus.cn/_media/qrcode.png?x-oss-process=style/may" width="180" height="180"/>
    
## 🎉 感谢支持

参与到项目开发学习过程中的小伙伴，可以通过PR提交个人对项目中学习过程中一些关于，代码优化、逻辑完善、问题修复等各项内容。当你的代码完整的提交以后，我会进行 `review` 通过以后进行合并以及记录你的提交信息。

<a href="#小傅哥">
    <img src="" style="border-radius:5px" width="50px">
</a>
<a href="#小傅哥">
    <img src="" style="border-radius:5px" width="50px">
</a>
<a href="#小傅哥">
    <img src="" style="border-radius:5px" width="50px">
</a>
<a href="#小傅哥">
    <img src="" style="border-radius:5px" width="50px">
</a>