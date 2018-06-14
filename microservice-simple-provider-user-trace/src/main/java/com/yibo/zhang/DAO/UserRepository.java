package com.yibo.zhang.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<com.yibo.zhang.Model.User,Integer>{
	
}
