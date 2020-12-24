/**
 * 
 */
package account.code.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Asd
 *
 */

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("account.code.repository")
public class DBConfig {

	@Bean
	public EntityManagerFactory entityManagerFactory(DataSource dataSource) {

		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		props.put("hibernate.hbm2ddl.auto", "none");
		props.put("hibernate.show_sql", "false");

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setDataSource(dataSource);
		factory.setPersistenceUnitName("defaultPersistenceUnit");
		factory.setPersistenceProvider(new HibernatePersistenceProvider());
		factory.setPackagesToScan("account.code.model");
		factory.setJpaProperties(props);
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory);
		return txManager;
	}

	
	@Bean(name = "dataSource")
	@Profile("!test")
	public DataSource dataSource(Environment env) {

		final int MAX_CONNECTION_POOL_SIZE = 12;
		final int MIN_CONNECTION_POOL_SIZE = 5;
		final long MAX_CONNECTION_WAIT_MS = 10000L;
		final long MIN_EVICTABLE_IDLE_TIME = 5000L;
		final int ABANDONED_TIMEOUT = 5;
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		datasource.setUrl(env.getProperty("spring.datasource.url"));
		datasource.setUsername(env.getProperty("spring.datasource.username"));
		datasource.setPassword(env.getProperty("spring.datasource.password"));
		// CSOFF: MagicNumber
		datasource.setInitialSize(MIN_CONNECTION_POOL_SIZE);
		datasource.setMaxTotal(MAX_CONNECTION_POOL_SIZE);
		datasource.setMinIdle(MIN_CONNECTION_POOL_SIZE);
		datasource.setMaxIdle(MAX_CONNECTION_POOL_SIZE);
		datasource.setMaxWaitMillis(MAX_CONNECTION_WAIT_MS);
		datasource.setMinEvictableIdleTimeMillis(MIN_EVICTABLE_IDLE_TIME);
		datasource.setRemoveAbandonedOnBorrow(true);
		datasource.setRemoveAbandonedTimeout(ABANDONED_TIMEOUT);
		// CSON: MagicNumber
		datasource.setTestOnBorrow(true);
		datasource.setValidationQuery("SELECT 1");
		return datasource;
	}

	@Bean(name = "dataSource")
	@Profile("test")
	public DataSource testDataSource() {

		EmbeddedDatabase db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
		                                                   .setScriptEncoding("UTF-8")
		                                                   .ignoreFailedDrops(true)
		                                                   .build();
		return db;
	}
}
