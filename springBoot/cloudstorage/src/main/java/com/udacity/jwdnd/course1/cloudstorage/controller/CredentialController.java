package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentailService;
import com.udacity.jwdnd.course1.cloudstorage.services.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.services.HashService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.SecureRandom;
import java.util.Base64;

@Controller
public class CredentialController {
    @Autowired
    private UserService  userService;
    @Autowired
    private CredentailService credentailService;
    @Autowired
    private EncryptionService encryptionService ;


    @PostMapping("/saveCredential")
    public String saveUpdateCredential(@ModelAttribute ("newCredential")Credential credential, Model model,
                                       Authentication authentication){
        boolean isUpdate=false;
        boolean errorSaveUpdateCredential= false;
        String successSaveUpdateCredential=null;
        Integer userID= userService.getUserByUserName(authentication.getName());

        //key generated & encrpted password


        if(credential != null ) {
            SecureRandom secureRandom = new SecureRandom();
            byte[] key = new byte[16];
            secureRandom.nextBytes(key);
            credential.setUserID(userID);
            String key1 = Base64.getEncoder().encodeToString(key);
            credential.setEncryptedKey(key1);
            String passFormData=credential.getPassword();
            credential.setPassword(encryptionService.encryptValue(passFormData, key1));

            if (credential.getCredentialID() !=null) {
                isUpdate = true;
                if (credentailService.updateCredential(credential) < 0)
                    errorSaveUpdateCredential = true;
            }
            if (!isUpdate) {
                if(credentailService.getCredentialByUsernameUserID(credential.getUsername(),userID)!=null)
                    errorSaveUpdateCredential=true;
                else if (credentailService.createCredential(credential) < 0)
                    errorSaveUpdateCredential = true;
            }
            if (errorSaveUpdateCredential)
                model.addAttribute("errorUpdateCreate","Error while saving/updating/Duplicate Entry UserName already exist,please try again");
            else
                model.addAttribute("successCreateUpdate","Successfully Created/Updated the Credential details");

        }else{
            errorSaveUpdateCredential=true;
            model.addAttribute("errorUpdateCreate","Credentials Not Available");
        }
        return  "result";
    }

    @GetMapping("/delete-credential/{credentialID}")
    public String deleteCredential(@PathVariable Integer credentialID, Model model){

        boolean errorDeleteCredential= false;
        if (credentialID !=null) {
            Integer deletedCredentialId = credentailService.deleteNoteByCredentialID(credentialID);
            if (deletedCredentialId == credentialID) {
                model.addAttribute("successDelete", "Successfully Deleted");
            } else {
                errorDeleteCredential = true;
                model.addAttribute("errorDelete", "Error while deleting the Credential");
            }
        }else{
            errorDeleteCredential = true;
            model.addAttribute("errorDelete", "Error : Not Available");
        }
        return "result";
    }

    @GetMapping("/decryptedPassword/{credentialID}")
    public ResponseEntity getDecryptedPassword(@PathVariable int credentialID, Model model){

        Credential credential= credentailService.getByCredentialID(credentialID);
        String decryptedPassword = encryptionService.decryptValue(credential.getPassword(),credential.getEncryptedKey());
        return ResponseEntity.ok(decryptedPassword);
    }

}
