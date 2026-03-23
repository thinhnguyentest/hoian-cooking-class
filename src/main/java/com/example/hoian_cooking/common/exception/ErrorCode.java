package com.example.hoian_cooking.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    INTERNAL_SERVER_ERROR("ERR-500", "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR),
    NOT_FOUND("ERR-404", "Resource Not Found", HttpStatus.NOT_FOUND),
    BAD_REQUEST("ERR-400", "Bad Request", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED("ERR-401", "Unauthorized Access", HttpStatus.UNAUTHORIZED),
    FORBIDDEN("ERR-403", "Access Denied", HttpStatus.FORBIDDEN);

    private final String code;
    private final String message;
    private final HttpStatus status;

    ErrorCode(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
