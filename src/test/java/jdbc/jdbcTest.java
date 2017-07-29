package jdbc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jdbc.data.UserRepository;
import jdbc.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)

//@ContextConfiguration("classpath:data.xml")
@ContextConfiguration(classes=jdbc.config.DataConfig.class)

//@ActiveProfiles("embeded-h2")
//@ActiveProfiles("jdbc")
//@ActiveProfiles("jdbc-simple")
//@ActiveProfiles("jdbc-single-conn")
//@ActiveProfiles("pool-dbcp")
//@ActiveProfiles("pool-c3p0")
@ActiveProfiles("pool-druid")
public class jdbcTest {
	@Autowired
	private UserRepository userRepository;
	@Test
	public void testJdbc(){
		User user = new User(18, "raiden", "raiden@qq.com", "中国");
		userRepository.save(user);
		System.out.println(userRepository.findByUsername("raiden"));
		userRepository.deleteByUsername(user.getUsername());
	}
}
