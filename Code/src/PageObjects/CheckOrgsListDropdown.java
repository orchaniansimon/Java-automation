package PageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;

public class CheckOrgsListDropdown implements Initializations {
    private WebDriver driver;

    public CheckOrgsListDropdown(WebDriver driver) {
	this.driver = driver;
    }

    // Goto administration --> suggested posts
    public boolean verifyAdminWorkspaceDropdown() throws InterruptedException {

	Thread.sleep(SLEEP_WAIT_2000);
	WebElement clickOrgDropDownLink = driver.findElement(orgDropDownLink);
	clickOrgDropDownLink.click();
	Thread.sleep(SLEEP_WAIT_2000);

	List<WebElement> allElements = driver.findElements(By.cssSelector(".main-nav__dropdown.open > ul"));
	// js.executeAsyncScript("alert('Welcome to Hearsay');");
	// Create a new array to store the text value of each element
	List<Object> orgsText = new ArrayList<>();

	// Iterating through elements list and get text and insert in optionsText list
	for (WebElement element : allElements) {
	    orgsText.add(element.getText());
	    System.out.println(orgsText);
	}
	// Convert list in array by calling toArray() method and match against what
	// should be there
	String[] orgsNavTabs = orgsText.toArray(new String[] {});

	// Convert list from orgs navigation tab to deep string
	String orgsNavTabsArray = Arrays.deepToString(orgsNavTabs);

	// Convert list in constants array to deep string
	String mainNavTabsConstantsFile = Arrays.deepToString(orgsDropdownList);

	// Remove the commas and the spaces on constants nav string array
	String mainNavTabsConstantsFile_NoCommas = mainNavTabsConstantsFile.replaceAll(",", "");
	String mainNavTabsConstantsFile_Final = mainNavTabsConstantsFile_NoCommas.replaceAll("\\s", "");

	// Remove the spaces on the orgs navigation tabs
	String orgsNavTabs_Final = orgsNavTabsArray.replaceAll("\\s", "");

	System.out.println(orgsNavTabs_Final);
	System.out.println(mainNavTabsConstantsFile_Final);

	// Verify that the two string arrays are equal
	if (orgsNavTabs_Final.equals(mainNavTabsConstantsFile_Final)) {
	    return true;
	}
	return false;
    }

    public boolean verifySocialWorkspaceDropdown() throws InterruptedException {

	WebElement clickSocialHeaderLink = driver.findElement(socialHeaderLink);
	clickSocialHeaderLink.click();
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement clickOrgDropDownLink = driver.findElement(orgDropDownLink);
	clickOrgDropDownLink.click();
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement clickOrgListings = driver.findElement(orgListings);

	if (clickOrgListings.isDisplayed()) {
	    String getOrgList = clickOrgListings.getText();
	    System.out.println(getOrgList);

	    if (getOrgList.contains("Automation")) {
		return true;
	    }
	}
	return false;
    }

}
