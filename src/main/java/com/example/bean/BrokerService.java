package com.example.bean;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.dao.BrokerRepo;
import com.example.dao.LendingRepo;
import com.example.dao.UserRepo;
import com.example.entity.DealSummery;
import com.example.entity.Details;
import com.example.entity.LendingDetails;
import com.example.entity.UserDetails;
import com.example.entity.UserIdAndName;
import com.example.exception.FinBrokerException;
@Service
public class BrokerService {

	@Autowired
	BrokerRepo brokerRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	LendingRepo lendingRepo;
	
	/**Those services those are owned by Broker.*/

	public void preAuthenticate() {
		PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken("sampat", "",
				null);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	

	/**
	 * User Table Related Functions.
	 * 
	 * @throws FinBrokerException
	 */
	public UserDetails addUser(String userId, String userName) throws FinBrokerException {
		preAuthenticate();
		String brokerId = SecurityContextHolder.getContext().getAuthentication().getName();
		Details broker = brokerRepo.findByBrokerId(brokerId);
		System.out.println("brokerid : " + brokerId);
		if (broker == null)
			throw new FinBrokerException("The broker " + brokerId + " is not found.");

		UserDetails user = new UserDetails();
		user.setBroker(broker);
		user.setUserName(userName);
		user.setUserId(userId);
		return userRepo.save(user);

	}

	public List<UserIdAndName> showUsers() throws FinBrokerException {
		preAuthenticate();
		String brokerId = SecurityContextHolder.getContext().getAuthentication().getName();
		if (brokerId == null) {
			throw new FinBrokerException("Broker Id not found. Bad SecurityContext.");
		}
		return userRepo.findByBrokerId(brokerId);
	}

	/**
	 * Lending Table Related Functions.
	 * 
	 * @throws FinBrokerException
	 */
	public LendingDetails addDeal(String borrowerId, String lenderId, double rate, long amount, Date startDate,
			Date endDate) throws FinBrokerException {
		preAuthenticate();
		String brokerId = SecurityContextHolder.getContext().getAuthentication().getName();
		Details broker = brokerRepo.findByBrokerId(brokerId);
		LendingDetails deal = new LendingDetails();
		if (lenderId.equals(borrowerId))
			throw new FinBrokerException("Both lender and borrower are set as " + lenderId);
		UserDetails lender = userRepo.findByUserId(lenderId).get(0);
		UserDetails borrower = userRepo.findByUserId(borrowerId).get(0);
		deal.setAmount(amount);
		deal.setBookingDate(new Date());
		deal.setBorrower(borrower);
		deal.setBroker(broker);
		deal.setLender(lender);
		deal.setRate(rate);
		deal.setStartDate(startDate);
		deal.setEndDate(endDate);
		long durationInDays = TimeUnit.DAYS.convert(endDate.getTime()-startDate.getTime(), TimeUnit.MILLISECONDS);
		deal.setDurationInDays(durationInDays);
		deal.setFinalAmount(amount*(1+rate/100 * (durationInDays/365.0)));
		return lendingRepo.save(deal);
	}

	public List<DealSummery> getSummaryForBroker() {
		preAuthenticate();
		String brokerId = SecurityContextHolder.getContext().getAuthentication().getName();
		return lendingRepo.findByBrokerId(brokerId);
	}
}
