package TestCase;

import PageObject.WalletHubPageObject;
import Utility.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WalletHubTestCase {
    WebDriver driver;
    ConfigFileReader configFileReader;
    WalletHubPageObject walletHub;
    @BeforeTest
    public void beforeTest(){
        configFileReader = new ConfigFileReader();
        System.setProperty("Webdriver.chrome.driver", configFileReader.getDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }
    @Test
    public void walletHubTest() throws InterruptedException {
        configFileReader = new ConfigFileReader();
        walletHub = new WalletHubPageObject(driver);
        walletHub.loadWalletHubUrl();
        walletHub.clickOnLoginLink();
        walletHub.enterEmail();
        walletHub.enterPassWord();
        walletHub.clickOnLoginButton();
        walletHub.reloadProfilePage();
        walletHub.scrollToReviewSection();
        walletHub.selectFourthStar();
        walletHub.validateText();
        walletHub.selectHealthInsurance();
        walletHub.setWriteReview();
        walletHub.submitReview();
        walletHub.loadWalletHubProfileUrl();
        walletHub.hoverOnUserName();
        walletHub.selectProfile();
        walletHub.assertReview();

    }

    @AfterTest
    public  void afterTest(){
        driver.quit();
    }
}
