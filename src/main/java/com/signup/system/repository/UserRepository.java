package com.signup.system.repository;

import com.signup.system.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserInfo,Integer> {

    List<UserInfo> findByUserName(String name);

}