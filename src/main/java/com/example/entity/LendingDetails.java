package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "lendingdetails")
public class LendingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recordid")
	private long recordId;

	@Column(name = "lender_id", nullable = false, insertable = false, updatable = false)
	private String lenderId;
	@ManyToOne
	@JoinColumn(name = "lender_id", referencedColumnName = "userId", foreignKey = @ForeignKey(name = "lender_fkey"))
	private UserDetails lender;
	
	@Column(name = "borrower_id", nullable = false, insertable = false, updatable = false)
	private String borrowerId;
	@ManyToOne
	@JoinColumn(name = "borrower_id", referencedColumnName = "userId", foreignKey = @ForeignKey(name = "borrower_fkey"))
	private UserDetails borrower;

	@Column(name = "broker_id", nullable = false, insertable = false, updatable = false)
	private String brokerId;
	@ManyToOne
	@JoinColumn(name = "broker_id", referencedColumnName = "brokerId", foreignKey = @ForeignKey(name = "broker_fkey"))
	private Details broker;

	@Column(name = "rate", nullable = false,precision = 2)
	private double rate;

	@Column(name = "amount", nullable = false)
	private long amount;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", nullable = false)
	private Date endDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "booking_date", nullable = false)
	private Date bookingDate;

	@Column(name = "duration", nullable = false)
	private long durationInDays;

	@Column(name = "final_amount", nullable = false,precision = 2)
	private double finalAmount;

	public long getRecordId() {
		return recordId;
	}

	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}

	public Details getBroker() {
		return broker;
	}

	public void setBroker(Details broker) {
		this.broker = broker;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getDurationInDays() {
		return durationInDays;
	}

	public void setDurationInDays(long durationInDays) {
		this.durationInDays = durationInDays;
	}

	public UserDetails getLender() {
		return lender;
	}

	public void setLender(UserDetails lender) {
		this.lender = lender;
	}

	public UserDetails getBorrower() {
		return borrower;
	}

	public void setBorrower(UserDetails borrower) {
		this.borrower = borrower;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}
}
