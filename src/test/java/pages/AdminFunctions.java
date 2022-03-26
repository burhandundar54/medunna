package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminFunctions {
    public AdminFunctions(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id='entity-menu']/a/span")
    public WebElement itemsAndTitlesDropdown;
    @FindBy(xpath = "//*[@id='entity-menu']/div/a[1]/span")
    public WebElement patientOption;
    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div/div[1]/div/table/tbody/tr/td/div/a")
    public WebElement viewButton;
    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div/div[1]/div/table/tbody/tr/td[16]/div/a[2]/span/span")
    public WebElement editButton;
    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div[1]/div/table/tbody/tr/td[16]/div/a[3]/span/span")
    public WebElement deleteButton;
    @FindBy(xpath = "//*[@id='jhi-confirm-delete-patient']/span")
    public WebElement confirmDelete;

}
