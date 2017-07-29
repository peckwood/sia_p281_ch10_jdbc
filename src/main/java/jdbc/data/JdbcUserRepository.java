package jdbc.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jdbc.entity.User;

@Repository
public class JdbcUserRepository implements UserRepository {
  
  private JdbcOperations jdbcOperations;

  @Autowired
  public JdbcUserRepository(JdbcOperations jdbcOperations) {
    this.jdbcOperations = jdbcOperations;
  }

  public User save(User user) {
    jdbcOperations.update(
        "insert into user (username, age, email, nationality)" +
        " values (?, ?, ?, ?)",
        user.getUsername(),
        user.getAge(),
        user.getEmail(),
        user.getNationality());
    return user; 
  }

  public User findByUsername(String username) {
    return jdbcOperations.queryForObject(
        "select id, age, username, email, nationality from user where username=?", 
        new UserRowMapper(), 
        username);
  }

  @Override
  public void deleteByUsername(String username){
	  jdbcOperations.update("delete from user where username=?", username);
  }
  
  
  private static class UserRowMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      return new User(
    		  rs.getInt("id"),
    		  rs.getInt("age"),
    		  rs.getString("username"),
    		  rs.getString("email"),
    		  rs.getString("nationality"));
    }
  }

}
