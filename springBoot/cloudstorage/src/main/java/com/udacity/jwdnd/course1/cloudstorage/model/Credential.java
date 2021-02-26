package com.udacity.jwdnd.course1.cloudstorage.model;

public class Credential  implements Comparable<Credential>{
    private Integer credentialID;
    private String  url;
    private String  username;
    private String  encryptedKey;
    private String  password;
    private Integer userID;

    public Credential(Integer credentialID, String url, String username, String encryptedKey, String password, Integer userID) {
        this.credentialID = credentialID;
        this.url = url;
        this.username = username;
        this.encryptedKey = encryptedKey;
        this.password = password;
        this.userID = userID;
    }

    public Integer getCredentialID() {
        return credentialID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setCredentialID(Integer credentialID) {
        this.credentialID = credentialID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedKey() {
        return encryptedKey;
    }

    public void setEncryptedKey(String encryptedKey) {
        this.encryptedKey = encryptedKey;
    }

    @Override
    public int compareTo(Credential credential) {
        return this.username.compareTo(credential.username);
    }
}
