
package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.AdminEmailRelativeCampaigns;
import PageObjects.BasePage;
import PageObjects.SignInPage;

public class AdminEmailRelativeCampaignsTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyAdminEmailCampaigns(String username, String password) throws InterruptedException {
	System.out.println("Admin / User Relative email campaigns create and verify");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	AdminEmailRelativeCampaigns adminEmailCampaigns = new AdminEmailRelativeCampaigns(driver);
	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	System.out.println("Relative email campaigns: click on create email campaign link");
	Assert.assertEquals(adminEmailCampaigns.getEmailCampaignsPage(), "Delete");

	System.out.println("Relative email campaigns: click new email campaign button");
	Assert.assertTrue(adminEmailCampaigns.createNewRelativeEmailCampaign());

	System.out.println("Relative email campaigns: verify email campaign from user perspective");
	Assert.assertTrue(adminEmailCampaigns.verifyRelativeEmailCampaignOnUser());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
