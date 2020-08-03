package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.ComposeAndScheduleEmail;
import PageObjects.SignInPage;

public class ComposeAndScheduleEmailTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyComposeAndScheduleEmail(String username, String password) throws InterruptedException {
	System.out.println("Compose and Schedule Email test");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	ComposeAndScheduleEmail composeScheduleEmail = new ComposeAndScheduleEmail(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// verify the link, page, tiles, and filter link
	System.out.println("Verifying composing and scheduling email");
	Assert.assertTrue(composeScheduleEmail.verifyComposeScheduleEmail());

	System.out.println("Verifying unscheduling email");
	Assert.assertTrue(composeScheduleEmail.unScheduleEmail());

	driver.close();
    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }

}
