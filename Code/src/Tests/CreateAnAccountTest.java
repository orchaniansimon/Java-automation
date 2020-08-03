package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.CreateAccountPage;
import PageObjects.SignInPage;

public class CreateAnAccountTest extends TestBaseSetup {
    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;
    private CreateAccountPage createAccountPage;

    @Test
    public void verifyCreateAnAccountPage() {
	System.out.println("Create An Account page test...");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	Assert.assertTrue(createAccountPage.verifyPageTitle(), "Page title not matching");
	Assert.assertTrue(createAccountPage.verifyCreateAccountPageText(), "Page text not matching");
    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }

}
