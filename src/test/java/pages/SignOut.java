package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignOut {
    public SignOut(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement signInDropdown;
    @FindBy (xpath = "//*[@id='account-menu']/div/a[3]/span")
    public WebElement signOutButton;


}
