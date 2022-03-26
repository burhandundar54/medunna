package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;
public class Registration_Password_US003 {

    public Registration_Password_US003 (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "account-menu")
    public WebElement accountMenuButton;
    @FindBy(xpath = "//a[@href='/account/register']")
    public WebElement registerMenuButton;
    @FindBy(xpath = "//*[@id='register-title']")
    public WebElement registrationTitle;
    @FindBy(id = "firstPassword")
    public WebElement firstPasswordBox;
    @FindBy(xpath = "//*[@id=\"strengthBar\"]/li[5]")
    public WebElement fifthStrengthBar;
    @FindBy(xpath = "//*[@id=\"strengthBar\"]/li")
    public List<WebElement> strengthsBar;
    @FindBy(xpath = "//div[text()='Your password is required to be at least 4 characters.']")
    public WebElement passwordInvalid4Char;
    @FindBy(xpath = "//div[text()='Your password is required.']")
    public WebElement passwordInvalidRequired;
}
