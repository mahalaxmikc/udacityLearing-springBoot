package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private FileMapper fileMapper;


    public List<File> getAllFilesByUserID(Integer userID){
        return fileMapper.getFilesByUserID(userID);
    }

    public Integer saveFile(MultipartFile multipartFile,Integer userID) throws IOException {

       File newFile = new File(null,multipartFile.getOriginalFilename(),multipartFile.getContentType(),
                               multipartFile.getSize(),userID,multipartFile.getBytes());
        return fileMapper.saveFile(newFile);
    }


    public File getFileByFileUserID(String fileName, int userId){
        return fileMapper.getFileByFileUserID(fileName, userId);
    }


    public int deleteFileByFileId(int fileId){
        return fileMapper.deleteFileByFileId(fileId);
    }

    public boolean fileNameAlreadyExist(int userId,String fileName){
        return fileMapper.getFileByFileUserID(fileName,userId) == null;
    }




}
