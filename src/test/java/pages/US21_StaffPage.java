package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US21_StaffPage {

    public US21_StaffPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "account-menu")
    public WebElement accountMenuButton;

    @FindBy(id = "login-item")
    public WebElement signinButton;

    @FindBy(name = "username")
    public WebElement usernameTextBox;

    @FindBy(name = "password")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitButton;

    @FindBy(id = "entity-menu")
    public WebElement myPagesButton;

    @FindBy(xpath = "(//*[text()='Search Patient'])[1]")
    public WebElement searchPatientButton;

    @FindBy(xpath = "(//*[text()='Show Appointments'])[3]")
    public WebElement showAppointmentsButton;

//    @FindBy(xpath="(//tbody//td)[13]/div/a")
//    public List<WebElement> buttons;


    @FindBy(xpath="(//*[@class='d-none d-md-inline'])[1]")
    public WebElement editButton;

    @FindBy(xpath="//*[@class='d-none d-md-inline']")
    public List<WebElement> allButtons;


    @FindBy(id = "appointment-status")
    public WebElement statusDropdown;

    @FindBy(xpath = "//*[@value='UNAPPROVED']")
    public WebElement unapprovedOption;

    @FindBy(xpath = "//*[@value='PENDING']")
    public WebElement pendingOption;

    @FindBy(xpath = "//*[@value='CANCELLED']")
    public WebElement canceledOption;

    @FindBy(xpath = "//*[@value='COMPLETED']")
    public WebElement completedOption;


    @FindBy(name = "anamnesis")
    public WebElement anamnesisTextBox;

    @FindBy(name = "treatment")
    public WebElement treatmentTextBox;

    @FindBy(name = "diagnosis")
    public WebElement diagnosisTextBox;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(xpath = "//*[contains(text(),'updated')]")
    public WebElement updatedMessage;

    @FindBy(id = "appointment-physician")
    public WebElement physicianDropdown;

    @FindBy(xpath = "//*[@value='10512']")
    public WebElement doctor79;

    @FindBy(xpath = "//*[text()='Show Tests']")
    public WebElement showTestsButton;

    @FindBy(xpath = "//*[text()='Tests']")
    public WebElement testsPage;

    //hello






}
