package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

import java.io.IOException;

import static java.lang.System.getProperty;

/**
 * Created by Home on 18.04.2016.
 */
public class TestBase{

  protected final static ApplicationManager app = new ApplicationManager(getProperty("browser", BrowserType.CHROME));

  @AfterSuite
  public void tearDown() {
    app.stop();
  }


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

}
