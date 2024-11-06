package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.request.TransactionCreateRequest;
import com.UniCharity.UniCharity.dto.response.transaction.TransactionResponse;
import com.UniCharity.UniCharity.entities.Donation;
import com.UniCharity.UniCharity.entities.Transaction;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.mapper.TransactionMapper;
import com.UniCharity.UniCharity.repositories.DonationRepository;
import com.UniCharity.UniCharity.repositories.TransactionRepository;
import com.UniCharity.UniCharity.services.iservices.ITransactionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class TransactionService implements ITransactionService {
    DonationRepository donationRepository;
    TransactionRepository transactionRepository;
    
    @Override
    public TransactionResponse createTransaction(TransactionCreateRequest request) {
        Donation donation = donationRepository.findById(request.getDonation()).orElseThrow(() -> new AppException(ErrorCode.DONATION_NOT_EXISTED));
        Transaction transaction = TransactionMapper.toTransaction(request);
        transaction.setDonation(donation);
        transaction = transactionRepository.save(transaction);
        return TransactionMapper.toTransactionResponse(transaction);
    }

    @Override
    public TransactionResponse updateTransaction(int transactionId, HttpServletRequest request) {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(() -> new AppException(ErrorCode.TRANSACTION_NOT_EXISTED));

        String transactionCode = request.getParameter("vnp_TransactionNo");
        String paymentGateway = "VNPay";
        // xử lý thời gian
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime transactionDate;
        try {
            transactionDate = LocalDateTime.parse(request.getParameter("vnp_PayDate"), formatter);
        } catch (DateTimeParseException e) {
            throw new RuntimeException(e);
        }
        String transactionStatus = request.getParameter("vnp_TransactionStatus");
        Long amount = Long.valueOf(request.getParameter("vnp_Amount"));
        String responseCode = request.getParameter("vnp_ResponseCode");
        String transactionDescription = request.getParameter("vnp_OrderInfo");

        transaction.setTransactionCode(transactionCode);
        transaction.setPaymentGateway(paymentGateway);
        transaction.setTransactionDate(transactionDate);
        transaction.setTransactionStatus(transactionStatus);
        transaction.setAmount(amount);
        transaction.setResponseCode(responseCode);
        transaction.setTransactionDescription(transactionDescription);

        transaction = transactionRepository.save(transaction);

        return TransactionMapper.toTransactionResponse(transaction);
    }


}
