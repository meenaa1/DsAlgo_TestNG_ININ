package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import DriverFactory.driverFactory;

public class LinkedListPage {
WebDriver driver;

public LinkedListPage() {
driver = driverFactory.getDriver();
PageFactory.initElements(driver, this);
}

   @FindBy(xpath = "//a[@href='linked-list']")
   @CacheLookup
   WebElement Linked_List;

   @FindBy(linkText = "Introduction")
   @CacheLookup
   WebElement Introduction_page;

   @FindBy(xpath = "//div[@class='nav-item dropdown']")
   @CacheLookup
   WebElement dropdownmenu;

   @FindBy(xpath = "//a[text()='Linked List']")
   @CacheLookup
   WebElement selectLinkedlist_DropdownMenu;

   @FindBy(xpath = "//a[text()='Try here>>>']")
   @CacheLookup
   WebElement Tryherebtn;

   @FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div[6]")
   @CacheLookup
   public WebElement Tryeditor;

   @FindBy(xpath = "//button[text()='Run']")
   @CacheLookup
   public WebElement Runbtn;

   @FindBy(id = "output")
   @CacheLookup
   WebElement Console_Output;

   @FindBy(linkText = "Creating Linked LIst")
   @CacheLookup
   WebElement Creating_LinkedList;

   @FindBy(xpath = "//a[text()='Types of Linked List']")
   @CacheLookup
   WebElement Types_LinkedList;

   @FindBy(xpath = "//a[text()='Implement Linked List in Python']")
   @CacheLookup
   WebElement Implementing_LinkedList;

   @FindBy(xpath = "//a[text()='Traversal']")
   @CacheLookup
   WebElement Traversal_link;

   @FindBy(linkText = "Insertion")
   @CacheLookup
   WebElement Insertion_link;

   @FindBy(linkText = "Deletion")
   @CacheLookup
   WebElement Deletion_link;

   @FindBy(linkText = "Practice Questions")
   @CacheLookup
   WebElement Practice_Questions;

    public void Getstarted() {
    Linked_List.click();
    }
    public void Introductionpage() {
    Introduction_page.click();
    }
    public void Tryhere() {
    Tryherebtn.click();
    }
    public void dropdownmenuClick() {
    dropdownmenu.click();
    }
    public void clickLinkListFromDropdown() {
    selectLinkedlist_DropdownMenu.click();
    }
    public void Run() {
    Runbtn.click();
    }
    public void Nocode() {
    Actions actions = new Actions(driver);
    actions.moveToElement(Tryeditor).click().sendKeys("").build().perform();
    }
    public String alertMessage() {
    return driver.switchTo().alert().getText();
    }
    public String ValidOutput() {
    return Console_Output.getText();
    }
    public void CreatingLinkedlist() {
    Creating_LinkedList.click();
    }
    public void TypesLinkedlist() {
    Types_LinkedList.click();
    }
    public void ImplementingList() {
   Implementing_LinkedList.click();
    }
    public void Traversal() {
   Traversal_link.click();
    }
    public void Insertion() {
    Insertion_link.click();
    }
    public void Deletion() {
   Deletion_link.click();

   }
    public void PracticeQuestion() {
   Practice_Questions.click();
   }
}
