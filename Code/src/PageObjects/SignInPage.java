
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;
import Utilities.Properties;

public class SignInPage implements Initializations, Properties {

    private WebDriver driver;

    private static final String LINKEDIN_URL = "linkedin.com"; 

    private By username = By.cssSelector("#username");
    private By password = By.cssSelector("#password");
    private By errorMsgTxt = By.id("errormsg_0_Passwd");
    private By linkedInSignIn = By.cssSelector(".login__form_action_container--multiple-actions > button");

    public SignInPage(WebDriver driver) {
	this.driver = driver;
    }

    public String getSignInPageTitle() {
	String pageTitle = driver.getTitle();
	return pageTitle;
    }

    public boolean verifySignInPageTitle() {
	String expectedTitle = "LinkedIn Login";
	return getSignInPageTitle().contains(expectedTitle);
    }

    public boolean verifySignInPageText() {
	String element = driver.getPageSource();
	String expectedPageText = "New to LinkedIn?";
	return element.contains(expectedPageText);
    }

    public boolean verifyLinkedInUrl() {
	String element = driver.getCurrentUrl();
	return element.contains(LINKEDIN_URL);
    }

    public boolean verifySignIn(String Username, String Password) {
	enterUsername(Username);
	enterPassword(Password);
	clickOnSignIn();
	return true;
    }

    public void enterUsername(String userName) {
	WebElement emailTextBox = driver.findElement(username);
	if (emailTextBox.isDisplayed())
	    emailTextBox.sendKeys(userName);
    }

    public void enterPassword(String passWord) {
	WebElement passwordTextBox = driver.findElement(password);
	if (passwordTextBox.isDisplayed())
	    passwordTextBox.sendKeys(passWord);
    }

    public void clickOnSignIn() {
	WebElement signInBtn = driver.findElement(linkedInSignIn);
	if (signInBtn.isDisplayed())
	    signInBtn.click();
    }

    public String getErrorMessage() {
	String strErrorMsg = null;
	WebElement errorMsg = driver.findElement(errorMsgTxt);
	if (errorMsg.isDisplayed() && errorMsg.isEnabled())
	    strErrorMsg = errorMsg.getText();
	return strErrorMsg;
    }

}