package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;

public class MailLinkClickRate extends Utilities implements Initializations {
    private WebDriver driver;

    public MailLinkClickRate(WebDriver driver) {
	this.driver = driver;
    }

    // Goto Email library page
    public boolean verifyMailClickLinkRate() throws InterruptedException {

	WebElement mailLink = driver.findElement(mailHeaderLink);
	mailLink.click();

	// Wait for css element
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement getclickPerformanceDropDown = driver.findElement(clickPerformanceDropDown);
	getclickPerformanceDropDown.click();
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement getMailPerformanceActivityLink = driver.findElement(mailPerformanceActivityLink);
	getMailPerformanceActivityLink.click();

	// Wait for the element
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement getMailLinkClickRate = driver.findElement(mailLinkClickRate);
	getMailLinkClickRate.getText();
	System.out.println("Mail Link Click Rate = " + getMailLinkClickRate.getText());

	String mailLinkClickRateText = getMailLinkClickRate.getText();
	int percentMailClickRate = Integer.parseInt(mailLinkClickRateText.substring(0, 1));
	System.out.println("Mail Link Click Rate = " + percentMailClickRate);

	if (percentMailClickRate > 0) {
	    return true;
	}
	return false;
    }


}
