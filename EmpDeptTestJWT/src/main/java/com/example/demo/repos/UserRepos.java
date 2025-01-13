package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepos extends JpaRepository<User, Integer>{

	public User findByUsername(String username);

	
}
