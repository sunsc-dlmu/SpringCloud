# SpringCloud学习
搭建基本的SpringCloud环境，后续将持续更新.....

# 1.项目学习来源
根据2020年尚硅谷SpringCloud视频学习，自己重新搭建环境
# 2.项目环境
IDE：IDEA<br>
JDK：12.0<br>
数据库：mysql8.0.20<br>
# 3.项目结构解析
### 2.1 sunsc_springcloud
项目的父工程，用于对jar包版本进行集中管理
### 2.2 cloud-api-common
封装了基本的Bean，供其他的子模块使用
### 2.3 cloud-eureka-server7001
服务的注册中心（端口号7001），所有的服务消费者和服务提供者，都要将服务注册到该Eureka注册中心(Eureka模块在2020年停更，面临淘汰，大概知道怎么用就可以)
### 2.4 cloud-provider-payment8001
服务提供者（端口号8001），提供服务，并将服务注册到注册中心，供消费者查找使用。
### 2.5 cloud-consumer-order80
服务消费者（端口号80），从注册中心中找到服务提供者提供的服务进行消费。

# 未来在持续更新中.....


