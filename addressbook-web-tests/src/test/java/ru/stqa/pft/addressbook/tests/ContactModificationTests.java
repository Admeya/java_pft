package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Home on 19.04.2016.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size()==0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1").withHeader("test1").withFooter("test1"));
    }
    if (app.db().contacts().size()==0) {
        app.goTo().addNewContact();
        app.contact().create(new ContactData().withName("Игорь").withMiddleName("Сергеевич").withLastName("Modification").withNickName("Zollas").withTitle("специалист").withCompany("Dosker").withAddress("Москва, 5 Пролетарский проезд, д. 17, кв. 1").withHomePhone("523-43-65").withMobilePhone("89908761223").withGroup("test1"), true);
    }
  }

  @Test
  public void testContactModification(){
    app.goTo().homePage();
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("Авраам").withLastName("Невский").withGroup("test1").withPhoto(new File("src/test/resources/image.jpg"));
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
