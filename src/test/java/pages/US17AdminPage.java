package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US17AdminPage {

    public US17AdminPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "account-menu")
    public WebElement accountMenuButton;

    @FindBy(id = "login-item")
    public WebElement signinButton;

    @FindBy(name = "username")
    public WebElement usernameTextBox;

    @FindBy(name = "password")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitButton;

    @FindBy(id = "entity-menu")
    public WebElement itemsTitlesButton;

    @FindBy(xpath = "(//*[text()='Test Item'])[1]")
    public WebElement testItemButton;

    @FindBy(id = "jh-create-entity")
    public WebElement createTestItemButton;

    @FindBy(name = "name")
    public WebElement nameTextBox;

    @FindBy(id = "c-test-item-description")
    public WebElement descriptionTextBox;

    @FindBy(name = "price")
    public WebElement priceTextBox;

    @FindBy(name = "defaultValMin")
    public WebElement minValueTextBox;

    @FindBy(name = "defaultValMax")
    public WebElement maxValueTextBox;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(xpath = "//*[contains(text(),'created')]")
    public WebElement createdMessage;

    @FindBy(id = "nameLabel")
    public WebElement nameLabel;

    @FindBy(id = "descriptionLabel")
    public WebElement descriptionLabel;

    @FindBy(id = "priceLabel")
    public WebElement priceLabel;

    @FindBy(id = "defaultValMinLabel")
    public WebElement defaultValMinLabel;

    @FindBy(id = "defaultValMaxLabel")
    public WebElement defaultValMaxLabel;

    @FindBy(id = "createdDateLabel")
    public WebElement createdDateLabel;

    @FindBy(name = "createdDate")
    public WebElement createdDateBox;

    @FindBy(xpath = "//*[text()='»»']")
    public WebElement lastPage;

    @FindBy(xpath = "//*[@data-icon='eye']")
    public WebElement viewButton;

    @FindBy(xpath = "//h2")
    public WebElement testItemInfoHeader;

    @FindBy(xpath = "//*[contains(text(),'deleted')]")
    public WebElement deletedMessage;

    @FindBy(id = "jhi-confirm-delete-cTestItem")
    public WebElement confirmDeleteButton;


    @FindBy(xpath = "((//*[@href='/c-test-item/37214'])[2]/following::a/following::a)[1]")
    public WebElement deleteButton;


}
