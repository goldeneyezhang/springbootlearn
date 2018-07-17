package com.yibo.simple_provider_user_trace.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yibo.simple_provider_user_trace.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
}
