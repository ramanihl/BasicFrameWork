package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
		
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  lp.openBrowser();
	  lp.openLoginPage();
	  }

  @AfterMethod
  public void afterMethod() {
	  lp.closeBrowse();
  }
  
  @Test (priority = 1)
  public void loginWithWrongEmailPasswordTest() throws InterruptedException {
	  lp.login(df.wrongemail,df.wrongpassword);	
	  Assert.assertEquals(df.WrongEmailPassErr, lp.readGlobalErr());
	  }
 
  @Test (priority = 2)
  public void loginWithEmptyEmailTest() throws InterruptedException {
	 lp.login("",df.wrongpassword);
	 Assert.assertEquals(df.EmptyEmailErr, lp.readErr());
	}
 
  @Test (priority = 3)
  public void loginWithEmptyPasswordTest() throws InterruptedException {
	 lp.login(df.wrongemail,"");
	 Assert.assertEquals(df.EmptyPassErr, lp.readErr());
	}

  @Test (priority = 4)
  public void loginWithSpecialCharEmailTest() throws InterruptedException {
	  lp.login(df.SpecialcharEmail,df.wrongpassword);
	  Assert.assertEquals(df.SpecialEmailErr, lp.readErr());
	}


}
