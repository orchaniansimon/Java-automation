
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Initializations;
import Utilities.Properties;

public class AdminHierarchy implements Initializations, Properties {
    private WebDriver driver;

    public AdminHierarchy(WebDriver driver) {
	this.driver = driver;
    }

    public String getPageTitle() {
	String pageTitle = driver.getTitle();
	return pageTitle;
    }

    public boolean verifyPageTitle() {
	String expectedTitle = "Hearsay";
	return getPageTitle().contains(expectedTitle);
    }

    public boolean verifyPageText() {
	String element = driver.getPageSource();
	String expectedPageText = "Suggested Posts";
	return element.contains(expectedPageText);
    }

    public boolean verifyNavBar() {
	WebElement navBarHeader = driver.findElement(adminLink);

	if (navBarHeader.isDisplayed()) {
	    return true;
	}
	return false;
    }

    public boolean verifySecondaryNavBar() {
	WebElement secondaryNavBarHeader = driver.findElement(secondaryNavigationBar);

	if (secondaryNavBarHeader.isDisplayed()) {
	    return true;
	}
	return false;
    }

    // Goto Organization link --> Hierarchy page
    public boolean clickOnHierarchyLink() throws InterruptedException {

	WebElement organizationLink = driver.findElement(orgLink);

	// Wait for elements to be visible
	WebDriverWait waitForHierarchyPage = new WebDriverWait(driver, 15);

	if (organizationLink.isDisplayed()) {
	    organizationLink.click();

	    // Wait for the hierarchy link to be visible
	    Thread.sleep(SLEEP_WAIT_2000);
	    WebElement hierarchyLink = driver.findElement(hierarchicalLink);

	    if (hierarchyLink.isDisplayed()) {
		hierarchyLink.click();
		// Wait for the hierarchy page to be visible
		waitForHierarchyPage.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainContent")));
	    } else
		System.out.println("Element not found");
	}
	return true;
    }

    public boolean getHierarchyPage() {
	WebElement hierarchyMainPage = driver.findElement(hierarchyPage);
	if (hierarchyMainPage.isDisplayed()) {
	    return true;
	}

	return false;
    }

    public boolean getHierarchyButton() {
	WebElement hierarchyButtons = driver.findElement(hierarchyPageButtons);
	if (hierarchyButtons.isDisplayed()) {
	    return true;
	}

	return false;
    }

    public boolean getHierarchyWorkspaceButton() {
	WebElement hierarchyWorkspaceButton = driver.findElement(hierarchyWSButton);
	if (hierarchyWorkspaceButton.isDisplayed()) {
	    return true;
	}

	return false;
    }

    public boolean getSearchUsersLink() {
	WebElement searchUsersLink = driver.findElement(usersLink);
	if (searchUsersLink.isDisplayed()) {
	    return true;
	}

	return false;
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