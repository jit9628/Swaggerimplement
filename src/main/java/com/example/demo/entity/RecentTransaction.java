package com.example.demo.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="rctable")
public class RecentTransaction 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int transactionId;
  private String transactionType;
  private String status;
  @Temporal(TemporalType.TIMESTAMP)
  private Date datetime;
  private String modeOfPayment;
  private String credits;
  
	
	
	
}
