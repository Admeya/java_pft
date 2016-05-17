package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void ContactCreationTests() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.goTo().addNewContact();
    ContactData contact = new ContactData().withName("Авраам").withLastName("Линкольн").withGroup("test1");
    app.contact().create(contact,true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts  after = app.contact().all();
    assertThat(after, equalTo(
             before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
