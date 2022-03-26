package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StaffFunctions {
    public StaffFunctions(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id='entity-menu']/a/span")
    public WebElement myPagesDropdown;
    @FindBy(xpath = "//*[@id='entity-menu']/div/a[1]/span")
    public WebElement searchPatientButton;
    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div[2]/div/table/tbody/tr/td[16]/div/a[1]/span/span")
    public WebElement viewButton;
    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div/h2/span")
    public WebElement patientId;
    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div[2]/div/table/tbody/tr/td[16]/div/a[2]/span/span")
    public WebElement editButton;
    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div[1]/div[2]/input")
    public WebElement searchBox;
    @FindBy(xpath = " //*[@id='app-view-container']/div/div/div/div[2]/div/table/tbody/tr/td[1]")
    public WebElement searchResult;



}