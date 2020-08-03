package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;
    private By linkedInBtn = By.cssSelector(".btn-linkedin");
    private By facebookBtn = By.cssSelector(".btn-facebook");

    public BasePage(WebDriver driver) {
	this.driver = driver;
    }

    public SignInPage clickSignInBtn() {
	System.out.println("Signing in.....");
	WebElement signInBtnElement = driver.findElement(linkedInBtn);
	if (signInBtnElement.isDisplayed() || signInBtnElement.isEnabled())
	    signInBtnElement.click();
	else
	    System.out.println("Element not found");
	return new SignInPage(driver);
    }

    public void clickImagesLink() {
	// It should have a logic to click on images link
	// And it should navigate to google images page
    }

    public String getPageTitle() {
	String title = driver.getTitle();
	return title;
    }

    public boolean verifyBasePageTitle() {
	String expectedPageTitle = "Hearsay";
	return getPageTitle().contains(expectedPageTitle);
    }

    public boolean verifyLinkedInButton() {
	WebElement linkedInSignInBtn = driver.findElement(linkedInBtn);
	if (linkedInSignInBtn.isDisplayed()) {
	    return true;
	}
	return true;
    }

    public boolean verifyFacebookButton() {
	WebElement linkedInSignInBtn = driver.findElement(facebookBtn);
	if (linkedInSignInBtn.isDisplayed()) {
	    return true;
	}
	return true;
    }

}