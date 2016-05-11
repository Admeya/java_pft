package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Home on 19.04.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test(enabled = false)
  public void testGroupModification(){
    app.goTo().groupPage();
    if (! app.group().isThereAGroup()){
      app.group().create(new GroupData("test1", "test1", "test1"));
    }
    app.goTo().goToHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.goTo().goToAddNewContact();
      app.getContactHelper().createContact(new ContactData("Авраам", "Линкольн", "test1"),true);
      app.getContactHelper().submitContactInfo();
    }
    app.goTo().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    ContactData contact = new ContactData(before.get(before.size()-1).getId(),"Авраам", "Невский", "test1");
    app.getContactHelper().initContactModification(before.size());
    app.getContactHelper(). createContact(contact, false);
    app.getContactHelper().submitContactModification();
    app.goTo().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
