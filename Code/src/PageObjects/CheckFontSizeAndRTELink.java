package PageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Initializations;

public class CheckFontSizeAndRTELink implements Initializations {
    private WebDriver driver;

    public CheckFontSizeAndRTELink(WebDriver driver) {
	this.driver = driver;
    }

    // Goto Email library page
    public Boolean verifyFontSizeAndRTELinks() throws InterruptedException {

	WebElement getMailLink = driver.findElement(mailHeaderLink);
	getMailLink.click();

	WebDriverWait waitForMailPage = new WebDriverWait(driver, 10);
	waitForMailPage.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".container.container-main > div.row > div.home-main-container")));

	WebElement clickComposeEmailButton = driver.findElement(composeEmailButton);
	clickComposeEmailButton.click();

	Thread.sleep(SLEEP_WAIT_2000);

	WebElement clickWriteOwnEmailPanel = driver.findElement(writeOwnEmailPanel);
	clickWriteOwnEmailPanel.click();

	WebDriverWait waitForForm = new WebDriverWait(driver, 5);
	waitForForm.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".recipients-search > form > div > div > div > input")));

	// Enter a contact in the new email popover
	WebElement recipientField = driver.findElement(By.cssSelector(".recipients-search > form input"));

	// enter contact name into form field
	recipientField.sendKeys(emailContactName);

	// tab to select contact
	recipientField.sendKeys(Keys.TAB);
	Thread.sleep(SLEEP_WAIT_2000);

	// get the element for the selected contact
	WebElement getContact = driver.findElement(selectContact);

	// enter to choose the contact
	getContact.sendKeys("\n");

	WebElement getSubjectField = driver.findElement(getNewEmailSubject);
	getSubjectField.click();

	WebElement getComposeOwnEmailSubjectField = driver.findElement(composeOwnEmailSubjectField);
	getComposeOwnEmailSubjectField.sendKeys("Automation");

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	WebElement getFontSizeIcon = driver.findElement(fontSizeIcon);
	WebElement getRTELinkIcon = driver.findElement(RTELinkIcon);
	getFontSizeIcon.click();

	List<WebElement> allElements = driver.findElements(By.cssSelector(".rte-bar.clearfix > .btn-group.font-size-control > div > ul"));

	// Create a new array to store the text value of each element
	List<Object> fontSizeText = new ArrayList<>();

	// Iterating through elements list and get text and insert in optionsText list
	for (WebElement element : allElements) {
	    fontSizeText.add(element.getText());
	    System.out.println(fontSizeText);
	}

	if (getFontSizeIcon.isDisplayed() && getRTELinkIcon.isDisplayed()) {
	    return true;
	}
	return false;
    }

    public void method1() {
	// TODO Auto-generated method stub
    }

    public void method2() {
	// TODO Auto-generated method stub
    }
}
