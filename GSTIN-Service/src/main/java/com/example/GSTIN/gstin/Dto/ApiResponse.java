package com.example.GSTIN.gstin.Dto;

import com.example.GSTIN.gstin.Entity.GstinDummyDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private String id;

    private int statusCode;

    private String Message;

    private Object data;
}
