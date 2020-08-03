package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.Initializations;

public class EndUserSuggestedContentPostWithTags extends Utilities implements Initializations{ 
	private WebDriver driver;

	//Initially set the number of tagged posts to zero - variable is used later for actual count
	int getNumberOfTaggedPosts = 0;


	public EndUserSuggestedContentPostWithTags(WebDriver driver) {
		this.driver = driver;
	}


	// Goto administration --> suggested posts    
	public String clickOnNewLibraryPostLink() throws InterruptedException  {             

		Thread.sleep(3000);		

		WebElement clickNewLibraryPostLink = driver.findElement(libraryPostLink); 

		// Wait for elements to be visible
		WebDriverWait waitForLibraryPostModal = new WebDriverWait(driver, 2000);

		if (clickNewLibraryPostLink.isDisplayed()) { 
			clickNewLibraryPostLink.click(); 
			Thread.sleep(2000);

			// Wait for the email campaign link to be visible
			waitForLibraryPostModal.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".composition-area"))); 
			WebElement libraryPostComposition = driver.findElement(libraryPostModalComposition);

			//Append a random integer to the text so it's not a duplicate suggested post
			libraryPostComposition.sendKeys("User suggested post" + suggestedPostRandomInteger);

			//Click on the social networks link 
			WebElement getSocialNetworksLink = driver.findElement(socialNetworksLink);  
			getSocialNetworksLink.click();
			Thread.sleep(2000);

			//Uncheck Instagram, Google+, and Sites 
			//WebElement uncheckGoogleLink = driver.findElement(googleLink);
			//uncheckGoogleLink.click();
			WebElement uncheckInstagramLink = driver.findElement(instagramLink);
			uncheckInstagramLink.click();
			Thread.sleep(2000);
			//WebElement uncheckSitesLink = driver.findElement(hearsaySitesLink);
			//uncheckSitesLink.click();

			//Click on tags link and tag selector
			WebElement getClickTagsLink = driver.findElement(clickTagsLink);
			getClickTagsLink.click();
			Thread.sleep(2000);
			WebElement getClickTagsSelector = driver.findElement(clickTagsSelector); 
			getClickTagsSelector.click();
			Thread.sleep(2000);

			//Select a specific tag from the selector
			Select tagsSuggestedPostDropdown = new Select(driver.findElement(By.id("contentTags_tag_selector")));
			tagsSuggestedPostDropdown.selectByVisibleText("Education");						

			//Fetching all webElements associated with each options
			List<WebElement> elements = tagsSuggestedPostDropdown.getOptions();

			//Create a new array to store the text value of each element 
			List<Object> optionsText = new ArrayList<>();

			//Iterating through elements list and get text and insert in optionsText list

			for (WebElement element : elements) {
				optionsText.add(element.getText());  
				System.out.println(optionsText);
			}

			//Convert list in array by calling toArray() method
			Assert.assertEquals(options, optionsText.toArray());

			//Click the suggest button
			WebElement getSuggestButton = driver.findElement(suggestButtonLink); 
			getSuggestButton.click();
			Thread.sleep(2000);

			WebElement getAlertInfo = driver.findElement(alertInfoText);
			WebElement getCloseLinkOnModal = driver.findElement(clickToCloseModalLink);

			if(getAlertInfo.isDisplayed()) 
			{
				String confirmContentSuggested = getAlertInfo.getText();
				getCloseLinkOnModal.click();					  
				return confirmContentSuggested;				 
			}		  				   
			else	           	   
				System.out.println("Element not found");				       
		}
		return null; 
	}



	//Click on the email campaign button --> dynamic email campaign
	public String verifyUserSuggestedPostWithTags() throws InterruptedException {            	 	

		WebElement clickSocialHeaderLink = driver.findElement(socialHeaderLink);
		clickSocialHeaderLink.click();
		Thread.sleep(2000);

		WebElement getContentLinkDropDown = driver.findElement(contentLinkDropDown);

		if (getContentLinkDropDown.isDisplayed()) 
		{   
			//Click the content link 
			getContentLinkDropDown.click();  
			Thread.sleep(2000);

			WebElement getPostsLinkDropDown = driver.findElement(postsLinkDropDown);
			getPostsLinkDropDown.click();
			Thread.sleep(2000);

			WebDriverWait waitForSuggestedTileMessage = new WebDriverWait(driver, 5000);
			// Wait for the email campaign link to be visible
			waitForSuggestedTileMessage.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div:nth-child(1) > div > .panel-body > .message")));    

			WebElement getUserSuggestedPostTileMessage = driver.findElement(userSuggestedPostTileMessage); 

			String userSuggestedPostMessage = getUserSuggestedPostTileMessage.getText();

			return userSuggestedPostMessage; 				    	   
		}	

		return null ; 
	}

	//Get the user suggested posts count with tags and match to what's displayed
	public Boolean verifyUserSuggestedPostCountWithTags() throws InterruptedException { 

		Thread.sleep(2000);

		WebDriverWait waitForPublishedTagLink = new WebDriverWait(driver, 8000);
		// Wait for the email campaign link to be visible
		waitForPublishedTagLink.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#mainContent")));    	

		driver.navigate().refresh();
		Thread.sleep(2000);

		//Click the tag checkbox in left nav and get the count of them
		WebElement getSideNavPublishedTagLinkFirstVisit = driver.findElement(clickSideNavPublishedTagLink);
		getSideNavPublishedTagLinkFirstVisit.click();
		Thread.sleep(2000);

		WebDriverWait waitForSuggestedPostsPage = new WebDriverWait(driver, 2000);
		// Wait for the email campaign link to be visible
		waitForSuggestedPostsPage.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#mainContent")));    

		//Get the number of suggested posts then parse it to an integer
		WebElement getNumberOfSuggestedTagsPosts = driver.findElement(numberOfSuggestedPosts);
		String numberOfTagsForSelectedTag = getNumberOfSuggestedTagsPosts.getText();	

		//Get the number of tagged posts shown initially
		int firstTaggedCountResult = Integer.parseInt(numberOfTagsForSelectedTag.substring(0,1)); 		
		//Save the number of tagged posts initially
		getNumberOfTaggedPosts = firstTaggedCountResult; 
		System.out.println("get number of tagged posts " + getNumberOfTaggedPosts);

		//Get the number of the tags count for the specific tag
		WebElement getNumberOfSuggestedPostsForTags = driver.findElement(numberOfTagsCount);
		String numberOfSuggestedPostsForTag = getNumberOfSuggestedPostsForTags.getText();

		int tagCount = Integer.parseInt(numberOfSuggestedPostsForTag.substring(1,2));
		System.out.println("tagCount " + tagCount);
		System.out.println("Verified suggested posts with tags = " + (firstTaggedCountResult == tagCount));

		//Verify that the number of tags count is equal to the number of tiles - suggested posts displayed
		if (firstTaggedCountResult == tagCount)  
		{
			return true;
		}		
		return false;
	}


}

