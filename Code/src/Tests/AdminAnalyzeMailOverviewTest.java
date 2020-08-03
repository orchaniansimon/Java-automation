package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.AdminAnalyzeMailOverview;
import PageObjects.BasePage;
import PageObjects.SignInPage;

public class AdminAnalyzeMailOverviewTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyAdminAnalyzeMailOverview(String username, String password) throws InterruptedException {
	System.out.println("Admin check top navigation menu choices");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	AdminAnalyzeMailOverview adminAnalyzeMailOverview = new AdminAnalyzeMailOverview(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	System.out.println("Admin check top nav menu choices: verifying the settings menu options ");
	Assert.assertTrue(adminAnalyzeMailOverview.verifyAdminAnalyzeMailOverview());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
