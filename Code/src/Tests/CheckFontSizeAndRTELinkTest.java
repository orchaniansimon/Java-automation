package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.CheckFontSizeAndRTELink;
import PageObjects.SignInPage;

public class CheckFontSizeAndRTELinkTest extends TestBaseSetup {

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

	CheckFontSizeAndRTELink checkFontSizeAndRTELink = new CheckFontSizeAndRTELink(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// verify the link, page, tiles, and filter link
	System.out.println("Verifying composing and scheduling email");
	Assert.assertTrue(checkFontSizeAndRTELink.verifyFontSizeAndRTELinks());

	driver.close();
    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }

}
