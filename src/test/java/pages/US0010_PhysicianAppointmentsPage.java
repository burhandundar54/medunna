package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;
public class US0010_PhysicianAppointmentsPage {
    public  US0010_PhysicianAppointmentsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()='MY PAGES']")
    public WebElement mypages;
    @FindBy(xpath = "//*[text()='My Appointments']")
    public WebElement myappointments;
    @FindBy(xpath = "//*[text()='Appointments']")
    public WebElement appointments_text_verify;
    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> appointments_list;
    @FindBy(id="fromDate")
    public WebElement fromdate;
    @FindBy(id="toDate")
    public WebElement todate;
    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> table_head_list;
    @FindBy(xpath = "//*[text()='Administration']")
    public WebElement adminPages;
    @FindBy(xpath = "//*[@id='entity-menu']")
    public WebElement adminDropDown;
    @FindBy(xpath = "//*[text()='Test Item']")
    public WebElement testItem;
}
