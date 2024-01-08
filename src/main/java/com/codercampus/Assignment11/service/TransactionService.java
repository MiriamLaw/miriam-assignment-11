package com.codercampus.Assignment11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {

	private final TransactionRepository transactionRepo;

	@Autowired
	public TransactionService(TransactionRepository transactionRepo) {
		this.transactionRepo = transactionRepo;

	}

	public List<Transaction> findAllTransactions() {

		return transactionRepo.findAll();
	}

	public Transaction findTransactionById(Long transactionId) {
		return transactionRepo.findById(transactionId).orElse(null);
	}
}
