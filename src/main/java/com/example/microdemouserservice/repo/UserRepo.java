package com.example.microdemouserservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microdemouserservice.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
