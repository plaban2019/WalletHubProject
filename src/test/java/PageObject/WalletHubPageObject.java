package PageObject;

import Utility.ConfigFileReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class WalletHubPageObject {
    WebDriver driver;
    ConfigFileReader configFileReader;

    @FindBy(how = How.XPATH, using = "//*[text()='Login']")
    private WebElement loginLink;
    @FindBy(how = How.XPATH, using = "//*[@id='email']")
    private WebElement emailField;
    @FindBy(how = How.XPATH, using = "//*[@id='password']")
    private WebElement passWordField;
    @FindBy(how = How.XPATH, using = "//button[@class='btn blue center reg-tabs-bt touch-element-cl']")
    private WebElement loginButton;
    @FindBy(how = How.XPATH, using = "//div[@class='pr-ct-box-space']")
    private WebElement walletHubReviewSection;
    private WebElement createPost;
    @FindBy(how = How.XPATH, using = "//*[@class='rvs-svg']//div[@class='rating-box-wrapper']/*[name()='svg'][4]")
    private WebElement rating;
    @FindBy(how = How.XPATH, using = "//div[@class='dropdown second']")
    private WebElement policyDropDown;
    @FindBy(how = How.XPATH, using = "//*[text()='Health Insurance']")
    private WebElement healthInsurance;
    @FindBy(how = How.XPATH, using = "//div[@class='android']")
    private WebElement writeReview;
    @FindBy(how = How.XPATH, using = "//h4[@class='wrev-prd-name']")
    private WebElement validateText;
    @FindBy(how = How.XPATH, using = "//*[text()='Submit']")
    private WebElement submitButton;
    @FindBy(how = How.XPATH, using = "//a[@class='user']")
    private WebElement userName;
    @FindBy(how = How.XPATH, using = "//*[text()='Profile']")
    private WebElement profile;
    @FindBy(how = How.XPATH, using = "//*[text()='Review']")
    private WebElement reviewSection;

    public WalletHubPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WalletHubPageObject loadWalletHubUrl(){
        configFileReader = new ConfigFileReader();
        String url = configFileReader.getWalletHubUrl();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(url);
        return this;
    }
    public WalletHubPageObject loadWalletHubProfileUrl(){
        configFileReader = new ConfigFileReader();
        String url = configFileReader.getWalletHubProfileUrl();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.navigate().to(url);
        return this;
    }
    public WalletHubPageObject clickOnLoginLink(){
        if (loginLink.isDisplayed() && loginLink.isEnabled()) {
            loginLink.click();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        }else {
            System.out.println("login link is not visible");
        }
        return this;
    }
    public WalletHubPageObject enterEmail(){
        if (emailField.isDisplayed()) {
            emailField.sendKeys(configFileReader.getWalletHubEmail());
        }else {
            System.out.println("email field is not visible");
        }
        return this;
    }
    public WalletHubPageObject enterPassWord(){
        if (passWordField.isDisplayed() && passWordField.isEnabled()) {
            passWordField.sendKeys(configFileReader.getWalletHubPassword());
        }else {
            System.out.println("password field is not visible");
        }
        return this;
    }
    public WalletHubPageObject clickOnLoginButton(){
        if (loginButton.isDisplayed() && loginButton.isEnabled()) {
            loginButton.click();
        }else {
            System.out.println("login button is not visible");
        }
        return this;
    }
    public WalletHubPageObject reloadProfilePage() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        return this;
    }
    public WalletHubPageObject scrollToReviewSection() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", walletHubReviewSection);
        Thread.sleep(2000);
        return this;
    }
    public WalletHubPageObject selectFourthStar() throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(rating).click().build().perform();
        Thread.sleep(3000);
        return this;
    }
    public WalletHubPageObject validateText(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(validateText));
        return this;
    }
    public WalletHubPageObject selectHealthInsurance() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(policyDropDown));
            Actions actions = new Actions(driver);
            actions.moveToElement(policyDropDown);
            actions.click();
            actions.build().perform();
            Thread.sleep(1000);
            healthInsurance.click();
            System.out.println("dropdown not found");

        return this;
    }
    public WalletHubPageObject setWriteReview(){
        String text = "Incase the innerText contains qwerty along with some leading and trailing spaces, you can use either of the following solutions...";
        Actions actions = new Actions(driver);
        actions.moveToElement(writeReview);
        actions.click();
        actions.sendKeys(text);
        actions.build().perform();
        return this;
    }
    public WalletHubPageObject profilePage() throws InterruptedException {
        driver.navigate().to(configFileReader.getWalletHubProfileUrl());
        Thread.sleep(1000);
        return this;
    }
    public WalletHubPageObject userNameValidation() {
        String str = "Plaban";
        Assert.assertEquals(userName.getText(), str);
        return this;
    }
    public WalletHubPageObject submitReview(){
        if (submitButton.isDisplayed() && submitButton.isEnabled()){
            submitButton.click();
        }else{
            System.out.println("Submit Button is not found");
        }
        return this;
    }
    public WalletHubPageObject hoverOnUserName(){
        if (userName.isDisplayed()){
            Actions actions = new Actions(driver);
            actions.moveToElement(userName);
            actions.build().perform();
        }else {
            System.out.println("not possible");
        }
        return this;
    }
    public WalletHubPageObject selectProfile(){
        if (profile.isDisplayed()){
            profile.click();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        }else {
            System.out.println("not possible");
        }
        return this;
    }
    public WalletHubPageObject assertReview(){
        Assert.assertEquals(reviewSection.isDisplayed(), true);
        return this;
    }

}
