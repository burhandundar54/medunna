package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;
public class US0018_Create_Edit_Physician_With_AdminPage {
    public US0018_Create_Edit_Physician_With_AdminPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="entity-menu")
    public WebElement itemsPhysician;
    @FindBy(xpath = "//*[text()='Physician']")
    public WebElement physician;
    @FindBy(id="physician-heading")
    public WebElement verifyphysician_page;
    @FindBy(id = "jh-create-entity")
    public WebElement createNewPyhsician;
    @FindBy(xpath = "//*[text()='Create or edit a Physician']")
    public WebElement verifyCreatePage;
    @FindBy(id="searchSSN")
    public WebElement searchSSNTextBox;
    @FindBy(id = "useSSNSearch")
    public WebElement useSSNSearchCheckBox;
    @FindBy(xpath = "//*[text()='Search User']")
    public WebElement searchUserButton;
    @FindBy(xpath = "//*[text()='User found with search SSN']")
    public WebElement successVerifySaveMessage;
    @FindBy(name = "firstName")
    public WebElement firstNameTextBox;
    @FindBy(name = "lastName")
    public WebElement lastNameTextBox;
    @FindBy(name = "birthDate")
    public WebElement birthDateTextBox;
    //YYYY-MM-DD HH:mm
    @FindBy(id = "physician-phone")
    public WebElement physician_phone;
    @FindBy(id = "physician-adress")
    public WebElement physician_adress;
    @FindBy(id = "physician-gender")
    public WebElement physician_gender_dropdown;
    @FindBy(id = "physician-speciality")
    public WebElement physician_speciality_dropdown;
    @FindBy(id = "physician-bloodGroup")
    public WebElement physician_bloodGroup_dropdown;
    @FindBy(id="physician-description")
    public WebElement physician_description_textbox;
    @FindBy(id="file_image")
    public WebElement file_image_button;
    @FindBy(className = "col-md-11")
    public WebElement verify_image_name;
    @FindBy(id="physician-examFee")
    public WebElement examFee_textbox;
    @FindBy(name="user.id")
    public WebElement select_user_dropdown;
    @FindBy(id="physician-country")
    public WebElement physician_country_textbox;
    @FindBy(id="physician-cstate")
    public WebElement physician_cstate_textbox;
    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveButton;
    @FindBy(className="Toastify")
    public WebElement verifySaveMessage;
    //A new Physician is
    //Toastify__toast-body
    //A Physician is deleted with identifier 21649
    @FindBy(xpath = "//*[@class = 'page-item']")
    public List<WebElement> lastPageList;
    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> firstNameList;
    //    @FindBy(xpath = "(//*[@href='/physician/21641'])[2]")
//    public WebElement views;
    @FindBy(xpath = "//dd")
    public List<WebElement> verify_view_page;
    @FindBy(xpath = "//h2//b")
    public WebElement viewPageId;
    @FindBy(xpath = "//*[text()='Edit']")
    public WebElement editButton;
    @FindBy(id="jhi-confirm-delete-physician")
    public WebElement deleteButton;


//    @FindBy(xpath = "((//*[@href='/physician/38876'])[2]/following::a/following::a)[1]")
//    public WebElement deleteJeremyButton;


}