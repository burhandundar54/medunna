package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class US14_DoctorPage {
    public US14_DoctorPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@id=\"account-menu\"]/a")
    public WebElement PersonBox;
    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement signinButton;
    @FindBy(xpath="//*[@class='modal-title']")
    public WebElement signinPage;
    @FindBy(xpath = "//*[@id=\"account-menu\"]/a/svg")
    public WebElement AccountMenubutton;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement UserNameTextbox;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement PasswordTextbox;
    @FindBy(xpath = "//*[@id=\"entity-menu\"]/a/span")
    public WebElement MyPageButton;
    @FindBy(xpath = "//*[text()='My Inpatients']")
    public WebElement MyInpatientsbutton;
    @FindBy(xpath = "//*[text()='ID']")
    public WebElement IDofInpatient;
    @FindBy(xpath = "//*[text()='Start Date']")
    public WebElement StartDateofInpatient;
    @FindBy(xpath = "//*[text()='End Date']")
    public WebElement EndDateofInpatient;
    @FindBy(xpath = "//*[text()='Status']")
    public WebElement StatusofInpatient;
    @FindBy(xpath = "//*[text()='Description']")
    public WebElement DescriptionofInpatient;
    @FindBy(xpath = "//*[text()='Created Date']")
    public WebElement CreatedDateofInpatient;
    @FindBy(xpath = "//*[text()='Room']")
    public WebElement RoomofInpatient;
    @FindBy(xpath = "//*[text()='Appointment']")
    public WebElement AppointmentofInpatient;
    @FindBy(xpath = "(//*[text()='Edit'])[1]")
    public WebElement EditButton;
    @FindBy(xpath = "//*[text()='In Patients']")
    public WebElement PatientInfo;
    @FindBy(xpath = "//*[@id='in-patient-startDate']")
    public WebElement StartDateTextBox;
    @FindBy(xpath = "//*[@id='in-patient-endDate']")
    public WebElement EndDateTextBox;
    @FindBy(xpath = "//*[@id='in-patient-createdDate']")
    public WebElement CreatedDateTextBox;
    @FindBy(xpath = "//*[@id='in-patient-status']")
    public WebElement StatusTextBox;
    @FindBy(xpath = "//*[text()='Save']")
    public WebElement SaveButtonforInpatient;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div")
    public WebElement VerificationofInpatientInfo;
    @FindBy(xpath = "//*[@id='in-patient-room']")
    public WebElement RoomTextBox;
    //*[@id='fromDate']
    @FindBy(xpath = "//*[@id='fromDate']")
    public WebElement fromDateTextBox;
    @FindBy(xpath = "//*[@id='toDate']")
    public WebElement toDateTextBox;
    //*[@id="in-patient-room"]/option[9]
    @FindBy(xpath = "//*[@id=\"in-patient-room\"]/option[9]")
    public WebElement selectpatientroom;
}