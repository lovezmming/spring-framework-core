# spring-framework-core  
spring cloud  

2019-04-30  
1.拆分并设计架构分层  
2.集成组件：  
2.1 eureka服务注册中心  
2.2 logback日志  
2.3 mybatis  
2.4 feign接口调用  

2019-05-09  
1.调整分层  
2.集成组件：  
2.1 zuul网关服务  
2.2 hystrix熔断服务  
2.3 config配置中心  

2019-06-28  
1.config配置本地多数据源实现  
2.turbine：实现实时监控并显示到hystrix dashboard上  

2019-12-20  
springboot1.5->2.0版本升级  
springcloud->Finchley.RELEASE版本升级  
1.调整优化结构  
2.新增用户权限  
3.调整代码：  
  1）数据库建模调整：  
    数据库主键id采用自定义生成不采用自增主键（推荐雪花算法）   
  2）依据新版本进行配置调整  