package com.example.demo.pojo;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "productdeteles")
public class productDeteles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "margin",nullable = false)
	private float margin;
	@Column(name = "expecetedprofit",nullable=false)
	private float expectedProfit;
	@Column(name = "currentprofit",nullable = false)
	private float correntProfit;
	@Column(name = "buyingPrice",nullable = false)
	public float buyingPrice;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private product produ;
	@Column(name = "exgrossprice",nullable = false)
	private float grosPrice;
	@Column(name = "Corgrossprice",nullable = false)
	private float corrgrosPrice;
	public productDeteles() {
		super();
		// TODO Auto-generated constructor stub
	}
	



	public productDeteles(int id, float margin, float expectedProfit, float correntProfit, float buyingPrice,
			product produ, float grosPrice, float corrgrosPrice) {
		super();
		this.id = id;
		this.margin = margin;
		this.expectedProfit = expectedProfit;
		this.correntProfit = correntProfit;
		this.buyingPrice = buyingPrice;
		this.produ = produ;
		this.grosPrice = grosPrice;
		this.corrgrosPrice = corrgrosPrice;
	}


	public float getCorrgrosPrice() {
		return corrgrosPrice;
	}




	public void setCorrgrosPrice(float corrgrosPrice) {
		this.corrgrosPrice = corrgrosPrice;
	}




	public float getGrosPrice() {
		return grosPrice;
	}








	public void setGrosPrice(float grosPrice) {
		this.grosPrice = grosPrice;
	}







	public float getBuyingPrice() {
		return buyingPrice;
	}



	public void setBuyingPrice(float buyingPrice) {
		this.buyingPrice = buyingPrice;
	}



	public product getProdu() {
		return produ;
	}

	public void setProdu(product produ) {
		this.produ = produ;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getMargin() {
		return margin;
	}
	public void setMargin(float margin) {
		this.margin = margin;
	}
	public float getExpectedProfit() {
		return expectedProfit;
	}
	public void setExpectedProfit(float expectedProfit) {
		this.expectedProfit = expectedProfit;
	}







	public float getCorrentProfit() {
		return correntProfit;
	}







	public void setCorrentProfit(float correntProfit) {
		this.correntProfit = correntProfit;
	}
	
	
	
}
