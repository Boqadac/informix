package main;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.cfg.DefaultComponentSafeNamingStrategy;
import org.hibernate.dialect.PostgresPlusDialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class JpaConfiguration {

	@Value("#{dataSource}")
	private javax.sql.DataSource dataSource;

	@Bean
	public Map<String, Object> jpaProperties() {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("hibernate.dialect", PostgresPlusDialect.class.getName());
		props.put("javax.persistence.validation.factory", validator());
		props.put("hibernate.ejb.naming_strategy",
				DefaultComponentSafeNamingStrategy.class.getName());
		return props;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		hibernateJpaVendorAdapter.setDatabase(Database.INFORMIX);
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(
				localContainerEntityManagerFactoryBean().getObject());
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(this.dataSource);
		lef.setPackagesToScan("dao");
		lef.setJpaPropertyMap(this.jpaProperties());
		lef.setJpaVendorAdapter(this.jpaVendorAdapter());
		return lef;
	}

}
