package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.TransactionCreateRequest;
import com.UniCharity.UniCharity.dto.request.TransactionUpdateRequest;
import com.UniCharity.UniCharity.dto.response.TransactionResponse;
import com.UniCharity.UniCharity.entities.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = DonationMapper.class)
public interface TransactionMapper {
    @Mapping(target = "donation", ignore = true)
    Transaction toTransaction(TransactionCreateRequest request);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "donation", target = "donation")
    TransactionResponse toTransactionResponse(Transaction transaction);

    void updateTransaction(@MappingTarget Transaction transaction, TransactionUpdateRequest request);
}
