package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.stereotype.Service;


import java.security.SecureRandom;
import java.util.Base64;


@Service
public class UserService {

   private UserMapper userMapper;
   private  HashService hashService;

    public UserService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    public User getUserById(Integer userId){
       return userMapper.getUserById(userId);
    }

    public int createUser(User user){
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        String encrpyt = Base64.getEncoder().encodeToString(salt);
        String password = hashService.getHashedValue(user.getPassword(), encrpyt);
        return userMapper.insert(new User(null,user.getUsername(),user.getFirstName(),user.getLastName(),
                password,encrpyt));
    }

    public boolean isUsernameAvailable(String username){
        return userMapper.getUserByUsername(username)==null;
    }

    public  Integer getUserByUserName(String username){
        return userMapper.getUserByUsername(username).getUserId();


    }
}
