package com.webproject.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
@Table(name = "Stores")
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;

	@Column(unique = true, nullable = false)
	@Size(max = 100)
	private String name;

	@Column(nullable = false)
	@Size(max = 1000)
	private String bio;

	@Column(unique = true)
	private String slug;

	@OneToOne
	@JoinColumn(name = "ownerId", referencedColumnName = "_id")
	@NotNull
	private User ownerId;

	@OneToMany(mappedBy = "_id")
	private List<User> staffIds;

	//@Column(columnDefinition = "boolean default false")
	private Boolean isActive;

	//@Column(columnDefinition = "boolean default false")
	private Boolean isOpen;

	private String avatar;
	private String cover;
	private String[] featuredImages;

	@OneToOne
	@JoinColumn(name = "commissionId", referencedColumnName = "_id")
	private Commission commissionId;
	private int point;

	//@Column(columnDefinition = "int default 3")
	@Max(value = 5)
	@Min(value = 0)
	private int[] rating;

	//@Column(columnDefinition = "double default 0")
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
