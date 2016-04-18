package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void GroupCreationTests() {

    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test2", "head test2", "foot test2"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
