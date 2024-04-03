package com.nagarro.userservice.convertor;

import com.nagarro.userservice.dto.ContactDto;
import com.nagarro.userservice.dto.UserDto;
import com.nagarro.userservice.entity.Contact;
import com.nagarro.userservice.entity.User;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Convertor {

    @Autowired
    private ModelMapper modelMapper;

    /**
     *
     * @param userDto
     * @return User
     */
    public User convertUserDtoToUserEntity(@NotNull UserDto userDto){

        return this.modelMapper.map(userDto,User.class);
    }

    /**
     *
     * @param userEntity
     * @return UserDto
     */
    public UserDto convertUserEntityToUserDto(User userEntity){

        return this.modelMapper.map(userEntity,UserDto.class);


    }

}
