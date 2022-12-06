package com.webproject.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
@Table(name = "OrderItem")
public class OrderItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	
	@ManyToOne
	@JoinColumn(name = "orderId", referencedColumnName = "_id")
	@NotNull
	private Order orderId;
	
	@OneToOne
	@JoinColumn(name = "productId", referencedColumnName = "_id")
	@NotNull
	private Product productId;
	
	@OneToMany(mappedBy = "_id")
	@NotNull
	private List<StyleValue> styleValueIds;
	
	@Column(nullable = false)
	@Min(value = 1)
	private int count;
	
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
