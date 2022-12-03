package com.webproject.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class Review implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int _id;
	
	@OneToMany(mappedBy = "_id")
	private List<User> userId;
	@OneToMany(mappedBy = "_id")
	private List<Product> productId;
	@OneToMany(mappedBy = "_id")
	private List<Store> storeId;
	//
	@OneToMany(mappedBy = "_id")
	private Order orderId;
	private String content;
	private int stars;
	private Date createdAt;
	private Date updatedAt;

	@PrePersist
	void createdAt() {
		this.createdAt = this.updatedAt = new Date();
	}

	@PreUpdate
	void updatedAt() {
		this.updatedAt = new Date();
	}
}
