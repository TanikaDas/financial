package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.UserDetails;
import com.example.entity.UserIdAndName;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Long> {
	List<UserIdAndName> findByBrokerId(String brokerId);
	List<UserDetails> findByUserId(String userId);

}
