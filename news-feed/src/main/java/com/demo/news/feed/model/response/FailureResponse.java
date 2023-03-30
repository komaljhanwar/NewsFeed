package com.demo.news.feed.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FailureResponse implements IResponse{

    private boolean status;

    private String message;

}
