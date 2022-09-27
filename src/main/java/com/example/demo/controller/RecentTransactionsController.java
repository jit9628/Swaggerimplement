package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RecentTransactionDto;
import com.example.demo.response.ApiResponse;
import com.example.demo.serviceimpl.RecentTransactionImpl;

@RestController
public class RecentTransactionsController {
	@Autowired
	private RecentTransactionImpl impl;

	@PostMapping("/savedata")
	public ResponseEntity<?> savetransaction(@RequestBody RecentTransactionDto transactionDto) {
		try {
			RecentTransactionDto create = this.impl.createatran(transactionDto);
			if (create != null)
				return ResponseEntity.ok(new ApiResponse("Transaction created", "sucessfull", true, 201,Arrays.asList(create)));
			else
				return ResponseEntity.ok(new ApiResponse("Transaction not created", "failed", false, 400,Arrays.asList()));
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal Server Error", "Bad Request", false, 502,Arrays.asList()));
		}
	}

	@DeleteMapping("/delid/{transactionId}")
	public ResponseEntity<?> deletetransaction(@PathVariable("transactionId") int transactionId) {
		try {
			String del = this.impl.deletetransacion(transactionId);
			if (del != null)
				return ResponseEntity.ok(new ApiResponse("Transaction deleted", "sucessfull", true, 202));
			else
				return ResponseEntity.ok(new ApiResponse("Transaction not deleted", "failed", false, 400));
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal Server Error", "Bad Request", false, 502));
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAlltransaction() {
		try {
			List<RecentTransactionDto> dtos = this.impl.getAllTransaction();
			if (dtos != null && dtos.size() > 0)
				return ResponseEntity.ok(new ApiResponse(" show AllTransaction", "sucessfull", true, 203, dtos));
			else
				return ResponseEntity.ok(new ApiResponse("Transaction not show", "failed", false, 400, dtos));
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal Server Error", "Bad Request", false, 502));
		}
	}

	@PutMapping("/updatetran/{transactionId}")
	public ResponseEntity<?> updatetransaction(@RequestBody RecentTransactionDto transactionDto,
			@PathVariable("transactionId") int transactionId) {
		try {
			String isUpdate = this.impl.updateTransaction(transactionId, transactionDto);
			if (isUpdate != null)
				return ResponseEntity.ok(new ApiResponse(" updated  AllTransaction", "sucessfull", true, 204));
			else
				return ResponseEntity.ok(new ApiResponse("Transaction not updated", "failed", false, 400));
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal Server Error", "Bad Request", false, 502));
		}
	}

	@GetMapping("/leleidse/{transactionId}")
	public ResponseEntity<?> gettransactionbyid(@PathVariable("transactionId") int transactionId) {
//		try
//		{
		RecentTransactionDto isfind = this.impl.findbyId(transactionId);
		return ResponseEntity.ok(isfind);
//			if(isfind != null)
//				return ResponseEntity.ok(new ApiResponse(" updated  AllTransaction", "sucessfull", true,204));
//			else
//				return ResponseEntity.ok(new ApiResponse("Transaction not updated", "failed", false,400));
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}
	}

//	
//	@PostMapping("/savedatabucla")
//	public ResponseEntity<?> savetransaction2(@RequestBody RecentTransactionDto transactionDto) {
//		try {
//			RecentTransactionDto create = this.impl.createatran(transactionDto);
//			if (create != null)
//				return ResponseEntity.ok(new ApiResponse("Transaction created", "sucessfull", true, 201));
//			else
//				return ResponseEntity.ok(new ApiResponse("Transaction not created", "failed", false, 400));
//		} catch (Exception e) {
//			return ResponseEntity.ok(new ApiResponse("Internal Server Error", "Bad Request", false, 502));
//		}
//	}
//	
	
	
}
