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
    // các lỗi của User
    USER_NOT_EXISTED(1001, "User not existed", HttpStatus.NOT_FOUND),
    EMPTY_USER_LIST(1002, "User list is empty.", HttpStatus.NO_CONTENT),
    FACULTY_NOT_EXISTED(1003, "Faculty not existed", HttpStatus.NOT_FOUND),
    STUDENT_NOT_EXISTED(1004, "Student not existed", HttpStatus.NOT_FOUND),
    // các lỗi của Department
    DEPARTMENT_NOT_EXISTED(1051, "Department not existed", HttpStatus.NOT_FOUND),
    // các lỗi của Campaign
    CAMPAIGN_NOT_EXISTED(2001, "Campaign not existed", HttpStatus.NOT_FOUND),
    // các lỗi của FacultyRequest
    FACULTYREQUEST_NOT_EXISTED(2051, "Faculty request not existed", HttpStatus.NOT_FOUND),
    // các lỗi của Scholarship
    SCHOLARSHIP_NOT_EXISTED(3001, "Scholarship not existed", HttpStatus.NOT_FOUND),
    SCHOLARSHIP_CLOSED(3002, "The scholarship is already closed", HttpStatus.BAD_REQUEST),
    // các lỗi của StudentApplication
    STUDENTAPPLICATION_NOT_EXISTED(3051, "Student application not existed", HttpStatus.NOT_FOUND),
    STUDENTAPPLICATION_DELETE_FAILED(3052, "Failed to delete student application", HttpStatus.BAD_REQUEST),
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
