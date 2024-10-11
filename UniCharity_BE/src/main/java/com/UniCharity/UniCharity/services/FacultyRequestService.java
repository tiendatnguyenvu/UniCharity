package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.models.FacultyRequest;
import com.UniCharity.UniCharity.repositories.FacultyRequestRepository;
import com.UniCharity.UniCharity.services.iservices.IFacultyRequestService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class FacultyRequestService implements IFacultyRequestService {
    FacultyRequestRepository facultyRequestRepository;
}
