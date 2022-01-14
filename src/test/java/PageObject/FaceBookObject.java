package PageObject;
import Utility.ConfigFileReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FaceBookObject {
    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    private WebElement faceBookPhoneNumberField;
    @FindBy(how = How.XPATH, using = "//input[@id='pass']")
    private WebElement faceBookPasswordField;
    @FindBy(how = How.XPATH, using = "//div[@class='_6ltg']")
    private WebElement faceBookLoginButton;
    @FindBy(how = How.XPATH, using = "//div[@class='bp9cbjyn j83agx80 byvelhso l9j0dhe7']")
    private WebElement friendTab;
    @FindBy(how = How.XPATH, using = "//div[@class='m9osqain a5q79mjw gy2v8mqq jm1wdb64 k4urcfbm qv66sw1b']")
    private WebElement createPost;
    @FindBy(how = How.XPATH, using = "//div[@class='_1mf _1mj']")
    private WebElement inputPostField;
    @FindBy(how = How.XPATH, using = "//div[@aria-label='Post']")
    private WebElement postButton;

    public FaceBookObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public FaceBookObject loadFaceBookUrl(){
        String url = configFileReader.getFaceBookUrl();
        driver.get(url);
        return this;
    }
    public FaceBookObject enterFaceBookPhoneNumber(String phone){
        if (faceBookPhoneNumberField.isDisplayed()){
            faceBookPhoneNumberField.clear();
            faceBookPhoneNumberField.sendKeys(phone);
        }else {
            System.out.println("Phone Number Field is not found");
        }

        return this;
    }
    public FaceBookObject enterFaceBookPassword(String password){
        if (faceBookPasswordField.isDisplayed()) {
            faceBookPasswordField.clear();
            faceBookPasswordField.sendKeys(password);
        }
        return this;
    }
    public FaceBookObject clickOnLoginButton(){
        if (faceBookLoginButton.isEnabled() && faceBookLoginButton.isDisplayed()){
            faceBookLoginButton.click();
        }else {
            System.out.println("Login button is not clickable");
        }
        return this;
    }
    public FaceBookObject clickFriendTab(){
        if (friendTab.isDisplayed() && friendTab.isEnabled()) {
            friendTab.click();
        }else {
            System.out.println("tab is not clickable");
        }
        return this;
    }
    public FaceBookObject clickCreatePost(){
        if (createPost.isDisplayed()){
            createPost.click();
        }else {
            System.out.println("Can not click create post");
        }
        return this;
    }
    public FaceBookObject enterPost(){
        if (inputPostField.isDisplayed()) {
            Actions actions = new Actions(driver);
            actions.moveToElement(inputPostField);
            actions.click();
            actions.sendKeys("Hello World");
            actions.build().perform();
        }else {
            System.out.println("Can not post");
        }
        return this;
    }
    public FaceBookObject scrollToProceedToCheckOut() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", postButton);
        Thread.sleep(500);
        return this;
    }
    public FaceBookObject clickPostButton(){
        if (postButton.isDisplayed() && postButton.isEnabled()) {
            postButton.click();
        }else {
            System.out.println("Post button is not clickable");
        }
        return this;
    }
}
