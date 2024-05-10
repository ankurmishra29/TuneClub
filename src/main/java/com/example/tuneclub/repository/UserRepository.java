package com.example.tuneclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.example.tuneclub.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

     public User findByEmail(String email);

}
