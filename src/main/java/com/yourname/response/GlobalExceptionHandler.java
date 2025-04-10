
package com.yourname.response;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ApiResponse<Object> handleApiException(ApiException ex) {
        return ApiResponse.error(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> handleUnexpected(Exception ex) {
        return ApiResponse.error("INTERNAL_ERROR", "Đã xảy ra lỗi không xác định");
    }
}
