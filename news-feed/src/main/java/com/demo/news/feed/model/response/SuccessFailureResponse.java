package com.demo.news.feed.model.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class SuccessFailureResponse implements IResponse{

    private boolean status;
    private Object message;
    private HttpStatus httpCode;
}
