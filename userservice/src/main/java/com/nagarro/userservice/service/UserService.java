package com.nagarro.userservice.service;



import com.nagarro.userservice.convertor.Convertor;
import com.nagarro.userservice.dto.UserDto;
import com.nagarro.userservice.entity.User;
import com.nagarro.userservice.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Convertor convertor;

    /**
     *
     * @param userDto
     * @return UserDto
     */

    public UserDto createUser(UserDto userDto) {

        User userEntityOpt=convertor.convertUserDtoToUserEntity(userDto);

        User userEntity= userRepository.save(userEntityOpt);

        UserDto userResponse=convertor.convertUserEntityToUserDto(userEntity);

        return userResponse;
    }

}
