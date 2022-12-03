package com.webproject.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
@Table(name = "Product")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int _id;
	
	@Column(nullable = false)
	@Size(max = 1000)
	private String name;
	
	@Column(unique = true)
	private String slug;
	
	@Column(nullable = false)
	@Size(max = 1000)
	private String description;
	
	@Column(nullable = false)
	@Min(value = 0)
	private double price;
	
	@Column(nullable = false)
	@Min(value = 0)
	private double promotionalPrice;
	
	@Column(nullable = false)
	@Min(value = 0)
	private int quantity;
	
	@Column(columnDefinition = "int default 0")
	@Min(value = 0)
	private int sold;
	
	@Column(columnDefinition = "boolean default true")
	private Boolean isActive;
	
	@Column(columnDefinition = "boolean default true")
	private Boolean isSelling;
	
	private List<String> listImages;
	
	@ManyToOne
	@JoinColumn(name = "_id")
	@Column(nullable = false)
	private Category categoryId;
	
	@OneToMany(mappedBy = "_id")
	private Set<StyleValue> styleValueIds;
	
	@ManyToOne
	@JoinColumn(name = "_id")
	@Column(nullable = false)
	private Store storeId;
	
	@Column(columnDefinition = "int default 3")
	@Min(value = 0)
	@Max(value = 5)
	private int rating;
	
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
