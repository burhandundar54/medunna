package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class US09_SignInPage {
    public US09_SignInPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id=\"account-menu\"]/a")
    public WebElement PersonBox;
    @FindBy(xpath = "//*[@id=\"login-item\"]/span")
    public WebElement signinButton;
    @FindBy(xpath="//*[@class='modal-title']")
    public WebElement signinPage;
    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement userNameBox;
    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement passwordBox;
    @FindBy(xpath = "//*[@id=\"login-page\"]/div/form/div[3]/button[2]/span")
    public WebElement signinlastButton;
    @FindBy(xpath = "//*[text()='MY PAGES']")
    public WebElement myPagesText;
    @FindBy(xpath = "(//*[text()='Search Patient'])[1]")
    public WebElement SearchPatienceDropbox;
    @FindBy(xpath = "//*[text()='Patients']")
    public WebElement PatiencesPage;
    @FindBy(xpath = "(//*[text()='View'])[1]")
    public WebElement viewButton;
    @FindBy(xpath = "//*[text()='Patient']")
    public WebElement PatienceInfoPage;
    @FindBy(xpath = "//*[text()='Back']")
    public WebElement Backbutton;
    @FindBy(xpath = "(//*[text()='Edit'])[1]")
    public WebElement Editbutton;
    @FindBy(xpath = "//*[text()='Create or edit a Patient']")
    public WebElement CreateOrEditPatiencePage;
    @FindBy(xpath = "//*[@id='patient-firstName']")
    public WebElement PatientNameBox;
    @FindBy(xpath = "//*[text()='Save']")
    public WebElement Savebutton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div")
    public WebElement PupupforSave;
    @FindBy(xpath = "//*[@name='ssn']")
    public WebElement ssnSearchBox;
    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/h2/b")
    public WebElement PatientId;
}