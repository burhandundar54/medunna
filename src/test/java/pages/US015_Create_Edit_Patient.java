package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US015_Create_Edit_Patient {

    public US015_Create_Edit_Patient(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@id='entity-menu']")
    public WebElement itemsTitlesMenu;

    @FindBy(xpath = "//span[text()='Patient']")
    public WebElement patientMenuInItems;

    @FindBy(id = "jh-create-entity")
    public WebElement createANewPatientVerify;

    @FindBy(xpath = "(//span[text()='View'])[1]")
    public WebElement viewButtonOfFirstPatient;

    @FindBy(xpath = "//span[text()='SSN']")
    public WebElement ssnTitleVerify;

    @FindBy(xpath = "//span[text()='First Name']")
    public WebElement firstNameTitleVerify;

    @FindBy(xpath = "//span[text()='Last Name']")
    public WebElement lastNameTitleVerify;

    @FindBy(xpath = "//span[text()='Birth Date']")
    public WebElement birthDateTitleVerify;

    @FindBy(xpath = "//span[text()='Phone']")
    public WebElement phoneTitleVerify;

    @FindBy(xpath = "//span[text()='Gender']")
    public WebElement genderTitleVerify;

    @FindBy(xpath = "//span[text()='Blood Group']")
    public WebElement bloodGroupTitleVerify;

    @FindBy(xpath = "//span[text()='Address']")
    public WebElement addressTitleVerify;

    @FindBy(xpath = "//span[text()='Description']")
    public WebElement descriptionTitleVerify;

    @FindBy(xpath = "//span[text()='Created Date']")
    public WebElement createdDateTitleVerify;

    @FindBy(xpath = "//span[text()='User']")
    public WebElement userTitleVerify;

    @FindBy(xpath = "//dt/span[text()='Country']")
    public WebElement countryTitleVerify;

    @FindBy(xpath = "//span[text()=' State/City']")
    public WebElement stateCityTitleVerify;

    @FindBy(xpath = "//dt/span")
    public List<WebElement> patientInformationInView;

    @FindBy(xpath = "//div/label/span")
    public List<WebElement> patientInformationInEdit;

    @FindBy(xpath = "//span[text()='Edit']")
    public WebElement editButtonOfFirstPatient;

    @FindBy(xpath = "//td[13]")
    public List<WebElement> userInformationInTable;

    @FindBy(xpath = "//span[text()='Delete']")
    public List<WebElement> deleteButtonInTable;

    @FindBy(xpath = "//a[@aria-label='Next']")
    public WebElement pageNumberGoNext;

    @FindBy(xpath = "//*[@id=\"jhi-confirm-delete-patient\"]/span")
    public WebElement deleteButtonForAPatient;

    @FindBy(xpath = "//*[contains(text(),'A Patient is deleted with identifier')]")
    public WebElement deleteVerifyMessage;



}