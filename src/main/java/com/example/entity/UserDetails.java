package com.example.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "userdetails")
public class UserDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -699562492372769479L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "userId", nullable = false, unique = true)
	private String userId;

	@Column(name = "userName", nullable = false)
	private String userName;

	@Column(name = "brokerId", nullable = false, insertable = false, updatable = false)
	private String brokerId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "brokerId", referencedColumnName = "brokerId", foreignKey = @ForeignKey(name = "user-brokerid-fkey"))
	private Details broker;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "borrower")
	private List<LendingDetails> dealsAsBorrower;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "lender")
	private List<LendingDetails> dealsAsLender;

	public UserDetails() {
	}

	public Details getBroker() {
		return broker;
	}

	public void setBroker(Details broker) {
		this.broker = broker;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId;
	}

}
