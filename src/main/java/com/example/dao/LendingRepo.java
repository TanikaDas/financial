package com.example.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.DealSummery;
import com.example.entity.LendingDetails;

@Repository
public interface LendingRepo extends CrudRepository<LendingDetails, Long> {
	List<DealSummery> findByBrokerId(String brokerId);

}
