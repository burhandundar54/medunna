package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.security.PublicKey;
public class SignInPage {
    public SignInPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@id='username']")
    public  WebElement userName;

    @FindBy(xpath = "//*[@id='password']")
    public  WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public  WebElement signIn;

    @FindBy(xpath = "(//div[@role='alert'])[1]")
    public WebElement failedMessagePopup;
    @FindBy(xpath = "//*[.='Administration']")
    public WebElement administration;
    @FindBy(xpath = "//*[text()='emre user']")
    public WebElement emreuserText;
    @FindBy(xpath = "//*[text()='Cancel']")
    public WebElement cancelButton;
    @FindBy(xpath = "(//*[text()='Sign in'])[2]")
    public WebElement signInText;

    @FindBy(xpath = "//*[text()='Remember me']")
    public WebElement rememberMeText;
    @FindBy(xpath = "//*[@href='/account/reset/request']")
    public WebElement didYouForgetYourPasswordLink;
    @FindBy(xpath = "//*[text()='Reset your password']")
    public WebElement resetYourPasswordText;
    @FindBy(xpath = "(//*[@href='/account/register'])[2]")
    public WebElement registerANewAccountLink;
    @FindBy(id = "rememberMe")
    public WebElement rememberMeBox;
    @FindBy(xpath = "//*[text()='Sign out']")
    public WebElement signOut;
    @FindBy(xpath = "//*[text()='SIGN IN AGAIN']")
    public WebElement signInAgain;
    @FindBy(id = "email")
    public WebElement emailBox;
    @FindBy(xpath = "//*[text()='Reset password']")
    public WebElement resetPasswordButton;
    @FindBy(xpath = "//*[text()='Check your emails for details on how to reset your password.']")
    public WebElement successMessageToastContainer;

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement accountMenu;

    @FindBy (xpath = "(//*[@href='#appointment'])[1]")
    public WebElement makeAnAppoinment;





    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement signInDropdown;
    @FindBy(xpath = "//*[@id='login-item']/span")
    public WebElement signInButton;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement usernameBox;
    @FindBy(id = "password")
    public WebElement passwordBox;
    @FindBy(xpath = "//*[@id='login-page']/div/form/div[3]/button[2]/span")
    public WebElement signinConfirm;


}

