package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Rooms {
    public Rooms(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@id='entity-menu']/div/a[6]")
    public WebElement roomButton;
    @FindBy(xpath ="//*[@id='jh-create-entity']" )
    public WebElement createNewRoomButton;
    @FindBy(xpath ="//*[@id='hospitalmsappfrontendApp.room.home.createOrEditLabel']/span" )
    public WebElement createNewRoomPage;
    @FindBy(xpath = "//*[@id='room-roomNumber']")
    public WebElement roomNumberBox;
    @FindBy(xpath = "//*[@id='room-roomType']")
    public WebElement roomType;
    @FindBy(xpath = "//*[@id='room-status']")
    public  WebElement statusCheckBox;
    @FindBy(xpath = "//*[@id='room-price']")
    public WebElement priceBox;
    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div[2]/div/form/div[4]/div/div")
    public WebElement thisFieldIsRequiredMessage;
    @FindBy(xpath ="//*[@id='room-description']" )
    public WebElement descriptionBox;
    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div/div[2]/div/form/div[5]")
    public WebElement descriptionBoxText;
    @FindBy(xpath = "//*[@id='room-createdDate']")
    public WebElement createdDateBox;
    @FindBy(xpath = "//*[@id='save-entity']/span")
    public WebElement saveButton;
    @FindBy(xpath = "//*[@id='root']/div/div/div[1]/div/div/div[1]")
    public WebElement roomCreatedMessage;
    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div/div[1]/div/table/tbody/tr[1]/td[8]/div/a[1]/span/span")
    public WebElement viewButton;
    @FindBy(xpath = "//*[@id='app-view-container']/div")
    public WebElement viewRoomInfo;
    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div/div[1]/div/table/tbody/tr[1]/td[8]/div/a[2]/span/span")
    public WebElement editButton;
    @FindBy(xpath = "//*[@id='root']/div/div/div[1]/div")
    public WebElement roomIsUpdatedMessage;
    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div/div[1]/div/table/thead/tr/th[7]" )
    public WebElement orderByDate;
    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div/div[1]/div/table/tbody/tr/td[8]/div/a[3]/span/span")
    public WebElement deleteButton;
    @FindBy(xpath = "//*[@id='jhi-confirm-delete-room']")
    public WebElement confirmDelete;
    @FindBy(xpath = "//*[@id='root']/div/div/div[1]/div")
    public WebElement roomDeletedMessage;
}