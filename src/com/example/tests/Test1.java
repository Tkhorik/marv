package com.example.tests;


import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Test1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.roboforex.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("#tu-login > span")).click();
    driver.findElement(By.id("tua-email")).clear();
    driver.findElement(By.id("tua-email")).sendKeys("tom@mail.md");
    driver.findElement(By.id("tua-password")).clear();
    driver.findElement(By.id("tua-password")).sendKeys("Secret12");
    driver.findElement(By.id("tua-submit")).click();
    driver.findElement(By.id("t-user-logout")).click();
    driver.findElement(By.linkText("«За повышение финансовой грамотности населения» 2012 г")).click();
    assertTrue(isElementPresent(By.cssSelector("h1")));
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
