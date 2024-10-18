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
    STUDENT_NOT_EXISTED(1004, "Student not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1005, "Unauthenticated", HttpStatus.BAD_REQUEST),
    // ViolationAction
    VIOLATION_ACTION_NOT_EXISTED(4051, "Violation action not existed", HttpStatus.NOT_FOUND),
    // Image
    IMAGE_UPLOAD_FAILED(5001, "Image upload failed", HttpStatus.INTERNAL_SERVER_ERROR),
    FILE_TYPE_NOT_SUPPORTED(5002, "File type is not supported", HttpStatus.UNSUPPORTED_MEDIA_TYPE),
    EMPTY_FILE(5002, "File is empty", HttpStatus.BAD_REQUEST),
    IMAGE_PROCESSING_ERROR(5003, "Error occurred during image processing", HttpStatus.INTERNAL_SERVER_ERROR),
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
