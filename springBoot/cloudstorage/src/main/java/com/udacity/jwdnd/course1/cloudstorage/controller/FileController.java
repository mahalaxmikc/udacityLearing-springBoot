package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileController {

@Autowired
 private FileService fileService;
@Autowired
 private UserService userService;

    @PostMapping("/uploadFile")
    public String upload(@RequestParam("fileUpload") MultipartFile multipartFile, Model model, Authentication authentication){
        Integer userID= userService.getUserByUserName(authentication.getName());
        boolean errorSaveUploadFile= false;
        if(!fileService.fileNameAlreadyExist(userID,multipartFile.getOriginalFilename()))
            errorSaveUploadFile = true;
        if(multipartFile.isEmpty())
            errorSaveUploadFile = true;
        if(errorSaveUploadFile==false) {
            try {
                if (fileService.saveFile(multipartFile, userID) < 0)
                    errorSaveUploadFile = true;
            } catch (IOException e) {
                errorSaveUploadFile = true;
            }
        }
        if(errorSaveUploadFile)
            model.addAttribute("errorUpload","File Already Exist/ No File Selected");
        else
            model.addAttribute("successUpload",true);
        return "result";
    }

    @GetMapping("/saveFile/{fileName}")
    public ResponseEntity saveFile(@PathVariable String fileName, Authentication authentication){
        Integer userID= userService.getUserByUserName(authentication.getName());
        File file = fileService.getFileByFileUserID(fileName,userID);
        if(file!=null)
            return  ResponseEntity.ok().contentType(MediaType.parseMediaType(file.getContentType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;fileName=\""+fileName+"\"")
                    .body(file.getFileData());

        return null;
    }

    @GetMapping("/delete-file/{fileID}")

    public String deleteFile(@PathVariable int fileID,Model model){
        boolean errorDeleteFile= false;
        if(fileService.deleteFileByFileId(fileID)<1)
            errorDeleteFile = true;
        if(errorDeleteFile )
            model.addAttribute("errorDelete","Error While Deleting file ,please try again");
        else
            model.addAttribute("successDelete",true);
        return "result";
    }
}
