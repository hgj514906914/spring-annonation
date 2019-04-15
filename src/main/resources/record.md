# <center> Spring注解开发知识点汇总 </center>  
## 1. @Import注解  
### 1. 导入的类bean的id为全类名（包含包名）如：<code>@Import({Blue.class,Green.class})</code>
### 2. 可以使用实现ImportSelector或者ImportBeanDefinitionRegistrar来加载多个或者按条件加载
---    
## 2. @Conditional注解  
### 1. 作用于类上或者方法上，用于条件注入，可以控制满足条件的类被注入  如：<code>@Conditional({MyCondition.class})</code>
---  
  
  
# 传统SSM整合


# Spring4无xml文件整合mybatis（和springboot一致） 
## 主要利用org.mybatis.spring.annotation.MapperScan来做整合  
### 1. pom文件中添加mybatis-spring和spring-jdbc,mysql-connector-java,org.mybatis支持

# Spring 整合SpringMvc
## 原理解析：因为servlet3.0中默认会加载项目所有jar包 下的META-INF/services/javax.servlet.ServletContainerInitializer类，
## 而spring-web中定义了org.springframework.web.SpringServletContainerInitializer，该类通过@HandlesTypes去实例化了
## org.springframework.web.WebApplicationInitializer接口的所有子类，所以我们有2种方式来集成，第一种是利用servlet3.0的加载机制继承
## WebApplicationInitializer接口 实现onstartup方法中动态添加DispatcherServlet ，但是spring官方更推荐继承AbstractAnnotationConfigDispatcherServletInitializer
## 来实现其中的部分方法创建容器即可
