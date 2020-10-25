package com.lyahov.stepa.MyTodoIstBack.business.dao;

import com.lyahov.stepa.MyTodoIstBack.business.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
