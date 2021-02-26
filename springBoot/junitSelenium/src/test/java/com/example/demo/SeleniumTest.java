package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SeleniumTest {

        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("http://localhost:8080/animal");

            WebElement inputField = driver.findElement(By.id("animalText"));
            inputField.sendKeys("Dog");

            inputField = driver.findElement(By.id("adjective"));
            inputField.sendKeys("honest");

            List<WebElement> trainingResults = driver.findElements(By.className("trainingMessage"));

            for(int i = 0; i < 5; i++) {
                inputField = driver.findElement(By.id("adjective"));
                inputField.submit();

                System.out.println("trainingResults.size() = " + trainingResults.size());
            }

            WebElement conclusionResult = driver.findElement(By.className("conclusionMessage"));
            System.out.println("conclusionResult.getText() = " + conclusionResult.getText());




            Thread.sleep(5000);
            driver.quit();
        }

        
    }
