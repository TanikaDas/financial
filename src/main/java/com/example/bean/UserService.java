package com.example.bean;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.BrokerRepo;
import com.example.entity.Details;
import com.example.exception.FinBrokerException;



@Service
public class UserService {

	@Autowired
	BrokerRepo brokerRepo;
	
	/** Broker Table Related Functions. Owned by Admin.*/
	
	
	public Details addBroker(String brokerId, String brokerName) throws FinBrokerException {
		try {
			return brokerRepo.save(new Details(brokerId, brokerName));
		} catch (DataIntegrityViolationException e) {
			throw new FinBrokerException("BrokerId '" + brokerId + "' already exists.");
		}
	}

	public List<Details> getAllBrokers() {
		return brokerRepo.findAll();
	}

	@Transactional
	public void deleteBroker(String brokerId) {
		brokerRepo.deleteByBrokerId(brokerId);
	}
}
