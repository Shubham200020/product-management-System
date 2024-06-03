package com.example.demo.Repositry;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>{

}
