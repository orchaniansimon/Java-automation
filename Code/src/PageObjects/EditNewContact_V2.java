
package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;

public class EditNewContact_V2 implements Initializations{
	private WebDriver driver;

	public EditNewContact_V2(WebDriver driver) {
		this.driver = driver;
	}

	// Goto administration --> suggested posts    
	public boolean verifyEditNewContacts_V2() throws InterruptedException  {             


		WebElement clickSocialHeaderLink = driver.findElement(socialHeaderLink);
		clickSocialHeaderLink.click(); 
		Thread.sleep(2000);

		WebElement getSocialContactsLink = driver.findElement(socialContactsLink);
		getSocialContactsLink.click();  
		Thread.sleep(8000); 

		WebElement getClickCreatedContact = driver.findElement(clickCreatedContact);
		getClickCreatedContact.click(); 
		Thread.sleep(2000);

		WebElement getClickEditButtonOnDrawer = driver.findElement(clickEditButtonOnDrawer);
		getClickEditButtonOnDrawer.click(); 
		Thread.sleep(2000);

		//Fill in the contact information
		WebElement getFirstNameField = driver.findElement(firstNameField);
		WebElement getEmailAddressField = driver.findElement(emailAddressField);

		//Append a random integer to the text so it's not a duplicate contact 
		getFirstNameField.clear();
		getFirstNameField.sendKeys("Edited-TesterFirstName" + newContactNameRandomInteger);
		getEmailAddressField.clear();
		getEmailAddressField.sendKeys("Edited-Email" + newContactNameRandomInteger + "@hearsaycorp.com");
		String verifyEditedEmail = getEmailAddressField.getText();

		WebElement getClickSaveContactButtonOnDrawer = driver.findElement(clickSaveContactButtonOnDrawer);
		getClickSaveContactButtonOnDrawer.click();

		WebElement getcloseButtonOnDrawer = driver.findElement(closeButtonOnDrawer);
		getcloseButtonOnDrawer.click();

		//Get page source
		String pageSource = driver.getPageSource();

		//Verify that page source contains edited email
		if(pageSource.contains(verifyEditedEmail))
		{
			return true;
		}
		return false;
	}	
}
