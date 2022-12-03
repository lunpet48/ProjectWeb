package com.webproject.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "User")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int _id;

	@Size(max = 32)
	@NotNull
	private String firstName;

	@Size(max = 32)
	@NotNull
	private String lastName;

	private String slug;

	@Column(unique = true)
	private String idCard;

	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String phone;

	@Column(columnDefinition = "boolean default false")
	private Boolean isEmailActive;

	@Column(columnDefinition = "boolean default false")
	private Boolean isPhoneActive;

	private String salt;

	@NotNull
	private String hashedPassword;

	@Column(columnDefinition = "varchar(200) default 'User'")
	private String role;

	private List<String> addresses;
	private String avatar;
	private String cover;
	private int point;
	private double eWallet;
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
