package com.demo.news.feed.enums;

import com.demo.news.feed.model.response.ErrorResponse;
import lombok.Getter;

@Getter
public enum ErrorCode {

    INTERNAL_SERVER_ERROR("ER_500", "Something went wrong");


    private String message;

    private String code;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
