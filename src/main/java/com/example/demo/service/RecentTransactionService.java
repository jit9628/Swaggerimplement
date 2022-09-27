package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RecentTransactionDto;


public interface RecentTransactionService 
{
   public RecentTransactionDto createatran(RecentTransactionDto recentTransactionDto);
   //public RecentTransactionDto createatranwithname(RecentTransactionDto recentTransactionDto);
   public String deletetransacion(int transactionId);
   public String updateTransaction(int transactionId,RecentTransactionDto recentTransactionDto);
   public List<RecentTransactionDto> getAllTransaction();
   public RecentTransactionDto findbyId(int transactionId);
}
