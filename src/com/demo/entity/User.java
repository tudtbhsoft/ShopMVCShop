package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;

	@Length(min = 5, max = 20, message = "Tên tài khoản phải từ 5-20 kí tự")
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Length(min = 5, max = 20, message = "Tên người dùng phải từ 5-20 kí tự")
	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private int age;

	@Length(min = 2, max = 4, message = "Giới tính phải là Nam, Nữ hoặc Khác")
	@Column(name = "sex")
	private String sex;

	public User() {
	}

	public User(Long id_user, String username, String password, String name, int age, String sex) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.password = password;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
