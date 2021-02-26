package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.pageObjects.Home;
import com.udacity.jwdnd.course1.cloudstorage.pageObjects.Login;
import com.udacity.jwdnd.course1.cloudstorage.pageObjects.Result;
import com.udacity.jwdnd.course1.cloudstorage.pageObjects.SignUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CloudStorageCredentialOperationTest {

    @LocalServerPort
    private int port;

    private WebDriver webDriver;

    private Home home;

    @BeforeAll
    private static void beforeAll(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public   void beforeEach(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.addArguments("--remote-debugging-port=9225");
        this.webDriver= new ChromeDriver(chromeOptions);
        this.webDriver.get("http://localhost:"+port+"/signup");
        SignUp signUp = new SignUp(webDriver);
        signUp.signupUser("John","Smith","user","user");
        this.webDriver.get("http://localhost:"+port+"/login");
        Login login=new Login(webDriver);
        login.loginUser("user","user");
        home= new Home(webDriver);

    }

    @AfterEach
    private void afterEach(){
        if(webDriver!=null){
            webDriver.quit();
        }
    }

    public void getThreadWait(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    public void createcredential(){
        credentialAdding("user","user","user");
        Assertions.assertEquals("user",home.getCredentialUrlText().getText());
        assertEquals("user",home.getCredentialUsernameText().getText());
        assertFalse(home.getCredentialPasswordText().equals("user"));
    }

    @Test
    @Order(3)
    public void deleteCredential(){
        credentialAdding("user.getConnected","user","userPassKey");
        home.getDeleteCredential().click();
        Result result = new Result(webDriver);
        getThreadWait();
        assertEquals("Success",result.retriveOperationStatus());
        result.getLinkToProceed().click();
        getThreadWait();
        home.goToCredentilPanel();
        Assertions.assertThrows(Exception.class,()->home.getCredentialUrlText().click());

    }

    @Test
    @Order(2)
    public void edit(){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,25);
        credentialAdding("url","user","userPassKey");
        home.getEditCredential().click();
        webDriverWait.until(ExpectedConditions.visibilityOf(home.getCredentialSubmit()));
        home.editCredential("editURL","editUser","editUserPassKey");
        Result result = new Result(webDriver);
        getThreadWait();
        assertEquals("Success",result.retriveOperationStatus());
        result.getLinkToProceed().click();
        getThreadWait();
        home.goToCredentilPanel();
        webDriverWait.until(ExpectedConditions.visibilityOf(home.getCredentialUrlText()));
        assertEquals("editURL", home.getCredentialUrlText().getText());
        assertEquals("editUser", home.getCredentialUsernameText().getText());
        assertFalse(home.getCredentialPassword().equals("editUserPassKey"));
    }

    private void credentialAdding(String add,String name,String sword){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,30);
        getThreadWait();
        home.goToCredentilPanel();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(home.getAddCredentialButton())).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(home.getCredentialSubmit()));
        home.getCredentialUrl().sendKeys(add);
        home.getCredentialUsername().sendKeys(name);
        home.getCredentialPassword().sendKeys(sword);
        home.getCredentialSubmit().click();
        Result result = new Result(webDriver);
        getThreadWait();
        result.getLinkToProceed().click();
        getThreadWait();
        home.goToCredentilPanel();
        webDriverWait.until(ExpectedConditions.visibilityOf(home.getCredentialUrlText()));



    }
}
