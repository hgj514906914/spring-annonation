# <center> Springע�⿪��֪ʶ����� </center>  
## 1. @Importע��  
### 1. �������bean��idΪȫ�����������������磺<code>@Import({Blue.class,Green.class})</code>
### 2. ����ʹ��ʵ��ImportSelector����ImportBeanDefinitionRegistrar�����ض�����߰���������
---    
## 2. @Conditionalע��  
### 1. ���������ϻ��߷����ϣ���������ע�룬���Կ��������������౻ע��  �磺<code>@Conditional({MyCondition.class})</code>
---  
  
  
# ��ͳSSM����


# Spring4��xml�ļ�����mybatis����springbootһ�£� 
## ��Ҫ����org.mybatis.spring.annotation.MapperScan��������  
### 1. pom�ļ������mybatis-spring��spring-jdbc,mysql-connector-java,org.mybatis֧��

# Spring ����SpringMvc
## ԭ���������Ϊservlet3.0��Ĭ�ϻ������Ŀ����jar�� �µ�META-INF/services/javax.servlet.ServletContainerInitializer�࣬
## ��spring-web�ж�����org.springframework.web.SpringServletContainerInitializer������ͨ��@HandlesTypesȥʵ������
## org.springframework.web.WebApplicationInitializer�ӿڵ��������࣬����������2�ַ�ʽ�����ɣ���һ��������servlet3.0�ļ��ػ��Ƽ̳�
## WebApplicationInitializer�ӿ� ʵ��onstartup�����ж�̬���DispatcherServlet ������spring�ٷ����Ƽ��̳�AbstractAnnotationConfigDispatcherServletInitializer
## ��ʵ�����еĲ��ַ���������������
