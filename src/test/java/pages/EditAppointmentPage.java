package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class EditAppointmentPage {
    public EditAppointmentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (id="entity-menu")
    public WebElement mypages;
    @FindBy (xpath="//a[@class='dropdown-item'][1]")
    public WebElement myappointment;
    //
    @FindBy (xpath="//a[@class='btn btn-primary btn-sm']")
    public WebElement edit;

    @FindBy (id="appointment-status")
    public WebElement status;

    @FindBy (name="anamnesis")
    public WebElement anamnesis;
    @FindBy (name="treatment")
    public WebElement treatment;
    @FindBy (name="diagnosis")
    public WebElement diagnosis;
    @FindBy (name="prescription")
    public WebElement prescription;
    @FindBy (id="appointment-description")
    public WebElement description;
    @FindBy (id="save-entity")
    public WebElement save;
    @FindBy (xpath="//div[@class='Toastify__toast Toastify__toast--success toastify-toast']")
    public WebElement successmessage;
    @FindBy (xpath = "//a[@href='/logout']")
    public WebElement signout;
}
