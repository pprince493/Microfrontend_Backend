package com.nagarro.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import com.nagarro.userservice.constant.Constant;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto{

    private int contactId;

    //    phone number
    @NotBlank(message = Constant.PHONE_NUMBER_REQUIRED_MESSAGE)  // 10 digits start with 6,7,8 or 9
    @Pattern(regexp = Constant.PHONE_NUMBER_PATTERN, message = Constant.PHONE_NUMBER_ERROR_MESSAGE)
    private String digits;


    //    country name
    @NotBlank(message = Constant.COUNTRY_REQUIRED_MESSAGE)       //India
    @Pattern(regexp = Constant.COUNTRY_PATTERN, message = Constant.COUNTRY_ERROR_MESSAGE)
    private String country;


    //    country code
    @NotBlank(message = Constant.COUNTRY_REQUIRED_ERROR_MESSAGE)  //only +91
    @Pattern(regexp = Constant.COUNTRY_CODE_PATTERN, message = Constant.COUNTRY_CODE_ERROR_MESSAGE)
    private String countryCode;

    private boolean active;


}
