package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.RelateVerifyNavigation;
import PageObjects.SignInPage;



public class RelateNewConversationTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    
    @BeforeClass
    public void setUp() {
	driver = getDriver();
    }

    
    @Test
    @Parameters({ "stagingUsername", "stagingPassword", "automation" })
    public void verifyRelateHeaderNavigation(String username, String password, String automation)
	    throws InterruptedException {
	System.out.println("Admin / User Suggested Post with summarized link verification");

	// Instantiate sign in object
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	// Instantiate admin hierarchy objects
	RelateVerifyNavigation relateNewConversation = new RelateVerifyNavigation(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	System.out.println("Suggested Post with summarized link: verifying new library post link and entering summarized url");
	Assert.assertEquals(relateNewConversation.verifyRelateHeaderNavigation(automation),"Content was successfully suggested.");

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
