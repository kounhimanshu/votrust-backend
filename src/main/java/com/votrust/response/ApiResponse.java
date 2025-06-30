package com.votrust.response;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class ApiResponse {

    private String message;
    private HttpStatus status;
    private List<String> errors = new ArrayList<>(0);
    private boolean hasError;
    private boolean warning;
    private Object data;
    private boolean notify;
    private Boolean unpickCheck;

    public ApiResponse() {

    }

    public ApiResponse(List<String> errors, boolean hasError, Object data, String pdfResponse) {
        super();
        this.errors = errors;
        this.hasError = hasError;
        this.data = data;
    }



}

