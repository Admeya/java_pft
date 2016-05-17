package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1").withHeader("test1").withFooter("test1"));
    }
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.goTo().addNewContact();
      app.contact().create(new ContactData().withName("Игорь").withMiddleName("Сергеевич").withLastName("Deletion").withNickName("Zollas").withTitle("специалист").withCompany("Dosker").withAddress("Москва, 5 Пролетарский проезд, д. 17, кв. 1").withHomePhone("523-43-65").withMobilePhone("89908761223").withGroup("test1"), true);
    }
  }

  @Test
  public void testContactDeletion() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
