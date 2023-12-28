package com.codercampus.Assignment11.web;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Controller
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@GetMapping("/transactions")
	public String viewAllTransactions(Model model) {
		List<Transaction> transactions = transactionRepository.findAll();
		
		transactions.sort(Comparator.comparing(Transaction::getDate));
		
		model.addAttribute("transactions", transactions);
		return "transactions";
	}

}
