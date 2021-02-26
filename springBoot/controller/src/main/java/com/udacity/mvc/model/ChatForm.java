package com.udacity.mvc.model;


public class ChatForm {
    private  String userName;
    private  String messageText;
    private  MesageType mesageType;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public MesageType getMesageType() {
        return mesageType;
    }

    public void setMesageType(MesageType mesageType) {
        this.mesageType = mesageType;
    }
}
