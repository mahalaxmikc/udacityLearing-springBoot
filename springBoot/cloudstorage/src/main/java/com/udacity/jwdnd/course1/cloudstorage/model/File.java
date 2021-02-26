package com.udacity.jwdnd.course1.cloudstorage.model;

public class File implements  Comparable<File>{

    private Integer fileID;
    private String fileName;
    private String contentType;
    private Long fileSize;
    private Integer userID;
    byte[] fileData;

    public File(Integer fileID, String fileName, String contentType, Long fileSize, Integer userID, byte[] fileData) {
        this.fileID = fileID;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.userID = userID;
        this.fileData = fileData;
    }

    public Integer getFileID() {
        return fileID;
    }

    public void setFileID(Integer fileID) {
        this.fileID = fileID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }


    @Override
    public int compareTo(File file) {
        return this.fileName.compareTo(file.fileName);
    }
}
