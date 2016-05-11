package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

/**
 * Created by Home on 18.04.2016.
 */
public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @AfterSuite
  public void tearDown() {
    app.stop();
  }


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

}
