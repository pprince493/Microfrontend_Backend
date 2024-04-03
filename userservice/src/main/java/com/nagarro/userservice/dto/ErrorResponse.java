package com.nagarro.userservice.dto;


import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ErrorResponse {

    private int status;
    private String message;
    private LocalDateTime timestamp;

}
