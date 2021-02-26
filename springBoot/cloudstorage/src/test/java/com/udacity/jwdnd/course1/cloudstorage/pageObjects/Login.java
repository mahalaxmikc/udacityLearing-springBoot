package com.udacity.jwdnd.course1.cloudstorage.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    public Login (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "inputUsername")
    private WebElement userName;
    @FindBy(id = "inputPassword")
    private WebElement password;
    @FindBy(id = "login-submit")
    private WebElement signUpSubmit;

    @FindBy(id = "logout-msg")
    private WebElement logoutMessage;
    @FindBy(id = "error-msg")
    private WebElement errorLoginMessage;


    public void loginUser(String  userName,String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.signUpSubmit.click();

    }

    public boolean logoutUser(){
        return logoutMessage.isDisplayed();
    }

    public boolean unAuthorizedUser(){
        return  errorLoginMessage.isDisplayed();
    }
}
