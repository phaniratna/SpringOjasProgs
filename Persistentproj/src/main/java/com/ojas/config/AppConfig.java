package com.ojas.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ojas.model.Home;
import com.ojas.model.Member;

@Configuration
@ComponentScan(basePackages = "com.ojas")
@EnableTransactionManagement
@EnableWebMvc

public class AppConfig {

	@Bean
	public BasicDataSource dsObj() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/world");
		ds.setUsername("root");
		ds.setPassword("root");

		ds.setInitialSize(1);
		ds.setMaxIdle(2);
		ds.setMaxTotal(10);
		ds.setMinIdle(1);
		return ds;
	}

	@Bean
	public LocalSessionFactoryBean sfObj() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setAnnotatedClasses(Home.class, Member.class);
		sf.setDataSource(dsObj());
		sf.setHibernateProperties(props());
		return sf;
	}

	private Properties props() {
		Properties p = new Properties();
		p.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		p.put("hibernate.show_sql", "true");
		p.put("hibernate.format_sql", "false");
		p.put("hibernate.hbm2ddl.auto", "update");
		return p;
	}

	@Bean
	public HibernateTemplate htObj() {
		HibernateTemplate ht = new HibernateTemplate();
		ht.setSessionFactory(sfObj().getObject());
		return ht;
	}

	@Bean
	public HibernateTransactionManager htmObj() {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sfObj().getObject());
		return htm;
	}

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver ivr = new InternalResourceViewResolver();
		ivr.setSuffix(".jsp");
		ivr.setPrefix("/WEB-INF/jsps/");
		return ivr;
	}
}
