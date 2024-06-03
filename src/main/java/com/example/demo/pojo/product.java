package com.example.demo.pojo;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "productName")
	private String name;
	@Column(name = "componyName")
	private String componyName;
	@Column(name = "price",nullable = false)
	private float Price;
	@Column(name = "quantity",nullable=false)
	private int quantity;
	
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public product(int id, String name, String componyName, float price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.componyName = componyName;
		Price = price;
		this.quantity = quantity;
	}

	
	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public String getComponyName() {
		return componyName;
	}


	public void setComponyName(String componyName) {
		this.componyName = componyName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	
	

}
