package com.nagarro.watermarkservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private String id;

    private int statusCode;

    private String message;

    private Object data;

}
