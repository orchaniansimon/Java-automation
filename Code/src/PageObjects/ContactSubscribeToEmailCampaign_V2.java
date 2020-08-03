
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;

public class ContactSubscribeToEmailCampaign_V2 implements Initializations{
	private WebDriver driver;


	private By socialContactsLink = By.cssSelector("#subnav-list > ul > li:nth-child(5) > a");	
	private By socialHeaderLink = By.cssSelector("a:nth-child(2) > .main-nav__product-name");
	private By mailHeaderLink = By.cssSelector("li:nth-child(3) > a > .main-nav__product-name");
	private By campaignsHeaderLink = By.cssSelector("#subnav-list > ul > li:nth-child(3) > a");
	private By numberOfSubscribersForEmailCampaigns = By.cssSelector("td:nth-child(3) > ul > li");
	private By clickCreatedContact = By.cssSelector("table > tbody > :nth-child(1) > :nth-child(2)");
	private By clickSubscribeToCampaignButton = By.cssSelector(".contact-actions-button-group__subscribe-button.btn.btn-default");
	private By clickSubscribeButtonOnModal = By.cssSelector(" td:nth-child(3) > button");
	private By clickCloseOnModal = By.cssSelector(".grail-modal > div > div > div > .modal-footer > button");


	public ContactSubscribeToEmailCampaign_V2(WebDriver driver) {
		this.driver = driver;
	}

	// Goto administration --> suggested posts    
	public boolean verifyContactSubscribeToEmailCampaign_V2() throws InterruptedException  {              

		WebElement clickMailHeaderLink = driver.findElement(mailHeaderLink);
		clickMailHeaderLink.click(); 
		Thread.sleep(2000);

		WebElement clickCampaignsHeaderLink = driver.findElement(campaignsHeaderLink);
		clickCampaignsHeaderLink.click(); 
		Thread.sleep(2000);

		WebElement getNumberOfSubscribersForEmailCampaigns = driver.findElement(numberOfSubscribersForEmailCampaigns);
		String verifyNumberOfSubscribers = getNumberOfSubscribersForEmailCampaigns.getText();
		int firstVisitNumberOfSubscribers = Integer.parseInt(verifyNumberOfSubscribers.substring(0,1)); 	
		System.out.println(firstVisitNumberOfSubscribers);

		WebElement clickSocialHeaderLink = driver.findElement(socialHeaderLink);
		clickSocialHeaderLink.click(); 
		Thread.sleep(2000);

		WebElement getSocialContactsLink = driver.findElement(socialContactsLink);
		getSocialContactsLink.click();  
		Thread.sleep(2000); 

		WebElement getClickCreatedContact = driver.findElement(clickCreatedContact);
		getClickCreatedContact.click(); 
		Thread.sleep(2000);

		WebElement getClickSubscribeToCampaignButton = driver.findElement(clickSubscribeToCampaignButton);
		getClickSubscribeToCampaignButton.click(); 
		Thread.sleep(2000); 

		WebElement getClickSubscribeButtonOnModal = driver.findElement(clickSubscribeButtonOnModal);
		getClickSubscribeButtonOnModal.click();

		WebElement getClickCloseOnModal = driver.findElement(clickCloseOnModal);
		getClickCloseOnModal.click();
		Thread.sleep(2000);

		//Go back to Mail tab --> campaigns
		WebElement clickMailHeaderLinkAgain = driver.findElement(mailHeaderLink);
		clickMailHeaderLinkAgain.click(); 
		Thread.sleep(2000);

		WebElement clickCampaignsHeaderLinkAgain = driver.findElement(campaignsHeaderLink);
		clickCampaignsHeaderLinkAgain.click(); 
		Thread.sleep(2000);

		//Get the count of subscribers again to verify
		WebElement getNumberOfSubscribersForEmailCampaignsAgain = driver.findElement(numberOfSubscribersForEmailCampaigns);
		String verifyNumberOfSubscribersAgain = getNumberOfSubscribersForEmailCampaignsAgain.getText();
		int secondVisitNumberOfSubscribers = Integer.parseInt(verifyNumberOfSubscribersAgain.substring(0,1)); 
		System.out.println(secondVisitNumberOfSubscribers);

		//Verify that count of subscribers for the email campaign increased 
		if(secondVisitNumberOfSubscribers == firstVisitNumberOfSubscribers + 1)
		{
			return true;
		}
		return false;
	}	
}
