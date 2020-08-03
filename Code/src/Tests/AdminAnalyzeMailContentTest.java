package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.AdminAnalyzeMailContent;
import PageObjects.BasePage;
import PageObjects.SignInPage;

public class AdminAnalyzeMailContentTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyAdminAnalyzeMailContent(String username, String password) throws InterruptedException {
	System.out.println("Admin check top navigation menu choices");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	AdminAnalyzeMailContent adminAnalyzeMailContent = new AdminAnalyzeMailContent(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	System.out.println("Admin check top nav menu choices: verifying the settings menu options ");
	Assert.assertTrue(adminAnalyzeMailContent.verifyAdminAnalyzeMailContent());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
