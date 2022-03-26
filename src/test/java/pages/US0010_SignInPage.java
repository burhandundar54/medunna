package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;
public class US0010_SignInPage {
    public US0010_SignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@data-icon='user']")
    public WebElement human_icon;
    @FindBy(id="login-item")
    public WebElement signin_text;
    @FindBy(xpath = "//*[@id='login-title']")
    public WebElement signinverify;
    @FindBy(id="username")
    public WebElement username_textbox;
    @FindBy(id="password")
    public  WebElement password_textbox;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signin_button;
}
