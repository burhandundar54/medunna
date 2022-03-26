package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class CommonPages {
    public CommonPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()='Administration']")
    public WebElement administration;
    @FindBy(xpath = "//*[text()='Items&Titles']")
    public WebElement itemtAnditles;
    @FindBy(xpath = "//*[@href='/staff']")
    public WebElement staff;
    @FindBy(xpath = "//*[text()='Create a new Staff']")
    public WebElement createANewStaff;
    @FindBy(id = "searchSSN")
    public WebElement ssnTextBox;
    @FindBy(id = "useSSNSearch")
    public WebElement useSearchCheckBox;
    @FindBy(xpath = "//*[text()='Search User']")
    public WebElement searchUserButton;
    @FindBy(xpath = "//*[text()='User found with search SSN']")
    public WebElement successMessageToast;
    @FindBy(xpath = "//*[@name='user.id']")
    public WebElement userDropdown;
    @FindBy(xpath = "(//*[text()='Edit'])[2]")
    public WebElement stafEmreEditButton;
    @FindBy(xpath = "//*[@role='alert']")
    public WebElement editSuccessMessage;
    @FindBy(xpath = "//*[@id='staff-description']")
    public WebElement descriptionTextBox;
    @FindBy(id = "save-entity")
    public WebElement saveButton;
}
