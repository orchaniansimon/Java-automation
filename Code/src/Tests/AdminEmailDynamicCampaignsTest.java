package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.AdminEmailDynamicCampaigns;
import PageObjects.BasePage;
import PageObjects.SignInPage;

public class AdminEmailDynamicCampaignsTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyAdminEmailCampaigns(String username, String password) throws InterruptedException {
	System.out.println("Admin / User Dynamic email campaigns create and verify");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	AdminEmailDynamicCampaigns adminEmailCampaigns = new AdminEmailDynamicCampaigns(driver);
	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	System.out.println("Dynamic email campaigns: click on create email campaign link");
	Assert.assertEquals(adminEmailCampaigns.getEmailCampaignsPage(), "Delete");

	System.out.println("Dynamic email campaigns: click new email campaign button");
	Assert.assertTrue(adminEmailCampaigns.createNewDynamicEmailCampaign());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
