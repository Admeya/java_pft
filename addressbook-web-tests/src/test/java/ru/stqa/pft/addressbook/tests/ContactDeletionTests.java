package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test(enabled = false)
  public void testContactDeletion() {
    app.goTo().groupPage();
    if (! app.group().isThereAGroup()){
      app.group().create(new GroupData().withName("test1").withHeader("test1").withFooter("test1"));
    }
    app.goTo().goToHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.goTo().goToAddNewContact();
      app.getContactHelper().createContact(new ContactData("Игорь", "Сергеевич", "Заляутдинов", "Zollas", "специалист", "Dosker", "Москва, 5 Пролетарский проезд, д. 17, кв. 1", "523-43-65", "89908761223","test1"),true);
    }
    app.goTo().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().deleteSelectedContact();
    app.goTo().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
