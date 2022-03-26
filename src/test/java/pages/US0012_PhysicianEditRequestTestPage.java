package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;
public class US0012_PhysicianEditRequestTestPage {
    public US0012_PhysicianEditRequestTestPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//tbody/tr[1]/td[13]")
    public WebElement editButton;
    @FindBy(xpath = "//h2[@id='hospitalmsappfrontendApp.appointment.home.createOrEditLabel']")
    public WebElement editPageVerify;
    @FindBy(xpath = "//*[text()='Request A Test']")
    public WebElement requestTestButton;
    @FindBy(xpath = "//h2[@id='c-test-item-heading']")
    public WebElement requestTestVerify;
    @FindBy(xpath = "//tbody//tr//td[2]")
    public List<WebElement> itemsName;
    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> checkmarkOptions;
}