package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.request.ViolationActionCreateRequest;
import com.UniCharity.UniCharity.dto.request.ViolationActionUpdateRequest;
import com.UniCharity.UniCharity.dto.response.ViolationActionResponse;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.mapper.ViolationActionMapper;
import com.UniCharity.UniCharity.models.PolicyViolation;
import com.UniCharity.UniCharity.models.ViolationAction;
import com.UniCharity.UniCharity.repositories.PolicyViolationRepository;
import com.UniCharity.UniCharity.repositories.ViolationActionRepository;
import com.UniCharity.UniCharity.services.iservices.IViolationActionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ViolationActionService implements IViolationActionService {
    ViolationActionRepository violationActionRepository;
    PolicyViolationRepository policyViolationRepository;
    ViolationActionMapper violationActionMapper;

    @Override
    public ViolationActionResponse createViolationAction(ViolationActionCreateRequest request) {
        PolicyViolation policyViolation = policyViolationRepository.findById(request.getViolation()).orElseThrow(() -> new AppException(ErrorCode.POLICY_VIOLATION_NOT_EXISTED));
        ViolationAction violationAction = violationActionMapper.toViolationAction(request);
        violationAction.setViolation(policyViolation);
        violationActionRepository.save(violationAction);
        return violationActionMapper.toViolationActionResponse(violationAction);
    }

    @Override
    public List<ViolationActionResponse> getViolationActions() {
        return violationActionRepository.findAll().stream().map(violationActionMapper::toViolationActionResponse).toList().reversed();
    }

    @Override
    public ViolationActionResponse getViolationAction(int violationActionId) {
        return violationActionMapper.toViolationActionResponse(violationActionRepository.findById(violationActionId).orElseThrow(() -> new AppException(ErrorCode.VIOLATION_ACTION_NOT_EXISTED)));
    }

    @Override
    public ViolationActionResponse updateViolationAction(int violationActionId, ViolationActionUpdateRequest request) {
        ViolationAction violationAction = violationActionRepository.findById(violationActionId).orElseThrow(() -> new AppException(ErrorCode.VIOLATION_ACTION_NOT_EXISTED));
        violationActionMapper.updateViolationAction(violationAction, request);
        violationActionRepository.save(violationAction);
        return violationActionMapper.toViolationActionResponse(violationAction);
    }
}
