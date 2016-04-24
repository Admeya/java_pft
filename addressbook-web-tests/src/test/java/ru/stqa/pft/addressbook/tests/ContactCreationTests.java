package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase {


  @Test
  public void ContactCreationTests() {
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", "test1", "test1"));
    }
    app.getNavigationHelper().goToAddNewContact();
    app.getContactHelper().createContact(new ContactData("Игорь", "Сергеевич", "Заляутдинов", "Zollas", "специалист", "Dosker", "Москва, 5 Пролетарский проезд, д. 17, кв. 1", "523-43-65", "89908761223","test1"),true);
  }

}
