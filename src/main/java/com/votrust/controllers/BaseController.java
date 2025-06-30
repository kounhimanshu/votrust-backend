package com.votrust.controllers;


import com.votrust.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaseController {

    public ApiResponse doSuccessResponse(Object object, String message) {
        ApiResponse response = new ApiResponse();
        response.setStatus(HttpStatus.OK);
        response.setData(object);
        response.setMessage(message);
        response.setNotify(true);
        return response;
    }

    public ApiResponse doSuccessResponse(Object object) {
        ApiResponse response = doSuccessResponse(object, null);
        response.setNotify(false);
        return response;
    }

    public ApiResponse doErrorResponse(String message) {
        ApiResponse response = new ApiResponse();
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setMessage(message);
        response.setNotify(true);
        response.setHasError(true);
        return response;
    }

    public ApiResponse doSuccessResponse(String message) {
        ApiResponse response = doSuccessResponse(null, message);
        response.setNotify(true);
        return response;
    }

    public ApiResponse doErrorResponse(List<String> errors) {
        ApiResponse response = new ApiResponse();
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setErrors(errors);
        response.setNotify(true);
        response.setHasError(true);
        return response;
    }

}

