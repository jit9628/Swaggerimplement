package com.example.demo.serviceimpl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RecentTransactionDto;
import com.example.demo.entity.RecentTransaction;
import com.example.demo.repository.RecentTransactonRepository;
import com.example.demo.service.RecentTransactionService;


@Service
public class RecentTransactionImpl implements RecentTransactionService {
	@Autowired
	private RecentTransactonRepository recentTransactonRepository;

	@Override
	public String deletetransacion(int transactionId) {
		this.recentTransactonRepository.delete(recentTransactonRepository.findById(transactionId).get());
		return "delete successfull";
	}

	@Override
	public String updateTransaction(int transactionId, RecentTransactionDto recentTransactionDto) {
		// RecentTransactionDto dto1=new RecentTransactionDto();
		RecentTransaction dto = this.recentTransactonRepository.findById(transactionId).get();
		// RecentTransaction recentTransaction=new RecentTransaction();
		if (dto != null)
			// dto.setTransactionId(recentTransactionDto.getTransactionId());
			dto.setCredits(recentTransactionDto.getCredits());
		dto.setDatetime(recentTransactionDto.getDatetime());
		dto.setModeOfPayment(recentTransactionDto.getModeOfPayment());
		dto.setStatus(recentTransactionDto.getStatus());
		dto.setTransactionType(recentTransactionDto.getTransactionType());
		recentTransactonRepository.save(dto);
		return "Update successful";
	}

	@Override
	public List<RecentTransactionDto> getAllTransaction() {
		RecentTransactionDto dto = new RecentTransactionDto();
		ArrayList<RecentTransactionDto> arrayList = new ArrayList<RecentTransactionDto>();
		List<RecentTransaction> list = this.recentTransactonRepository.findAll();
		for (RecentTransaction recentTransaction : list) {
			dto.setCredits(recentTransaction.getCredits());
			dto.setDatetime(recentTransaction.getDatetime());
			dto.setModeOfPayment(recentTransaction.getModeOfPayment());
			dto.setStatus(recentTransaction.getStatus());
			dto.setTransactionId(recentTransaction.getTransactionId());
			dto.setTransactionType(recentTransaction.getTransactionType());
			arrayList.add(dto);

		}
		return arrayList;

	}

	@Override
	public RecentTransactionDto findbyId(int transactionId) {
		RecentTransaction recentTransaction = this.recentTransactonRepository.findById(transactionId).get();
		RecentTransactionDto dto = new RecentTransactionDto();
		if (dto != null) {
			dto.setCredits(recentTransaction.getCredits());
			dto.setDatetime(recentTransaction.getDatetime());
			dto.setModeOfPayment(recentTransaction.getModeOfPayment());
			dto.setStatus(recentTransaction.getStatus());
			dto.setTransactionId(recentTransaction.getTransactionId());
			dto.setTransactionType(recentTransaction.getTransactionType());
		}
		return dto;

	}

	@Override
	public RecentTransactionDto createatran(RecentTransactionDto recentTransactionDto) {
		RecentTransactionDto recentTransactionDto1=new RecentTransactionDto();
		RecentTransaction recentTransaction = new RecentTransaction();
		if (recentTransaction != null) {
			recentTransaction.setCredits(recentTransactionDto.getCredits());
			recentTransaction.setDatetime(new Date());
			recentTransaction.setModeOfPayment(recentTransactionDto.getModeOfPayment());
			recentTransaction.setStatus(recentTransactionDto.getStatus());
			recentTransaction.setTransactionId(recentTransactionDto.getTransactionId());
			recentTransaction.setTransactionType(recentTransactionDto.getTransactionType());
		}
		RecentTransaction savetransaction=this.recentTransactonRepository.save(recentTransaction);
		if (savetransaction != null) {
			recentTransactionDto1.setCredits(savetransaction.getCredits());
			recentTransactionDto1.setDatetime(savetransaction.getDatetime());
			recentTransactionDto1.setModeOfPayment(savetransaction.getModeOfPayment());
			recentTransactionDto1.setStatus(savetransaction.getStatus());
			recentTransactionDto1.setTransactionId(savetransaction.getTransactionId());
			recentTransactionDto1.setTransactionType(savetransaction.getTransactionType());
		}
	return recentTransactionDto1;
	}

//	@Override
//	public RecentTransactionDto createatranwithname(RecentTransactionDto recentTransactionDto) {
//		RecentTransaction  recentTransaction=new RecentTransaction();
//		RecentTransactionDto dto=new RecentTransactionDto();
//		 if(dto !=null)
//		   {
//				dto.setCredits(recentTransaction.getCredits());
//				dto.setDatetime(recentTransaction.getDatetime());
//				dto.setModeOfPayment(recentTransaction.getModeOfPayment());
//				dto.setStatus(recentTransaction.getStatus());
//				dto.setTransactionId(recentTransaction.getTransactionId());
//				dto.setTransactionType(recentTransaction.getTransactionType());
//		   }
//		 this.recentTransactonRepository.save(recentTransaction);
//		return dto;
//	}

}
