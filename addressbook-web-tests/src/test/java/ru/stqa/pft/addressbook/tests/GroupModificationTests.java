package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Home on 19.04.2016.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification(){
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", "test1", "test1"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test2", "test1", "test1"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
