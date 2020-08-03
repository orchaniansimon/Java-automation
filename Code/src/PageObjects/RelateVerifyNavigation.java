
package PageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;

public class RelateVerifyNavigation implements Initializations {
    private WebDriver driver;

    public RelateVerifyNavigation(WebDriver driver) {
	this.driver = driver;
    }

    // Goto administration --> suggested posts
    public Boolean verifyRelateHeaderNavigation(String automation) throws InterruptedException {

	// Get all elements in the menu for Relate
	WebElement getRelateTab = driver.findElement(clickRelateTab);
	getRelateTab.click();
	Thread.sleep(SLEEP_WAIT_2000);

	// Get all the elements for the relate main navigation tabs
	List<WebElement> allElements = driver.findElements(By.cssSelector("getRelateNavigationBar"));

	// Create a new array to store the text value of each element
	List<Object> relateNavText = new ArrayList<>();

	// Iterating through elements list and get text and insert in relate nav text list
	for (WebElement element : allElements) {
	    relateNavText.add(element.getText());
	}

	// Convert list in array by calling toArray() method and match against what
	// should be there
	String[] relateNavigationTabs = relateNavText.toArray(new String[] {});

	// Convert list from Relate navigation tab to deep string
	String relateNavTabsArray = Arrays.deepToString(relateNavigationTabs);

	// Convert list in constants array to deep string
	String relateNavTabsConstantsFile = Arrays.deepToString(relateNavTabs);

	// Remove the commas and the spaces on constants nav string array
	String relateNavTabsConstantsFile_NoCommas = relateNavTabsConstantsFile.replaceAll(",", "");
	String relateNavTabsConstantsFile_Final = relateNavTabsConstantsFile_NoCommas.replaceAll("\\s", "");

	// Remove the spaces on the Relate navigation tabs
	String relateNavTabs_Final = relateNavTabsArray.replaceAll("\\s", "");

	// Verify that the two string arrays are equal
	if (relateNavTabs_Final.equals(relateNavTabsConstantsFile_Final)) {
	    return true;
	}
	return false;
    }
}
