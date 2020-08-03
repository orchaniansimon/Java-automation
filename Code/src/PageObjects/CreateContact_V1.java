
package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Initializations;


public class CreateContact_V1 implements Initializations{
	private WebDriver driver;

	// Get the email dynamic links
	private By mailHeaderLink = By.cssSelector("a:nth-child(3) > .main-nav__product-name");
	private By contactsLink = By.cssSelector("#subnav-list > ul > li:nth-child(4)");
	private By addContactsButton = By.cssSelector(".contacts-search > .clearfix > div > a"); 
	private By addNewContactLink = By.cssSelector(".clearfix > div > ul > li:nth-child(1) > a");
	private By createdContactFullName = By.cssSelector(".row> .contact-page > .well > .header.clearfix");	
	private By firstNameField = By.cssSelector("form > fieldset > p:nth-child(1) > input");
	private By lastNameField = By.cssSelector("form > fieldset > p:nth-child(2) > input");	
	private By emailAddressField = By.cssSelector("form > fieldset > p:nth-child(4) > input");	
	private By addContactButton = By.cssSelector(":nth-child(5) > button");
	private By socialContactsLink = By.cssSelector("#subnav-list > ul > li:nth-child(5) > a");
	private By numberOfContacts = By.cssSelector("#contacts-search-filter-anchor > div > ul > li");	
	private By socialHeaderLink = By.cssSelector("a:nth-child(2) > .main-nav__product-name");


	public CreateContact_V1(WebDriver driver) {
		this.driver = driver;
	}

	// Goto administration --> suggested posts    
	public boolean verifyAddNewContacts() throws InterruptedException  {             

		Thread.sleep(3000);

		WebElement clickSocialHeaderLink = driver.findElement(socialHeaderLink);
		clickSocialHeaderLink.click();
		Thread.sleep(2000);

		WebElement getSocialContactsLink = driver.findElement(socialContactsLink);
		//Need to click the content link 
		getSocialContactsLink.click();  
		Thread.sleep(4000); 

		//Get initial count of contacts
		WebElement getNumberOfContacts = driver.findElement(numberOfContacts);
		String totalNumberOfContacts = getNumberOfContacts.getText();
		System.out.println(totalNumberOfContacts);
		int getTotalNumberOfContacts = Integer.parseInt(totalNumberOfContacts.substring(30,32));   
		int initialNumberOfContacts = getTotalNumberOfContacts;
		System.out.println("initial Number of Contacts = " + initialNumberOfContacts);

		//Click the mail header link
		WebElement clickMailHeaderLink = driver.findElement(mailHeaderLink); 
		// Wait for elements to be visible
		WebDriverWait waitForMailHomePage = new WebDriverWait(driver, 2000);

		if (clickMailHeaderLink.isDisplayed())
			{ 
				clickMailHeaderLink.click(); 
			}
		Thread.sleep(2000);

		// Wait for the email campaign link to be visible
		waitForMailHomePage.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".container-main > .row > .home-main-container"))); 

		//Click on the Contacts link in header 
		WebElement getContactsLink = driver.findElement(contactsLink);
		getContactsLink.click();

		Thread.sleep(4000);

		WebElement getNewContactButton = driver.findElement(addContactsButton);
		getNewContactButton.click();
		Thread.sleep(2000);

		WebElement getAddNewContactLink = driver.findElement(addNewContactLink);
		getAddNewContactLink.click();
		Thread.sleep(2000);

		//Fill in the contact information
		WebElement getFirstNameField = driver.findElement(firstNameField);
		WebElement getSecondNameField = driver.findElement(lastNameField);
		WebElement getEmailAddressField = driver.findElement(emailAddressField);

		//Append a random integer to the text so it's not a duplicate suggested post
		getFirstNameField.sendKeys("TesterFirstName" + newContactNameRandomInteger);
		getSecondNameField.sendKeys("TesterLastName" + newContactNameRandomInteger);
		getEmailAddressField.sendKeys("Tester" + newContactNameRandomInteger + "@hearsaycorp.com");

		String fullName = "TesterFirstName" + newContactNameRandomInteger + " " + "TesterLastName" + newContactNameRandomInteger;
		System.out.println(fullName);

		//Click on the add contact button
		WebElement getAddContactButton = driver.findElement(addContactButton);
		getAddContactButton.click();
		Thread.sleep(3000);

		WebElement getCreatedContactFullName = driver.findElement(createdContactFullName);
		String getCreatedContactText = getCreatedContactFullName.getText();

		if(getCreatedContactText.equalsIgnoreCase(fullName)) 
		{
			return true;
		}
		return false;
	}	


}