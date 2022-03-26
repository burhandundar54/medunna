package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SettingsPage {

    public SettingsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Register")
    public WebElement registerButton;


    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(id = "rememberMe")
    public WebElement rememberMeBox;

    @FindBy(xpath = "(//div[@class='alert alert-warning fade show'])[1]")
    public WebElement didYouForgetPassword;

    @FindBy(xpath = "(//div[@class='alert alert-warning fade show'])[2]")
    public WebElement haveNoAccountRegisterNew;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInAccountButton;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public WebElement settings;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement cancelButton;

    @FindBy(xpath = "//span[@aria-hidden='true']")
    public WebElement cross;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement firstNameRequiredMessage;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement lastNameRequiredMessage;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement thisFieldInvalidMsgForEmail;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameBox;
    //div[@role='alert']
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement settingsSavedMsg;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameBox;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;



}