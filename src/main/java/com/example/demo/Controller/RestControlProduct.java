package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repositry.AccountRepo;
import com.example.demo.Repositry.ProductDetelesRepo;
import com.example.demo.Repositry.ProductRepo;
import com.example.demo.Service.productDetelesService;
import com.example.demo.pojo.product;
import com.example.demo.pojo.productDeteles;

@RestController
@RequestMapping("/product")
@CrossOrigin("http://localhost:4200/")
public class RestControlProduct {
	@GetMapping("/")
	public String getTest() {
		return "Hello Shubham";
	}
	@Autowired
	private ProductDetelesRepo productDetelesRepo;
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private productDetelesService productDetelesService;
	@Autowired
	private AccountRepo accountRepo;
	
	
	
	@PostMapping("/insert-product")
	public product insertProduct(@RequestBody product pod) {
		productRepo.save(pod);
		return pod;
	}
	
	
	@PostMapping("/insert-producr-deteles")
	public productDeteles insertProduct(@RequestBody productDeteles productDeteles)
	{
		product prd=productDeteles.getProdu();
		productDeteles.setId(prd.getId());
		productDeteles.setMargin( productDetelesService.mardinCalcul(prd, productDeteles));
		productDeteles.setExpectedProfit(productDetelesService.expectedMarginCallectin(prd, productDeteles));
		productDeteles.setCorrentProfit( productDetelesService.currentProfitCollectin(productDeteles, 0));
		productDeteles.setGrosPrice(productDetelesService.expectGrossCollectin(prd, productDeteles));
		//productDetelesService.expectGrossCollectin(prd, productDeteles);
		productDetelesRepo.save(productDeteles);
		return productDeteles;
	}
	
	
	@GetMapping("search-by-Id/{id}")
	public List<product> getBys(@PathVariable("id") int id) 
	{
		product pr=null;
		List<product> pro=new ArrayList<>();
		pr=productRepo.findById(id).get();
		pro.add(pr);
		return pro;
	}
	
	
	@GetMapping("search-by-name/{name}")
	public List<product> getByName(@PathVariable("name") String name) 
	{
		List<product> pr=new ArrayList<>();
		List<product> prod=productRepo.findAll();
		//pr=productRepo.findById(id).get();
		for(product p:prod) {
			if(name.equalsIgnoreCase(p.getName())) {
				pr.add(p);
			}
		}
		return pr;
	}
	
	
	@GetMapping("search-by-comname/{name}")
	public List<product> getByComName(@PathVariable("name") String name) 
	{
		List<product> pr=new ArrayList<>();
		List<product> prod=productRepo.findByName(name);
		
		for(product p:prod) {
			if(name.equalsIgnoreCase(p.getComponyName())) {
				pr.add(p);
			}
		}
		return pr;
	}
	
	
	@GetMapping("/order-price")
	public List<product> orderByPrice(){
		List<product> productde=productRepo.orderByprice();
		return productde;
	}
	
	
	
	@GetMapping("/descorder-price")
	public List<product> descorderByPrice(){
		List<product> productde=productRepo.decorderByprice();
		return productde;
	}
	
	
	@GetMapping("/add-quantity/{id}/{addq}")
	public product addProduct(@PathVariable int id,@PathVariable int addq) {
		int qnt=0;
		
		product prd=productRepo.findById(id).get();
		productDeteles productDeteles=productDetelesRepo.findById(prd.getId()).get();
		qnt=prd.getQuantity();
		qnt=qnt+addq;
		productDeteles.setExpectedProfit(productDetelesService.expectedMarginCallectin(prd, productDeteles));
		productDeteles.setCorrentProfit( productDetelesService.currentProfitCollectin(productDeteles, 0));
		productDeteles.setGrosPrice(productDetelesService.expectGrossCollectin(prd, productDeteles));
		productRepo.save(prd);
		productDeteles.setExpectedProfit(productDetelesService.expectedMarginCallectin(prd, productDeteles));
		
		return prd;
	}
	
	
	@GetMapping("/sell-quantity/{id}/{addq}")
	public product sellProduct(@PathVariable int id,@PathVariable int addq) {
		int qnt=0;
		product prd=productRepo.findById(id).get();
		qnt=prd.getQuantity();
		if(qnt!=0) {
		qnt=qnt-addq;
		prd.setQuantity(qnt);
		productRepo.save(prd);
		productDeteles pd= productDetelesRepo.findById(prd.getId()).get();
		pd.setCorrentProfit(productDetelesService.currentProfitCollectin(pd, addq));
		pd.setCorrgrosPrice(productDetelesService.currentGrossCollectin(prd, pd, addq));
		
		prd.setQuantity(qnt);
		productDetelesRepo.save(pd);
		}
		return prd;
	}
	
	
	@GetMapping("/get-product")
	public List<product> getProduct(){
		List<product> prd=productRepo.findAll();
		return prd;
	}
	
	
	@GetMapping("/get-product-deteles")
	public List<productDeteles> getProductDeteles(){
		List<productDeteles> productde=productDetelesRepo.findAll();
		return productde;
	}
	
	@GetMapping("/get-By-Name/{name}")
	public List<productDeteles> getByProductName(){
		List<productDeteles> productde=productDetelesRepo.findAll();
		return productde;
	}
}
