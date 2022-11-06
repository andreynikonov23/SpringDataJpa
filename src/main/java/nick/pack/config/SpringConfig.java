package nick.pack.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@ComponentScan("nick.pack")
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories("nick.pack.repository")
public class SpringConfig implements WebMvcConfigurer {
private final ApplicationContext context;
	
	@Autowired
	public SpringConfig(ApplicationContext context) {
		this.context = context;
	}
	
	
				//Web MVC Configuration
	//Resource Template Resolver configuration
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(context);
		templateResolver.setPrefix("/WEB-INF/view/");
		templateResolver.setSuffix(".html");
		return templateResolver;
	}
	//Template Engine configuration
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}
	//Enable Thymeleaf template engine
	public void configureViewResolvers(ViewResolverRegistry registry) {
		ThymeleafViewResolver thymeleaf = new ThymeleafViewResolver();
		thymeleaf.setTemplateEngine(templateEngine());
		thymeleaf.setCharacterEncoding("UTF-8");
		registry.viewResolver(thymeleaf);
	}
				//Data Base connect configuration
	//Data Base connect
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManager = new DriverManagerDataSource();
		driverManager.setDriverClassName("com.mysql.jdbc.Driver");
		driverManager.setUrl("jdbc:mysql://localhost:3306/bank_db?serverTimezone=UTC");
		driverManager.setUsername("root");
		driverManager.setPassword("1111");
		return driverManager;
	}

	//Hibernate configuration
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean manager = new LocalContainerEntityManagerFactoryBean();
		manager.setDataSource(dataSource());
		manager.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		manager.setPackagesToScan("nick.pack.models");
		manager.setJpaProperties(getHibernateProperties());
		return manager;
	}
		
	//JpaTransactionManager configuration
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactory().getObject());
		return manager;
	}
	//Hibernate setting configuration
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
}
