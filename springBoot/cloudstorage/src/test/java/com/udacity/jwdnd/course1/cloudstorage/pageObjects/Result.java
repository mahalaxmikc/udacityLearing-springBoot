package com.udacity.jwdnd.course1.cloudstorage.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Result {
    public Result(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "a")
    private WebElement linkToProceed;
    @FindBy(tagName = "h1")
    private WebElement operationStatus;



    public String retriveOperationStatus(){
        return operationStatus.getText();
    }

    public WebElement getLinkToProceed(){
        return linkToProceed;
    }


}
