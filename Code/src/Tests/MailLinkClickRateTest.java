package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.MailLinkClickRate;
import PageObjects.SignInPage;

public class MailLinkClickRateTest extends TestBaseSetup {
    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyEmailLibrary(String username, String password) throws InterruptedException {
	System.out.println("Email Library page");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	MailLinkClickRate mailLinkClickRate = new MailLinkClickRate(driver);
	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// verify the hierarchy link, page, and workspace and hierarchy manager buttons
	Assert.assertTrue(mailLinkClickRate.verifyMailClickLinkRate());

	driver.close();
    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }

}
