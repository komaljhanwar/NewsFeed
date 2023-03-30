package com.demo.news.feed.service.interfaces;

import com.demo.news.feed.model.request.PostDetails;
import com.demo.news.feed.model.response.IResponse;
import com.demo.news.feed.model.response.SuccessFailureResponse;

public interface IUserService {

    SuccessFailureResponse createPost(PostDetails post);


}
