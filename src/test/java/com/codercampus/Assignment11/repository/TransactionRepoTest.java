package com.codercampus.Assignment11.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codercampus.Assignment11.domain.Transaction;

public class TransactionRepoTest {

	private TransactionRepository transactionRepo;
	private Transaction transaction1;
	private Transaction transaction2;

	@BeforeEach
	void setUp() {

		transactionRepo = new TransactionRepository();
		transactionRepo.clearTransactionsForTest();

		transaction1 = new Transaction();
		transaction1.setId(1L);
		transaction2 = new Transaction();
		transaction2.setId(2L);
		transactionRepo.addTransactionForTest(transaction1);
		transactionRepo.addTransactionForTest(transaction2);

	}

	@Test
	void testFindAll() {
		List<Transaction> transactions = transactionRepo.findAll();

		assertNotNull(transactions);
		assertEquals(2, transactions.size());
		assertTrue(transactions.containsAll(List.of(transaction1, transaction2)));
	}

	@Test
	void testFindbyId_ExistingId() {
		Optional<Transaction> transaction = transactionRepo.findById(1L);

		assertTrue(transaction.isPresent());
		assertEquals(1L, transaction.get().getId());

	}

	@Test
	void testFindById_NonExistingId() {
		Optional<Transaction> transaction = transactionRepo.findById(3L);

		assertFalse(transaction.isPresent());
	}

}
