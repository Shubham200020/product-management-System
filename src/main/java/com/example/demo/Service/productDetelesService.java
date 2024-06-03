package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.pojo.product;
import com.example.demo.pojo.productDeteles;
@Service
public class productDetelesService {
	
	
	
	public float mardinCalcul(product prd,productDeteles productDeteles) {
		float buyingprice=productDeteles.getBuyingPrice();
		float sayingprice=prd.getPrice();
		
		return sayingprice-buyingprice;
	}
	
	
	public float expectedMarginCallectin(product prd,productDeteles productDeteles) {
		float margin=productDeteles.getMargin();
		int qnt=prd.getQuantity();
		return margin*qnt;
	}
	
	
	public float expectGrossCollectin(product prd,productDeteles productDeteles) {
		float margin=prd.getPrice();
		int qnt=prd.getQuantity();
		return margin*qnt;
	}	
	
	public float currentGrossCollectin(product prd,productDeteles productDeteles,int quantity) {
		float margin=prd.getPrice();
		float nowmargin=margin*quantity;
		if(productDeteles.getGrosPrice()==0) {
			return nowmargin;
		}
		
		return productDeteles.getCorrgrosPrice()+nowmargin;
	}
	
	
	public float currentProfitCollectin(productDeteles productDeteles,int quantity) {
		float margin=productDeteles.getMargin();
		float nowmargin=margin*quantity;
		if(productDeteles.getCorrentProfit()==0) {
			return nowmargin;
		}
		
		return productDeteles.getCorrentProfit()+nowmargin;
	}
 
}
