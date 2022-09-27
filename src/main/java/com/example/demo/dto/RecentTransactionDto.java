package com.example.demo.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecentTransactionDto 
{
	
	 private int transactionId;
	  private String transactionType;
	  private String status;
	  private Date datetime;
	  private String modeOfPayment;
	  private String credits;
}
