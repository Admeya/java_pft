package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

/**
 * Created by Home on 01.06.2016.
 */
public class ContactDeleteFromGroupTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size()==0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
    if (app.db().contacts().size()==0) {
      app.goTo().addNewContact();
      app.contact().create(new ContactData().withName("Игорь").withMiddleName("Сергеевич").withLastName("Deletion").withNickName("Zollas").withTitle("специалист").withCompany("Dosker").withAddress("Москва, 5 Пролетарский проезд, д. 17, кв. 1").withHomePhone("523-43-65").withMobilePhone("89908761223"), true);
    }
  }

  @Test
  public void testContactDeleteFromGroup(){
    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();
    ContactData randomContact = contacts.iterator().next();
    GroupData randomGroup = groups.iterator().next();

    if (!(app.contact().isContactInGroup(randomContact,randomGroup))){
      app.goTo().homePage();
      app.contact().selectContactById(randomContact.getId());
      app.contact().selectRandomGroup(randomGroup);
      app.contact().submitAddToGroup();
      contacts = app.db().contacts();
      for(ContactData contact: contacts){
        if (contact.getId() == randomContact.getId()){
          randomContact = contact;
          break;
        }
      }
      assertThat(app.contact().isContactInGroup(randomContact, randomGroup), equalTo(true));
      app.goTo().homePage();
      app.contact().findGroup(randomGroup);
      app.contact().selectContactById(randomContact.getId());
      app.contact().submitRemoveFromGroup();
      app.goTo().homePage();
      contacts = app.db().contacts();
      for(ContactData contact:contacts){
        if (contact.getId() == randomContact.getId()){
          randomContact = contact;
          break;
        }
      }
      assertThat(app.contact().isContactInGroup(randomContact, randomGroup), equalTo(false));
    }
  }
}
