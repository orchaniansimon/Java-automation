package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.ContactSubscribeToEmailCampaign_V2;
import PageObjects.SignInPage;

public class ContactSubscribeToEmailCampaignTest_V2 extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyCreateContactViaSocialTab(String username, String password) throws InterruptedException {
	System.out.println("Subscribe to email campaign for contact and verify");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	ContactSubscribeToEmailCampaign_V2 contactSubscribeToEmailCampaign_V2 = new ContactSubscribeToEmailCampaign_V2(
		driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	System.out.println("Subscribe to email campaign for new and verify - V2");
	Assert.assertTrue(contactSubscribeToEmailCampaign_V2.verifyContactSubscribeToEmailCampaign_V2());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
