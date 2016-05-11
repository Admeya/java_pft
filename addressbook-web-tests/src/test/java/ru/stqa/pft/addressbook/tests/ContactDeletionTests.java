package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test(enabled = false)
  public void testContactDeletion() {
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", "test1", "test1"));
    }
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().goToAddNewContact();
      app.getContactHelper().createContact(new ContactData("Игорь", "Сергеевич", "Заляутдинов", "Zollas", "специалист", "Dosker", "Москва, 5 Пролетарский проезд, д. 17, кв. 1", "523-43-65", "89908761223","test1"),true);
    }
    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().deleteSelectedContact();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
