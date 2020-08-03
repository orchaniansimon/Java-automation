package PageObjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;

public class CheckTopNavMenuChoices implements Initializations {
    private WebDriver driver;

    // Get the email dynamic links
    private By googleLink = By.cssSelector("#google");
    private By instagramLink = By.cssSelector("#instagram");
    
    private By clickCreateDropDown = By.cssSelector("#create-dropdown");
    private By clickReviewDropDown = By.cssSelector("#review-dropdown");
    private By clickOrganizationDropDown = By.cssSelector("#organization-dropdown");
    private By clickSettingsDropDown = By.cssSelector("#settings-dropdown");
    private By clickAnalyzeDropDown = By.cssSelector("#analyze-dropdown");

    public CheckTopNavMenuChoices(WebDriver driver) {
	this.driver = driver;
    }

    // Goto administration --> suggested posts
    public boolean verifyCreateLinkMenuChoices() throws InterruptedException {

	// Get all elements in the menu for Create
	WebElement getClickCreateDropDown = driver.findElement(clickCreateDropDown);
	getClickCreateDropDown.click();
	Thread.sleep(SLEEP_WAIT_2000);

	List<WebElement> allElements = driver.findElements(By.cssSelector(".subnav__list-item.open > ul"));

	// Create a new array to store the text value of each element
	List<Object> optionsText = new ArrayList<>();

	// Iterating through elements list and get text and insert in optionsText list
	for (WebElement element : allElements) 
	{
	    optionsText.add(element.getText());
	    System.out.println(optionsText);
	}

	// Convert list in array by calling toArray() method and match against what
	// should be there
	if (createMenuOptions == optionsText.toArray());
	{
	    return true;
	}

    }

    // Goto administration --> suggested posts
    public boolean verifyReviewLinkMenuChoices() throws InterruptedException {

	// Get all elements in the menu for Create
	WebElement getClickReviewDropDown = driver.findElement(clickReviewDropDown);
	getClickReviewDropDown.click();
	Thread.sleep(SLEEP_WAIT_2000);

	List<WebElement> allElements = driver.findElements(By.cssSelector(".subnav__list-item.open > ul"));

	// Create a new array to store the text value of each element
	List<Object> optionsText = new ArrayList<>();

	// Iterating through elements list and get text and insert in optionsText list
	for (WebElement element : allElements)
	{
	    optionsText.add(element.getText());
	    System.out.println(optionsText);
	}

	// Convert list in array by calling toArray() method and match against what
	// should be there
	if (reviewMenuOptions == optionsText.toArray());
	{
	    return true;
	}
    }

    
    // Goto administration --> suggested posts
    public Boolean verifyOrganizationLinkMenuChoices() throws InterruptedException {

	// Get all elements in the menu for Create
	WebElement getClickOrganizationDropDown = driver.findElement(clickOrganizationDropDown);
	getClickOrganizationDropDown.click();
	Thread.sleep(SLEEP_WAIT_2000);

	List<WebElement> allElements = driver.findElements(By.cssSelector(".subnav__list-item.open > ul"));

	// Create a new array to store the text value of each element
	List<Object> optionsText = new ArrayList<>();

	// Iterating through elements list and get text and insert in optionsText list
	for (WebElement element : allElements) 
	{
	    optionsText.add(element.getText());
	    System.out.println(optionsText);
	}

	// Convert list in array by calling toArray() method and match against what should be there
	if (organizationMenuOptions == optionsText.toArray());
	{
	    return true;
	}
    }
    
    // Goto administration --> suggested posts
    public Boolean verifyAnalyzeLinkMenuChoices() throws InterruptedException {

	// Get all elements in the menu for Create
	WebElement getClickAnalyzeDropDown = driver.findElement(clickAnalyzeDropDown);
	getClickAnalyzeDropDown.click();
	Thread.sleep(SLEEP_WAIT_2000);

	List<WebElement> allElements = driver.findElements(By.cssSelector(".subnav__list-item.open > ul"));

	// Create a new array to store the text value of each element
	List<Object> optionsText = new ArrayList<>();

	// Iterating through elements list and get text and insert in optionsText list
	for (WebElement element : allElements) 
	{
	    optionsText.add(element.getText());
	    System.out.println(optionsText);
	}

	// Convert list in array by calling toArray() method and match against what should be there
	if (analyzeMenuOptions == optionsText.toArray());
	{
	    return true;
	}
    }

    
    
    // Goto administration --> suggested posts
    public Boolean verifySettingsLinkMenuChoices() throws InterruptedException {

	// Get all elements in the menu for Create
	WebElement getClickSettingsDropDown = driver.findElement(clickSettingsDropDown);
	getClickSettingsDropDown.click();
	Thread.sleep(SLEEP_WAIT_2000);

	List<WebElement> allElements = driver.findElements(By.cssSelector(".subnav__list-item.open > ul"));

	// Create a new array to store the text value of each element
	List<Object> optionsText = new ArrayList<>();

	// Iterating through elements list and get text and insert in optionsText list
	for (WebElement element : allElements) {
	    optionsText.add(element.getText());
	    System.out.println(optionsText);
	}

	// Convert list in array by calling toArray() method and match against what
	// should be there
	if (settingsMenuOptions == optionsText.toArray());
	{
	    return true;
	}

    }

    @Override
    public void method1() {
	// TODO Auto-generated method stub

    }

    @Override
    public void method2() {
	// TODO Auto-generated method stub

    }

}

