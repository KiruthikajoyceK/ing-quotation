package com.hcl.quotation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Quotation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private int stockId;
	private double stockPrice;
	private int quantity;
	private double totalPrice;

}
