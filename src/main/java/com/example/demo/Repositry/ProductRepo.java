package com.example.demo.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.product;

@Repository
public interface ProductRepo extends JpaRepository<product, Integer> {
	List<product> findByName(String name);
	@Query("select u from product u order by u.Price")
	List<product> orderByprice();
	@Query("select u from product u order by u.Price desc")
	List<product> decorderByprice();
}
