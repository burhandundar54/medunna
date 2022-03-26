package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Staff0022Page {

    public Staff0022Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement accountMenu;
    @FindBy(xpath = "(//*[@class='dropdown-item'])[1]")
    public WebElement signIn;


    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;
    @FindBy(xpath = "//*[@id='password']")
    public  WebElement password;
    @FindBy(xpath = "//*[@type='submit']")
    public  WebElement signInButton;
    @FindBy(xpath = "(//*[text()='Sign in'])[2]")
    public WebElement signInText;
    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement signOutButton;

    @FindBy(id="entity-menu")
    public WebElement mypagesstaff;
    @FindBy(xpath ="//a[@href='/search-patient']")
    public WebElement searchpatientstaff;
    @FindBy(xpath ="//input[@class='form-control']")
    public WebElement patientssnbox;
    @FindBy(xpath ="//table/tbody/tr")
    public WebElement firstrow;
    @FindBy(xpath ="//a[@href='/patient-appointments/3356']")
    public WebElement showappoitnmentsbuttonstaff;
    @FindBy(xpath ="//a[@href='/tests/appointment/17414']")
    public WebElement showtestsbuttonstaff;
    @FindBy(xpath ="//a[@href='/testresult/test/29102']")
    public WebElement viewresultsbuttonstaff;
    @FindBy(xpath ="//a[@href='/c-test-result-update/26296']")
    public WebElement editbuttonstaff;


    @FindBy(xpath = "//input[@name='id']")
    public WebElement testIdboxstaff;
    @FindBy(xpath = "//input[@class='form-control is-untouched is-pristine av-valid form-control']")
    public WebElement testdateboxstaff;
    @FindBy(xpath ="//div/input[@id='c-test-result-result']")
    public WebElement resultbuttonstaff;
    @FindBy(xpath ="//div/input[@id='c-test-result-description']")
    public WebElement descriptionbuttonstaff;
    @FindBy(xpath = "//input[@id='c-test-result-createdDate']")
    public WebElement testcreatedDateboxstaff;
    @FindBy(xpath = "(//select[@class='form-control is-untouched is-pristine av-valid form-control'])[1]")
    public WebElement testTestItemboxstaff;
    @FindBy(xpath = "(//select[@class='form-control is-untouched is-pristine av-valid form-control'])[2]")
    public WebElement testTestboxstaff;
    @FindBy(id="save-entity")
    public WebElement savebuttonstaff;
    @FindBy(xpath ="//a[@href='/testresult/test/29102/26297']")
    public WebElement visibilityrowstaff;

}