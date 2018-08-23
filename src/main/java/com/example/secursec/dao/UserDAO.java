package com.example.secursec.dao;

import com.example.secursec.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

   Optional<User> findUserByUsername(String username);
}
