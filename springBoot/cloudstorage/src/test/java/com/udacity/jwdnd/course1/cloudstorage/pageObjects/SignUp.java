    package com.udacity.jwdnd.course1.cloudstorage.pageObjects;

    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;

    public class SignUp {

    public SignUp(WebDriver driver){
            PageFactory.initElements(driver,this);
        }


    @FindBy(id = "inputFirstName")
    private WebElement firstName;
        @FindBy(id = "inputLastName")
    private WebElement lastName;
        @FindBy(id = "inputUsername")
    private WebElement userName;
        @FindBy(id = "inputPassword")
    private WebElement password;
    @FindBy(id = "signUpSubmitButton")
    private WebElement signUpSubmit;

    @FindBy(id = "success-signUp")
    private WebElement successSignUp;
    @FindBy(id = "error-signUp")
     private WebElement errorSignUp;




    public void signupUser(String firstName,String lastName,String userName,String password){
            this.firstName.sendKeys(firstName);
            this.lastName.sendKeys(lastName);
            this.userName.sendKeys(userName);
            this.password.sendKeys(password);
            signUpSubmit.click();
    }


    public boolean successSignUp(){
            return successSignUp.isDisplayed();
       }

    public boolean errorSignUp(){
      return errorSignUp.isDisplayed();
    }





    }
