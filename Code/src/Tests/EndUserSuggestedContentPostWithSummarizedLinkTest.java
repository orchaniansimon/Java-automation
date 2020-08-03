package Tests;

	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass; 
	
    import org.testng.annotations.Parameters;
    import org.testng.annotations.Test;

    import Base.TestBaseSetup;
    import PageObjects.BasePage;
    import PageObjects.EndUserSuggestedContentPostWithSummarizedLink;
    import PageObjects.SignInPage;
    
    
    
	public class EndUserSuggestedContentPostWithSummarizedLinkTest extends TestBaseSetup {   
		
		
		private WebDriver driver;
		private SignInPage signInPage;
		private BasePage basePage;
		

		@BeforeClass
		public void setUp() 
		{
			driver = getDriver();
		}
 
		
		
		
		@Test
		@Parameters({ "stagingUsername", "stagingPassword" , "summarizedLinkURL"})  
		public void verifyEndUserSuggestedPost(String username, String password, String summarizedLinkURL) throws InterruptedException {    
			System.out.println("Admin / User Suggested Post with summarized link verification");    
			
			// Instantiate sign in object
			basePage = new BasePage(driver); 
			signInPage = basePage.clickSignInBtn();  
			
			// Instantiate admin hierarchy objects 
			EndUserSuggestedContentPostWithSummarizedLink endUserSuggestedContentPostWithSummarizedLink = new EndUserSuggestedContentPostWithSummarizedLink(driver);  
			
			Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");			 
	  
			//Check the email form
			System.out.println("Suggested Post with summarized link: verifying new library post link and entering summarized url"); 
			Assert.assertEquals(endUserSuggestedContentPostWithSummarizedLink.clickOnNewLibraryPostLink(summarizedLinkURL), "Content was successfully suggested."); 
			
			System.out.println("Suggested Post with summarized link: verifying the user suggested post page");
			Assert.assertTrue(endUserSuggestedContentPostWithSummarizedLink.verifyUserSuggestedPost().contains("User suggested post"));   
			
			System.out.println("Suggested Post with summarized link: verifying the user suggested page post publish and that the count of posts");
			Assert.assertTrue(endUserSuggestedContentPostWithSummarizedLink.verifyUserSuggestedPostPublish()); 

		
			driver.close();
		
		}

		
		@AfterTest
		public void tearDown() {
			driver.quit();
		}
	}

	
	
	

	
	
	
	
	
	
	

	
	
	
	
	
	
	
	