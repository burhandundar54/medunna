package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminPage {

    public AdminPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()='Administration']")
    public WebElement administrationButton;
    @FindBy(xpath = "//*[text()='User management']")
    public WebElement userManagement;
    //*[@id="app-view-container"]/div/div/div/div/div[1]/table/thead
    //th[@class='hand']
    //table/thead/tr
    @FindBy(xpath = "//thead//tr//th")
    public List<WebElement> titles;
    @FindBy(xpath = "//thead//tr")
    public WebElement titleLine;
    // sayfa sonu ok =>  //a[@href='javascript:void(0)'])[8]
    @FindBy(xpath = "(//a[@class='page-link'])[9]")
    public WebElement lastPageArrow;
    @FindBy(xpath = "(//li[@class='page-item'])[1]")
    public WebElement lastNumber;
    //Updateden sonra last arrow direkt calışmıyor
    @FindBy(xpath = "//tr[@id='tugbauser']//td")
    public List<WebElement> tugbaRow;
    @FindBy(xpath = "//*[contains(text(),'A user is updated with identifier tugbauser')]")
    public WebElement userUpdatedMessage;
    @FindBy(xpath = "//a[@href='/admin/user-management/tugbauser/edit']")
    public WebElement editTugbaButton;
    @FindBy(xpath = "//option[@value='ROLE_STAFF']")
    public WebElement assignAsStaff;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;
    @FindBy(xpath = "//option[@value='ROLE_STAFF']")
    public WebElement assignAsPhysician;
    @FindBy(xpath = "//a[@href='/admin/user-management/tugbauser/delete']")
    public WebElement deleteTugbaButton;
    //(//button[@type='button'])[21]
    //   /html/body/div[2]/div/div[1]/div/div/div[3]/button[2]/svg
    ///html/body/div[2]/div/div[1]/div/div/div[3]/button[2]/svg
    //*[@id="jhi-confirm-delete-patient"]/span
    @FindBy(xpath = "//div[@class='modal-footer']/button[2]")
    public WebElement confirmDelete;
    @FindBy(xpath = "//*[contains(text(),'A user is deleted with')]")
    public WebElement userDeletedMessage;



}
