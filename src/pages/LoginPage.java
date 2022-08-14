package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
/*	public WebElement email = driver.findElement(By.id("usernameInput-input"));
	public WebElement password = driver.findElement(By.name("password"));
	public WebElement loginButton = driver.findElement(By.id("signIn"));
	public WebElement globalErr = driver.findElement(By.xpath("/html/body/div/div/main/div/div[1]/h1"));
	public WebElement genaralErr = driver.findElement(By.xpath("//*[contains(@class,'ErrorText')]"));
// driver is null so we can not use this way
*/
	
	@FindBy(id = "usernameInput-input")
	public WebElement email;
	
	@FindBy(name = "password")
	public WebElement password;
	
	@FindBy(id = "signIn")
	public WebElement loginButton;
	
	@FindBy(xpath = "/html/body/div/div/main/div/div[1]/h1")
	public WebElement globalErr;
	
	@FindBy(xpath = "//*[contains(@class,'ErrorText')]")
	public WebElement genaralErr;
	
	
	
	
	public void openBrowser() throws IOException{
		FileInputStream f = new FileInputStream("E:\\QA automation\\testing\\prop1.properties");
		Properties prop = new Properties();
		prop.load(f);
				
		String browser = prop.getProperty("browser"); //we will read this value from data file --. excel, properties
				
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\\\QA automation\\\\SeleniumJars\\\\geckodriver.exe");
			driver = new FirefoxDriver();
			}
		else if(browser.equals("Chrome")) {		
			System.setProperty("webdriver.chrome.driver", "E:\\QA automation\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
			}
		
		PageFactory.initElements(driver, this); // this is for findby for runnig with out that we cannot get element 
	}
	
	
	public void openLoginPage(){
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=71zIZnTyrPU&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiNzF6SVpuVHlyUFUiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY1NDI3NjgwMSwiaWF0IjoxNjU0Mjc1NjAxLCJqdGkiOiI5OTYzY2E5My0zMzlmLTRlNjMtOWY0Yy1hNjI2NDE1Nzc4OTMiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.oQPBGp9Nb6ODs_Hc1oykzuEOR0pfCk3i0AvUZhrvgDIpmGfTf-j5jUmsWoOcvAmu_k3xLGmrN00q_Ar_mOhq8Y-gkwarxPIUrnM7WPVkqRXnrMRVwapqS7yElGthk0iZSEliM32MKRZ3Y359PQKxyWRAjFd61OfyrJD1UZQi0mKMXF25z9dOPbNDYndk8h5_6hLLb6tapuVGnh5rbQtY6VhU1K9aFTnvuA-vDcOnLBHEAFaPRMokWs8ACJlRBthWuifxdFl_u-uZ8u0u0VNJEXbxcdjS34JI1PtP7sAWxca465p6KwxxTNCRo6dVgzdBzdNO2BKUjdaug9iSUlD7Ig&preferred_environment=");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void closeBrowse(){
		driver.quit();
	}
	
	public void login(String a, String b) throws InterruptedException {
		email.sendKeys(a);
		password.sendKeys(b);
		loginButton.click(); 
		Thread.sleep(3000);	
	}
	
	public String readGlobalErr() {
		String getError = globalErr.getText();
		System.out.println(getError);
		return getError;		
	}
	
	public String readErr() {
		String getError = genaralErr.getText();
		System.out.println(getError);
		return getError;
	}
}
