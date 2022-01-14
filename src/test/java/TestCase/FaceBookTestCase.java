package TestCase;

import PageObject.FaceBookObject;
import Utility.ConfigFileReader;
import Utility.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FaceBookTestCase {
    ConfigFileReader configFileReader;
    WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        configFileReader = new ConfigFileReader();
        System.setProperty("Webdriver.chrome.driver", configFileReader.getDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get(configFileReader.getFaceBookUrl());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @Test
    public void faceBookTestCase() throws InterruptedException {
        configFileReader = new ConfigFileReader();
        FaceBookObject faceBook = new FaceBookObject(driver);
        String phone = configFileReader.getFaceBookNumber();
        faceBook.enterFaceBookPhoneNumber(phone);
        System.out.println(phone);
        String passWord = configFileReader.getFaceBookPassword();
        faceBook.enterFaceBookPassword(passWord);
        faceBook.clickOnLoginButton();
        faceBook.clickFriendTab();
        faceBook.clickCreatePost();
        faceBook.enterPost();
        faceBook.scrollToProceedToCheckOut();
        faceBook.clickPostButton();

    }
    @AfterTest
    public void afterTest(){
        //driver.close();
        driver.quit();
    }
}
