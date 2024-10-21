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
    CAMPAIGN_TITLE_IS_REQUIRED(1052, "Campaign title is required", HttpStatus.BAD_REQUEST),
    CAMPAIGN_TITLE_TOO_LONG(1053, "Campaign title must not exceed 100 characters", HttpStatus.BAD_REQUEST),
    DESCRIPTION_IS_REQUIRED(1054, "Description is required", HttpStatus.BAD_REQUEST),
    DESCRIPTION_TOO_LONG(1055, "Description must not exceed 1000 characters", HttpStatus.BAD_REQUEST),
    TARGET_AMOUNT_MUST_BE_POSITIVE(1021, "Target amount must be greater than 0", HttpStatus.BAD_REQUEST),
    CURRENT_AMOUNT_MUST_BE_NON_NEGATIVE(1022, "Current amount must be non-negative", HttpStatus.BAD_REQUEST),
    CREATED_DATE_MUST_BE_PAST_OR_PRESENT(1023, "Created date must be in the past or present", HttpStatus.BAD_REQUEST),
    START_DATE_MUST_BE_FUTURE_OR_PRESENT(1024, "Start date must be in the future or present", HttpStatus.BAD_REQUEST),
    END_DATE_MUST_BE_IN_FUTURE(1025, "End date must be in the future", HttpStatus.BAD_REQUEST),
    STATUS_CANNOT_BE_BLANK(1027, "Status cannot be blank", HttpStatus.BAD_REQUEST),
    INVALID_STATUS_VALUE(1028, "Status must be one of: active, inactive, completed, cancelled", HttpStatus.BAD_REQUEST),

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
    STUDENT_NOT_EXISTED(1002, "Student not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1003, "Unauthenticated", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1004, "User existed", HttpStatus.BAD_REQUEST),
    EMAIL_ALREADY_EXISTS(1005, "Email already exists", HttpStatus.BAD_REQUEST),
    USERNAME_ALREADY_EXISTS(1006, "Username already exists", HttpStatus.BAD_REQUEST),
    INVALID_EMAIL(1007, "Invalid email address", HttpStatus.BAD_REQUEST),
    EMAIL_IS_REQUIRED(1008, "Email is required", HttpStatus.BAD_REQUEST),
    PASSWORD_IS_REQUIRED(1009, "Password is required", HttpStatus.BAD_REQUEST),
    PASSWORD_TOO_SHORT(1010, "Password must be at least 8 characters", HttpStatus.BAD_REQUEST),
    PASSWORD_MUST_CONTAIN_UPPERCASE(1011, "Password must contain at least one uppercase letter", HttpStatus.BAD_REQUEST),
    PASSWORD_MUST_CONTAIN_LOWERCASE(1012, "Password must contain at least one lowercase letter", HttpStatus.BAD_REQUEST),
    PASSWORD_MUST_CONTAIN_NUMBER(1013, "Password must contain at least one number", HttpStatus.BAD_REQUEST),
    PASSWORD_MUST_CONTAIN_SPECIAL_CHARACTER(1014, "Password must contain at least one special character", HttpStatus.BAD_REQUEST),
    CREATOR_ID_MUST_BE_POSITIVE(1026, "ID người tạo phải là số dương", HttpStatus.BAD_REQUEST),
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
