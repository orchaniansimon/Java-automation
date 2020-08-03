package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBaseSetup;

public class Utilities extends TestBaseSetup {
    private WebDriver driver;

    // Code for "wait for css elements" & "wait for link text" instead of using
    // Thread.sleeps
    public void waitForCssElement(String css) {
	WebDriverWait waitForElement = new WebDriverWait(driver, 2000);
	waitForElement.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
    }

    public void waitForElement() {
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    public void waitFluently() {
	Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
	// fluentWait.
    }

    public void waitForLinkText(String text) {
	WebDriverWait waitForNewEmail = new WebDriverWait(driver, 250);
	waitForNewEmail.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(text)));
    }

}
