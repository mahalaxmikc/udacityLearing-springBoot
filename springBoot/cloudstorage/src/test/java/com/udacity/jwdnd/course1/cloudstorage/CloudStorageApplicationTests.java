package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.pageObjects.Home;
import com.udacity.jwdnd.course1.cloudstorage.pageObjects.Login;
import com.udacity.jwdnd.course1.cloudstorage.pageObjects.SignUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudStorageApplicationTests {

	@LocalServerPort
	private int port;

	private WebDriver driver;



	@BeforeAll
	static void beforeAll() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public void beforeEach() {

		this.driver = new ChromeDriver();
	}

	@AfterEach
	public void afterEach() {
		if (this.driver != null) {
			driver.quit();
		}
	}

	@Test
	public void getLoginPage() {
		driver.get("http://localhost:" + this.port + "/login");
		Assertions.assertEquals("Login", driver.getTitle());
	}

	@Test
	public void noValidAuthorization(){
		driver.get("http://localhost:"+this.port+"/home");
		Assertions.assertEquals("Login",driver.getTitle());
	}

	@Test
	public void getSignUp(){
		driver.get("http://localhost:"+this.port+"/signup");
		Assertions.assertEquals("User Sign Up",driver.getTitle());
	}

	@Test
	public void verifySignUp() throws InterruptedException {
		driver.get("http://localhost:"+this.port+"/signup");
		SignUp signUp =  new SignUp(driver);
		signUp.signupUser("John","Smith","user","user");
		Assertions.assertTrue(signUp.successSignUp());
		driver.get("http://localhost:"+port+"/login");
		Login login = new Login(driver);
		login.loginUser("user","user");
		Assertions.assertEquals("Home",driver.getTitle());
		Home home= new Home(driver);
		Thread.sleep(5000);
		home.logOut();
		Assertions.assertEquals("Login",driver.getTitle());
	}

}
