package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * Created by Home on 18.04.2016.
 */
public class HelperBase {

  protected ApplicationManager app;
  protected WebDriver wd;

  public HelperBase(ApplicationManager app) {
    this.app = app;
    this.wd = app.getDriver();
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  public void type(By locator, String text) {
    if (text != null) {
      click(locator);
      String existingText =  wd.findElement(locator).getAttribute("value");
      if (!existingText.equals(text)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  protected void attach(By locator, File file) {
    if (file != null) {
        wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }
  }

  protected boolean isElementPresent(By locator) {

    try{
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e){
      return false;
    }
  }
}
