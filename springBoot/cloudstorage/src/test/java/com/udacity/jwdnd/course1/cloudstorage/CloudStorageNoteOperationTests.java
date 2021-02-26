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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CloudStorageNoteOperationTests {


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


    public void addingNoteTest(){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,20);
        Home home= new Home(webDriver);
        getThreadWait();
        home.goToNotePane();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(home.getAddNoteButton())).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(home.getNoteSubmit()));
        home.getNoteTitle().sendKeys("test:title");
        home.getDescription().sendKeys("test: Description");
        home.getNoteSubmit().click();
        Result result = new Result(webDriver);
        getThreadWait();
        result.getLinkToProceed().click();
        getThreadWait();
        home.goToNotePane();
        webDriverWait.until(ExpectedConditions.visibilityOf(home.getNoteTitleText()));


    }

    @Test
    @Order(1)
    public void createNoteTest(){
        addingNoteTest();
        Assertions.assertEquals("test:title",home.getNoteTitleText().getText());
        Assertions.assertEquals("test: Description",home.getNoteTitleDescription().getText());
    }

    @Test
    @Order(2)
    public void editNoteTest(){


        WebDriverWait webDriverWait = new WebDriverWait(webDriver,20);
        addingNoteTest();
        home.getEditNote().click();
        webDriverWait.until(ExpectedConditions.visibilityOf(home.getNoteSubmit()));
        home.editNote("editing title","editing description");
        Result result = new Result(webDriver);
        getThreadWait();
        Assertions.assertEquals("Success",result.retriveOperationStatus());
        result.getLinkToProceed().click();
        getThreadWait();
        home.goToNotePane();
        webDriverWait.until(ExpectedConditions.visibilityOf(home.getNoteTitleText()));
        Assertions.assertEquals("editing title", home.getNoteTitleText().getText());
        Assertions.assertEquals("editing description", home.getNoteTitleDescription().getText());

    }

    @Test
    @Order(3)
    public void deleteNote(){
        WebDriverWait wait = new WebDriverWait(webDriver,30);
        addingNoteTest();
        home.getDeleteNoteButton().click();
        Result result = new Result(webDriver);
        getThreadWait();
        Assertions.assertEquals("Success",result.retriveOperationStatus());
        result.getLinkToProceed().click();
        getThreadWait();
        home.goToNotePane();
        Assertions.assertThrows(Exception.class,()->home.getNoteTitleText().click());

    }


    public void getThreadWait(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
