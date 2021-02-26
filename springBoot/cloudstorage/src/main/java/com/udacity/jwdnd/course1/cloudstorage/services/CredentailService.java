package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentailService {
    @Autowired
    private CredentialMapper credentialMapper;
    @Autowired
    private  UserService userService;

    public Integer createCredential(Credential credential){
        return credentialMapper.createCredential(credential);
    }

    public Integer updateCredential(Credential credential){
       return credentialMapper.updateCredential(credential);
    }

    public List<Credential> getAllCredentialByUSerId(Integer userID){
       return credentialMapper.getAllCredentialByUSerId(userID);
    }

    public Credential getByCredentialID(Integer credentialID){
        return  credentialMapper.getCredentialByCredentialID(credentialID);
    }

    public Credential getCredentialByUsernameUserID(String username,Integer userID){
        return credentialMapper.getCredentialByUsernameUserID(username,userID);
    }
    public Integer deleteNoteByCredentialID(Integer credentialID){
        return  credentialMapper.deleteNoteByCredentialID(credentialID);
    }


}
