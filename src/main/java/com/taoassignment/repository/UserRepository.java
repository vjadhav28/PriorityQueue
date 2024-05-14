package com.taoassignment.repository;


import com.taoassignment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findById(String status);
}
