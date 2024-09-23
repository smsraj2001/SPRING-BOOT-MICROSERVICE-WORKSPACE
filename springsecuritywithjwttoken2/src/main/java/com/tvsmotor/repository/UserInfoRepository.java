package com.tvsmotor.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvsmotor.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
//	 Optional<UserInfo> findByName(String name); // Use 'name' if that is the correct field for login
}
