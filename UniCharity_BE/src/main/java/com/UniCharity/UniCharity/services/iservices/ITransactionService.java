package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.TransactionCreateRequest;
import com.UniCharity.UniCharity.dto.request.TransactionUpdateRequest;
import com.UniCharity.UniCharity.dto.response.TransactionResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface ITransactionService {
    public TransactionResponse createTransaction(TransactionCreateRequest request);
    public TransactionResponse updateTransaction(int transactionId, HttpServletRequest request);
}
