package com.system_employee.employee.Shared;


import lombok.Getter;

import java.util.List;

@Getter
public class GlobalResponse<T> {


    public static final String ERROR = "error";
    public static final String SUCCESS = "success";
    private final String status;
    private final T data;
    private final List<ErrorItem> error;

    public GlobalResponse(List<ErrorItem> errors) {
        this.data = null;
        this.error = errors;
        this.status = ERROR;
    }

    public GlobalResponse(T data) {
        this.data = data;
        this.status = SUCCESS;
        this.error = null;
    }

    public record ErrorItem(String message) {
    }
}
