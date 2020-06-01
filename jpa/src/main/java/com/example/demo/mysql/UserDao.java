package com.example.demo.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 作者：编程小石头
 */
public interface UserDao extends JpaRepository<User,Integer> {
}
