package com.example.bookreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookreview.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}