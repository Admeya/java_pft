package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void GroupCreationTests() {

    app.goToGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test2", "head test2", "foot test2"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
