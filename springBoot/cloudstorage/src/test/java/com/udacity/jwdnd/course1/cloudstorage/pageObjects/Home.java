package com.udacity.jwdnd.course1.cloudstorage.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

    //Xpath=//tagname[@attribute='value']
    //Note panel
    public Home(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"logoutDiv\"]//button")
    private WebElement logOutButton;


    @FindBy(id = "nav-notes-tab")
    private WebElement notePane;

    @FindBy(id = "note-Description")
    private WebElement noteDescription;

    @FindBy(id = "note-Title")
    private WebElement noteTitle;

    @FindBy(id = "save-note")
    private WebElement noteSubmit;

    @FindBy(id = "add-note")
    private WebElement addNoteButton;

    @FindBy(xpath = "//*[@id=\"nav-notes\"]//tbody/tr/td/button")
    private WebElement editNote;

    @FindBy(xpath = "//*[@id=\"nav-notes\"]//tbody/tr/th")
    private WebElement noteTitleText;

    @FindBy(xpath = "//*[@id=\"nav-notes\"]//tbody/tr/td[2]")
    private WebElement noteDescriptionText;

    @FindBy(xpath = "//*[@id=\"nav-notes\"]//tbody/tr/td/a")
    private WebElement deleteNoteButton;

    //Credential
    @FindBy(id = "nav-credentials-tab")
    private WebElement credentialPane;

    @FindBy(id = "credential-url")
    private WebElement credentialUrl;

    @FindBy(id = "credential-username")
    private WebElement credentialUsername;

    @FindBy(id = "credential-password")
    private WebElement credentialPassword;

    @FindBy(id = "add-credential")
    private WebElement addCredentialButton;

    @FindBy(id = "save-submitCredential")
    private WebElement credentialSubmit;

    @FindBy(xpath = "//*[@id=\"nav-credentials\"]//tbody/tr/th")
    private WebElement credentialUrlText;

    @FindBy(xpath = "//*[@id=\"nav-credentials\"]//tbody/tr/td[2]")
    private WebElement credentialUsernameText;

    @FindBy(xpath = "//*[@id=\"nav-credentials\"]//tbody/tr/td[3]")
    private WebElement credentialPasswordText;


    @FindBy(xpath = "//*[@id=\"nav-credentials\"]//tbody/tr/td/button")
    private WebElement editCredential;

    @FindBy(xpath = "//*[@id=\"nav-credentials\"]//tbody/tr/td/a")
    private WebElement deleteCredential;





    public void logOut(){
        logOutButton.click();
    }

    // Note Panel CURD Operations

    public void goToNotePane(){
        notePane.click();
    }

    public void goToCredentilPanel(){
        credentialPane.click();
    }

    public void createNote(String title,String desc){
        noteTitle.sendKeys(title);
        noteDescription.sendKeys(desc);
        noteSubmit.click();
    }

    public void editNote(String title,String desc){
        noteTitle.clear();
        noteDescription.clear();
        createNote(title,desc);

    }

    public WebElement getEditNote() {
        return editNote;
    }

    public WebElement getAddNoteButton() {
        return addNoteButton;
    }

    public WebElement getNoteSubmit() {
        return noteSubmit;
    }

    public WebElement getDeleteNoteButton() {
        return deleteNoteButton;
    }

    public WebElement getNoteTitle() {
        return noteTitle;
    }

    public WebElement getNoteTitleText(){
        return noteTitleText;
    }

    public WebElement getDescription() {
        return noteDescription;
    }

    public WebElement getNoteTitleDescription() {
        return noteDescriptionText;
    }


   //*************************End of Note***************************************

// Credential CURD Operations

    public WebElement getCredentialPane() {
        return credentialPane;
    }

    public WebElement getCredentialUrl() {
        return credentialUrl;
    }

    public WebElement getCredentialUsername() {
        return credentialUsername;
    }

    public WebElement getCredentialPassword() {
        return credentialPassword;
    }

    public WebElement getAddCredentialButton() {
        return addCredentialButton;
    }

    public WebElement getCredentialSubmit() {
        return credentialSubmit;
    }

    public WebElement getCredentialUrlText() {
        return credentialUrlText;
    }

    public WebElement getCredentialUsernameText() {
        return credentialUsernameText;
    }

    public String getCredentialPasswordText() {
        return credentialPasswordText.getText();
    }

    public WebElement getEditCredential() {
        return editCredential;
    }

    public WebElement getDeleteCredential() {
        return deleteCredential;


    }

    public void createNewCredential(String url, String userName, String password){
        credentialUrl.sendKeys(url);
        credentialUsername.sendKeys(userName);
        credentialPassword.sendKeys(password);
        credentialSubmit.click();
    }

    public void editCredential(String url,String userName, String password){
        credentialUrl.clear();
        credentialUsername.clear();
        credentialPassword.clear();
        createNewCredential(url, userName,password);
    }

}
