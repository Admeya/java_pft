package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Home on 18.04.2016.
 */
public class NavigationHelper {
  private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void goToGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void goToAddNewContact() {
    new Actions(wd).doubleClick(wd.findElement(By.linkText("add new"))).build().perform();
  }

  public void goToHomePage() {
      wd.findElement(By.linkText("home")).click();
  }
}
