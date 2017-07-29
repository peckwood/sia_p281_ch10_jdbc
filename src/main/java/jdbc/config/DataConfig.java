package jdbc.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan("jdbc.data")
public class DataConfig {
	private final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	private final String USERNAME = "raiden";
	private final String PASSWORD = "raiden";
	private final String URL = "jdbc:mysql://localhost:3307/sia_p281_ch10_jdbc";
	private final int INITIAL_POOL_SIZE = 3;
	private final int MAX_ACTIVE = 20;

	@Bean
	public JdbcOperations jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(name = "dataSource")
	@Profile("embeded-h2")
	public DataSource h2() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("schema.sql").build();
	}
	
	@Bean(name="dataSource")
	@Profile("jdbc")
	public DataSource jdbc(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(DRIVER_CLASS_NAME);
		ds.setUrl(URL);
		ds.setUsername(USERNAME);
		ds.setPassword(PASSWORD);
		return ds;
	}
	@Bean(name="dataSource")
	@Profile("jdbc-simple")
	public DataSource simpleJdbc(){
		SimpleDriverDataSource ds = new SimpleDriverDataSource();
		ds.setDriverClass(com.mysql.jdbc.Driver.class);
		ds.setUrl(URL);
		ds.setUsername(USERNAME);
		ds.setPassword(PASSWORD);
		return ds;
	}
	@Bean(name="dataSource")
	@Profile("jdbc-single-conn")
	public DataSource singleConnJdbc(){
		SingleConnectionDataSource ds = new SingleConnectionDataSource();
		ds.setDriverClassName(DRIVER_CLASS_NAME);
		ds.setUrl(URL);
		ds.setUsername(USERNAME);
		ds.setPassword(PASSWORD);
		return ds;
	}

	@Bean(name = "dataSource")
	@Profile("pool-dbcp")
	public DataSource dbcp() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(DRIVER_CLASS_NAME);
		ds.setUrl(URL);
		ds.setUsername(USERNAME);
		ds.setPassword(PASSWORD);
		ds.setInitialSize(INITIAL_POOL_SIZE);
		return ds;
	}
	@Bean(name = "dataSource")
	@Profile("pool-c3p0")
	public DataSource c3p0() throws PropertyVetoException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setDriverClass(DRIVER_CLASS_NAME);
		ds.setJdbcUrl(URL);
		ds.setUser(USERNAME);
		ds.setPassword(PASSWORD);
		ds.setInitialPoolSize(INITIAL_POOL_SIZE);
		return ds;
	}
	@Bean(name = "dataSource")
	@Profile("pool-druid")
	public DataSource druid() {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(DRIVER_CLASS_NAME);
		ds.setUrl(URL);
		ds.setUsername(USERNAME);
		ds.setPassword(PASSWORD);
		ds.setInitialSize(INITIAL_POOL_SIZE);
		ds.setMaxActive(MAX_ACTIVE);
		return ds;
	}

}
