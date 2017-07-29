package jdbc.entity;

public class User {
	private Integer id;
	private Integer age;
	private String username;
	private String email;
	private String nationality;
	

	public User(Integer id, Integer age, String username, String email, String nationality) {
		super();
		this.id = id;
		this.age = age;
		this.username = username;
		this.email = email;
		this.nationality = nationality;
	}
	public User(Integer age, String username, String email, String nationality) {
		this(null, age, username, email, nationality);
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + ", username=" + username + ", email=" + email + ", nationality="
				+ nationality + "]";
	}
	
	public User() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
}
