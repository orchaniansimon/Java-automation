package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;

public class CreateNewContact_V2 implements Initializations{
	private WebDriver driver;


	//Random rand = new Random();
	int randomNumber = rand.nextInt((MAX - MIN) + 1) + MIN;	
	String options[] = { "Select Color", "Red", "Green", "Yellow", "Grey" };


	public CreateNewContact_V2(WebDriver driver) {
		this.driver = driver;
	}


	// Goto administration --> suggested posts    
	public boolean verifyCreateNewContacts_V2() throws InterruptedException  {             

		WebElement clickSocialHeaderLink = driver.findElement(socialHeaderLink);
		clickSocialHeaderLink.click();
		Thread.sleep(2000);

		WebElement getSocialContactsLink = driver.findElement(socialContactsLink);

		//Need to click the content link 
		getSocialContactsLink.click();  
		Thread.sleep(8000); 

		//Click load more button to get complete count of contacts
		WebElement getLoadMoreButton = driver.findElement(loadMoreButton);
		getLoadMoreButton.click();
		Thread.sleep(4000);

		//Get initial count of contacts
		int countContacts = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		int initialNumberOfContacts = countContacts -1; 

		System.out.println("Initial number of Contacts = " + initialNumberOfContacts);

		WebElement getNewContactButton = driver.findElement(createNewContactButton);
		getNewContactButton.click();
		Thread.sleep(2000);

		//Fill in the contact information
		WebElement getFirstNameField = driver.findElement(firstNameField);
		WebElement getSecondNameField = driver.findElement(lastNameField);
		WebElement getEmailAddressField = driver.findElement(emailAddressField);
		WebElement getPhoneField = driver.findElement(phoneField);

		//Append a random integer to the text so it's not a duplicate suggested post 
		getFirstNameField.sendKeys("TesterFirstName" + newContactNameRandomInteger);
		getSecondNameField.sendKeys("TesterLastName" + newContactNameRandomInteger);
		getEmailAddressField.sendKeys("Tester" + newContactNameRandomInteger + "@hearsaycorp.com");
		getPhoneField.sendKeys("650-500-500" + randomNumber); 

		//Click on the add contact button
		WebElement getAddContactButtonSubmit = driver.findElement(addContactSubmit);
		getAddContactButtonSubmit.click(); 
		Thread.sleep(2000);

		WebElement getCreatedContactFullName = driver.findElement(createdContactFullName);
		String getCreatedContactText = getCreatedContactFullName.getText();

		WebElement getcloseButtonOnDrawer = driver.findElement(closeButtonOnDrawer);
		getcloseButtonOnDrawer.click();
		Thread.sleep(5000);

		WebElement getLoadMoreButtonAgain = driver.findElement(loadMoreButton);
		getLoadMoreButtonAgain.click();
		Thread.sleep(4000);

		//Get final count of contacts
		int countContactsAgain = driver.findElements(By.cssSelector("input[type='checkbox']")).size();

		int finalNumberOfContacts = countContactsAgain -1; 

		System.out.println("Final number of Contacts = " + finalNumberOfContacts);
		System.out.println("Created contact full name = " + getCreatedContactText);
		//Get page source
		String createdContactFullNameText = driver.getPageSource();

		//Verify that page source contains edited email
		if(createdContactFullNameText.contains(getCreatedContactText))
			{
				return true;
			}
				return false;
	}	



}
