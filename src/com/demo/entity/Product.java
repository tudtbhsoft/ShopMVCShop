package com.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_product;

	@Length(min = 5, max = 20, message = "Tên điện thoại phải từ 5 -  20 kí tự")
	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "amount")
	private int amount;

	@Column(name = "time")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date time;

	public Product() {
	}

	public Product(Long id_product, String name, String type, int amount, Date time) {
		super();
		this.id_product = id_product;
		this.name = name;
		this.type = type;
		this.amount = amount;
		this.time = time;
	}

	public Long getId_product() {
		return id_product;
	}

	public void setId_product(Long id_product) {
		this.id_product = id_product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
