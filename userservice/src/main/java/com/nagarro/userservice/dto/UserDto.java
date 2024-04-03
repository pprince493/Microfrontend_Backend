package com.nagarro.userservice.dto;

import com.nagarro.userservice.constant.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;


@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

//    private int userId;

    private String referenceId;




    @NotBlank(message = Constant.NAME_REQUIRED_MESSAGE)
    @Size(min = Constant.NAME_MIN_LENGTH, max = Constant.NAME_MAX_LENGTH, message = Constant.NAME_ERROR_MESSAGE)
    @Pattern(regexp = Constant.NAME_PATTERN, message = Constant.NAME_NOT_VALID_MESSAGE)
    private String userName;

    @NotBlank(message = Constant.EMAIL_REQUIRED_MESSAGE)
    @Email(message = Constant.EMAIL_NOT_VALID_MESSAGE)
    private String userEmail;

    @Valid
    private ContactDto contact;
}
