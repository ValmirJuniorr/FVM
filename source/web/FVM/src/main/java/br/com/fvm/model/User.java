package br.com.fvm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "fvm", name = "Users")
@SequenceGenerator(name = "UserSequence", sequenceName = "SQ_ID_USER", allocationSize = 1, schema = "fvm")
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.Id = :id"),
	@NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login = :login") 
	})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSequence")
	@Column(name = "Id_User")
	private int Id;

	@Column(name = "Name_User", nullable = false, length = 32)
	private String name;

	@Column(name = "Email_User", nullable = false, length = 64)
	private String email;

	@Column(name = "Login_User", nullable = false, length = 32)
	private String login;

	@Column(name = "Password_User", nullable = false)
	private String password;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passowrd) {
		this.password = passowrd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
