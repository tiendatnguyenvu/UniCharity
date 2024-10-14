package com.UniCharity.UniCharity.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(9998, "Invalid message key", HttpStatus.BAD_REQUEST),
    // Campaign
    CAMPAIGN_NOT_EXISTED(1051, "Campaign not existed", HttpStatus.NOT_FOUND),
    // CampaignReport
    CAMPAIGN_REPORT_NOT_EXISTED(2001, "Campaign reposrt not existed", HttpStatus.NOT_FOUND),
    // Donation
    DONATION_NOT_EXISTED(5001, "Donation not existed", HttpStatus.NOT_FOUND),
    // FundAllocation
    FUND_ALLOCATION_NOT_EXISTED(2051, "Fund allocation not existed", HttpStatus.NOT_FOUND),
    // Image
    IMAGE_NOT_EXISTED(3001, "Image not existed", HttpStatus.NOT_FOUND),
    // Policy
    POLICY_NOT_EXISTED(3051, "Policy not existed", HttpStatus.NOT_FOUND),
    // PolicyViolation
    POLICY_VIOLATION_NOT_EXISTED(4001, "Policy violation not existed", HttpStatus.NOT_FOUND),
    // Transaction
    TRANSACTION_NOT_EXISTED(4051, "Transcation not existed", HttpStatus.NOT_FOUND),
    // User
    USER_NOT_EXISTED(1001, "User not existed", HttpStatus.NOT_FOUND),
    EMPTY_USER_LIST(1002, "User list is empty.", HttpStatus.NO_CONTENT),
    FACULTY_NOT_EXISTED(1003, "Faculty not existed", HttpStatus.NOT_FOUND),
    STUDENT_NOT_EXISTED(1004, "Student not existed", HttpStatus.NOT_FOUND),
    // ViolationAction
    VIOLATION_ACTION(4051, "Violation action not existed", HttpStatus.NOT_FOUND),
    ;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    int code;
    String message;
    HttpStatusCode statusCode;
}
