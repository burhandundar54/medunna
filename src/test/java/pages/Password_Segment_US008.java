package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Password_Segment_US008 {

    public Password_Segment_US008 (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "login-item")
    public WebElement signInMenuButton;

    @FindBy(xpath = "//h5")
    public WebElement signInTitleText;

    @FindBy(id = "username")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInSubmitButton;

    @FindBy(xpath = "//*[text()='User Recep']")
    public WebElement adminNameHomePage;

    @FindBy(xpath = "//a[@href='/account/password']")
    public WebElement passwordMenuButton;

    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement signOutMenuButton;

    @FindBy(id = "password-title")
    public WebElement passwordTitleText;

    @FindBy(id = "currentPassword")
    public WebElement currentPasswordBox;

    @FindBy(id = "newPassword")
    public WebElement newPasswordBox;

    @FindBy(id = "confirmPassword")
    public WebElement confirmPasswordBox;

    @FindBy(xpath = "//*[@id=\"strengthBar\"]/li[5]")
    public WebElement fifthStrengthBar;

    @FindBy(xpath = "//*[@id=\"strengthBar\"]/li")
    public List<WebElement> strengthsBar;

    @FindBy(xpath = "//button[@type='submit']")
    public  WebElement saveSubmitButton;

    @FindBy(xpath = "//*[text()='Password changed!']")
    public  WebElement passwordChangedMessage;

    @FindBy(xpath = "//*[contains(text(),'The password could not be changed')]")
    public  WebElement passwordNotChangedMessage;

    @FindBy(xpath = "//*[contains(text(),'at least 4 characters')]")
    public  WebElement passwordMoreThanFourMessage;

    @FindBy(xpath = "//*[contains(text(),'confirmation do not match!')]")
    public  WebElement passwordNotMatchMessage;

    @FindBy(xpath = "//*[text()='New password confirmation']")
    public  WebElement passwordShouldBeConfirmMessage;

    @FindBy(xpath = "//div[text()='Your password is required.']")
    public  WebElement passwordIsRequiredMessage;

    @FindBy(xpath = "//div[text()='Authentication information not correct.']")
    public  WebElement passwordInformationIncorrectMessage;

}
