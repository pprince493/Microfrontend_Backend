package com.nagarro.userservice.controller;

import com.nagarro.userservice.constant.Constant;
import com.nagarro.userservice.convertor.Convertor;
import com.nagarro.userservice.dto.ErrorResponse;
import com.nagarro.userservice.dto.UserDto;
import com.nagarro.userservice.response.ResponseHandler;
import com.nagarro.userservice.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
@CrossOrigin
@RestController
@Validated
@RequestMapping("/api")    //
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Convertor convertor;


    /**
     *
     * @param userDto
     * @return
     */

    @PostMapping("/users")
    @ApiOperation(value = "Create User",notes = "creating a User")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto){
        try {
            UserDto userOpt = userService.createUser(userDto);
            return ResponseHandler.generateResponse(Constant.USER_CREATED_SUCCESS_MESSAGE, HttpStatus.CREATED, userOpt);
        }catch (Exception e){
            String errorMessage =Constant.USER_CREATED_FAILED_MESSAGE;
            LocalDateTime timestamp = LocalDateTime.now();
            ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage,timestamp);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
