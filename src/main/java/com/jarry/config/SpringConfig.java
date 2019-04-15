package com.jarry.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jarry.model.Student;

@Configuration
@ComponentScan(value= {"com.jarry.*"}/*,excludeFilters = {
		@Filter(type = FilterType.CUSTOM , classes = MyFilter.class)
}*/)
//@Import({Blue.class,Green.class})
// 1 使用includeFilters 时必须关闭默认的filters  useDefaultFilters = false 
//@EnableAspectJAutoProxy
@MapperScan(basePackages = "com.jarry.dao") //集成mybatis Mapper
@EnableTransactionManagement
public class SpringConfig {
	
	@Conditional({MyCondition.class})
	@Bean
	public Student student () {
		return new Student();
	}
	
	//1 配置数据源
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource(); 
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost:3306/tuan");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	//2 配置SqlSessionFactoryBean 
	@Bean
	public SqlSessionFactory sessionFactoryBean() throws Exception{
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setMapperLocations(new Resource[] {new PathResource("src/main/resources/mapper/goods.xml")});  
		sessionFactoryBean.setDataSource(dataSource());
		return sessionFactoryBean.getObject() ; 
	}
	
	//3 配置事务 
	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager ;
	}
	
    

}

class MyCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		if(context.getRegistry().containsBeanDefinition("com.jarry.model.Green")) {
			return true ;
		}else
		return false;
	}
}