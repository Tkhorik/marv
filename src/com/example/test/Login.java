package com.example.test;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Login {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://my.roboforex.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    goTo();
    login("tom@mail.md", "Secret12");
    
    swichtoNewCont();
    
    
    //goToUserprofiule();
    //changeSMF();
    logout();
  }

private void swichtoNewCont() {driver.get(baseUrl + "/en/");
driver.findElement(By.xpath("//div[@id='left']/div[4]/table/tbody/tr[3]/td/div/a/span/u")).click();

	// TODO Auto-generated method stub
	
}

private void changeSMF() {    
	driver.get(baseUrl + "/en/trading-account/accounts/");
driver.findElement(By.cssSelector("li.closed")).click();
driver.findElement(By.cssSelector("li.option.first")).click();
driver.findElement(By.cssSelector("button.fSubmit.likeBigButton")).click();

	// TODO Auto-generated method stub
	
}

private void goToUserprofiule() {
    driver.findElement(By.linkText("My accounts")).click();
	// TODO Auto-generated method stub
	
}

private void logout() {
	driver.findElement(By.id("t-user-logout")).click();
}

private void login(String username, String password) {
	driver.findElement(By.id("login-email")).clear();
    driver.findElement(By.id("login-email")).sendKeys(username);
    driver.findElement(By.id("login-password")).clear();
    driver.findElement(By.id("login-password")).sendKeys(password);
    driver.findElement(By.cssSelector("button.fSubmit")).click();
}

private void goTo() {
	driver.get(baseUrl + "/en/login/");
}

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alert.getText();
    } finally {
      acceptNextAlert = true;
    }
  }
}