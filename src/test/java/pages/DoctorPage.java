package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class DoctorPage {
    public DoctorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="entity-menu")
    public WebElement mypages;
    @FindBy (xpath="//a[@class='dropdown-item'][1]")
    public WebElement myappointment;
    @FindBy (xpath="//a[@class='btn btn-primary btn-sm']")
    public WebElement edit;
    @FindBy (xpath ="//a[@class='btn btn-danger btn-sm']")
    public WebElement showTestResult;
    @FindBy (xpath="//a[@class='btn btn-info btn-sm']")
    public WebElement viewResultButton;
    @FindBy (xpath="//th[@class='hand'][1]")
    public WebElement ID;
    @FindBy (xpath="//th[@class='hand'][2]")
    public WebElement Name;
    @FindBy (xpath="//th[@class='hand'][4]")
    public WebElement DefaultMinValue;
    @FindBy (xpath="//th[@class='hand'][5]")
    public WebElement DefaultMaxValue;
    @FindBy (xpath="//table/thead/tr/th[6]")
    public WebElement Test;
    @FindBy (xpath="//th[@class='hand'][6]")
    public WebElement Description;
    @FindBy (xpath="//th[@class='hand'][7]")
    public WebElement Date;
    @FindBy (xpath="//tbody/tr/td[1][1]")
    public WebElement IdColumn;
    @FindBy (xpath="//tbody/tr/td[2][1]")
    public WebElement NameColumn;
    @FindBy (xpath="//tbody/tr/td[4][1]")
    public WebElement DefaultMinValueColumn;
    @FindBy (xpath="//tbody/tr/td[5][1]")
    public WebElement DefaultMaxValueColumn;
    @FindBy (xpath="//tbody/tr/td[6][1]")
    public WebElement TestColumn;
    @FindBy (xpath="//tbody/tr/td[7][1]")
    public WebElement DescriptionColumn;
    @FindBy (xpath="//tbody/tr/td[8][1]")
    public WebElement DateColumn;
    @FindBy (xpath = "//button[@class='btn btn-warning btn-sm']")
    public WebElement RequestInpatientButton;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement message;
    @FindBy (xpath = "//a[@href='/logout']")
    public WebElement signout;
}
