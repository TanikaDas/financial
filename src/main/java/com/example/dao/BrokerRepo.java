package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Details;

@Repository
public interface BrokerRepo extends JpaRepository<Details, Long>{
	Details findByBrokerId(String brokerId);
	long deleteByBrokerId(String brokerId);

}
