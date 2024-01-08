package com.codercampus.Assignment11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import com.codercampus.Assignment11.service.TransactionService;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

	@Mock
	private TransactionRepository transactionRepo;

	@InjectMocks
	private TransactionService transactionService;

	@BeforeEach
	void setUp() {

	}

	@Test
	void testFindAllTransactions() {
		Transaction transaction1 = new Transaction();
		Transaction transaction2 = new Transaction();
		when(transactionRepo.findAll()).thenReturn(Arrays.asList(transaction1, transaction2));

		List<Transaction> transactions = transactionService.findAllTransactions();

		assertNotNull(transactions);
		assertEquals(2, transactions.size());
		verify(transactionRepo, times(1)).findAll();
	}

	@Test
	void testFindTransactionById() {
		Transaction transaction = new Transaction();
		when(transactionRepo.findById(anyLong())).thenReturn(Optional.of(transaction));

		Transaction foundTransaction = transactionService.findTransactionById(1L);

		assertNotNull(foundTransaction);
		verify(transactionRepo, times(1)).findById(anyLong());
	}

	@Test
	void testFindTransactionById_NotFound() {
		when(transactionRepo.findById(anyLong())).thenReturn(Optional.empty());
		
		Transaction result = transactionService.findTransactionById(1L);
		
		assertNull(result);
		verify(transactionRepo, times(1)).findById(1L);
	}

}
