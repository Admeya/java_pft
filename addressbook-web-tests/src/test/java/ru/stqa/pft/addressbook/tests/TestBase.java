package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

/**
 * Created by Home on 18.04.2016.
 */
public class TestBase {

  protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @AfterMethod
  public void tearDown() {
    app.stop();
  }


  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

}
