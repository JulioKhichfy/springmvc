package br.com.julio.springmvc;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.CacheControl;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@ComponentScan(basePackages = "br.com.julio.springmvc")//basePackageClasses={ HomeController.class, FestaRepository.class })
@Configuration
@EnableWebMvc
@EnableWebSecurity
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "br.com.julio.springmvc.repository")
public class WebConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// Register resource handler for CSS and JS
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/")
				.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

		// Register resource handler for images
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
				.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

		registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/").resourceChain(false);
	}

	
	 @Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/login").setViewName("login");
	  }

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		 .antMatchers("/images/**","/webjars/**","/resources/**","/resources/static/**")
         .permitAll()
		.antMatchers("/login**").permitAll()
		.antMatchers("/index**").permitAll()
		.antMatchers("/loadbase**").permitAll()
		.antMatchers("/pedido**").permitAll()
		.and()
			.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
				.antMatchers("/login**").permitAll()
				.antMatchers("/index**").permitAll()
				.antMatchers("/admin**").hasRole("ADMIN")
		.and().formLogin()
			.usernameParameter("email")
			.passwordParameter("senha")
			.loginPage("/login")
			.loginProcessingUrl("/loginAction").permitAll()
			.failureUrl("/login.jsp?error=true")
			 
		//.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
		.and().csrf().disable();
	}

	//TODO: ver isso
	/*@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}*/

	/*
	 * @Bean public ViewResolver internalResourceViewResolver() {
	 * InternalResourceViewResolver bean = new InternalResourceViewResolver();
	 * bean.setViewClass(JstlView.class); bean.setPrefix("/WEB-INF/templates/");
	 * bean.setSuffix(".jsp"); return bean; }
	 */

	
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		return tilesViewResolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[] { "/WEB-INF/tiles/tiles.xml" });
		tiles.setCheckRefresh(true);
		return tiles;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "br.com.julio.springmvc.model" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		// dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/festasDB");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("org.hibernate.SQL", "true");
		
		// Setting C3P0 properties
		/*properties.setProperty("hibernate.c3p0.min_size","5");
		properties.setProperty("hibernate.c3p0.max_size","20");
		properties.setProperty("hibernate.c3p0.acquire_increment","1");
		properties.setProperty("hibernate.c3p0.timeout","1800");
		properties.setProperty("hibernate.c3p0.max_statements","150");*/
		
		//show sql statement
		properties.setProperty("spring.jpa.show-sql" ,"true");
		//show sql values
		properties.setProperty("sspring.jpa.properties.hibernate.use_sql_comments" ,"true");
		
		properties.setProperty("spring.jpa.properties.hibernate.format_sql" ,"true");
		
		properties.setProperty("spring.jpa.properties.hibernate.type","trace"); 
		
		return properties;
	}
}