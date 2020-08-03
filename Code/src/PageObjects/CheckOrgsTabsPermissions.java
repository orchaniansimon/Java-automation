package PageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;

public class CheckOrgsTabsPermissions implements Initializations {

    private WebDriver driver;

    public CheckOrgsTabsPermissions(WebDriver driver) {
	this.driver = driver;
    }

    // Verify navigation tabs for org 1479
    public boolean verifyAdminMainNavTabsOrg1479() throws InterruptedException {

	Thread.sleep(SLEEP_WAIT_2000);

	// Get all the elements for the top main navigation tabs
	List<WebElement> allElements = driver.findElements(By.cssSelector("#main-navigation"));

	// Create a new array to store the text value of each element
	List<Object> mainNavText = new ArrayList<>();

	// Iterating through elements list and get text and insert in optionsText list
	for (WebElement element : allElements) {
	    mainNavText.add(element.getText());
	}

	// Convert list in array by calling toArray() method and match against what
	// should be there
	String[] orgsNavTabs = mainNavText.toArray(new String[] {});

	// Convert list from orgs navigation tab to deep string
	String orgsNavTabsArray = Arrays.deepToString(orgsNavTabs);

	// Convert list in constants array to deep string
	String mainNavTabsConstantsFile = Arrays.deepToString(mainNavTabsOrg1479);

	// Remove the commas and the spaces on constants nav string array
	String mainNavTabsConstantsFile_NoCommas = mainNavTabsConstantsFile.replaceAll(",", "");
	String mainNavTabsConstantsFile_Final = mainNavTabsConstantsFile_NoCommas.replaceAll("\\s", "");

	// Remove the spaces on the orgs navigation tabs
	String orgsNavTabs_Final = orgsNavTabsArray.replaceAll("\\s", "");

	// Verify that the two string arrays are equal
	if (orgsNavTabs_Final.equals(mainNavTabsConstantsFile_Final)) {
	    return true;
	}
	return false;
    }

    // Verify navigation tabs for org 1
    public boolean verifyAdminMainNavTabsOrg1() throws InterruptedException {

	Thread.sleep(SLEEP_WAIT_2000);
	WebElement clickOrgDropDownLink = driver.findElement(orgDropDownLink);
	clickOrgDropDownLink.click();
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement clickOrgLink = driver.findElement(orgSelectionLink);
	clickOrgLink.click();
	Thread.sleep(SLEEP_WAIT_2000);

	// Get all the elements for the top main navigation tabs
	List<WebElement> allElements = driver.findElements(By.cssSelector("#main-navigation"));

	// Create a new array to store the text value of each element
	List<Object> mainNavText = new ArrayList<>();

	// Iterating through elements list and get text and insert in optionsText list
	for (WebElement element : allElements) {
	    mainNavText.add(element.getText());
	}

	// Convert list in array by calling toArray() method and match against what
	// should be there
	String[] orgsNavTabs = mainNavText.toArray(new String[] {});

	// Convert list from orgs navigation tab to deep string
	String orgsNavTabsArray = Arrays.deepToString(orgsNavTabs);

	// Convert list in constants array to deep string
	String mainNavTabsConstantsFile = Arrays.deepToString(mainNavTabsOrg1);

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

}
