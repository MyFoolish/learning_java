package com.xwcoding.dao;

import com.xwcoding.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liuxiaowei
 * @description
 * @date 2020/10/21 17:30
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
