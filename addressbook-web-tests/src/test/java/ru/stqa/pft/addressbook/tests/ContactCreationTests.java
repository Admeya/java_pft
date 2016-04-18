package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void ContactCreationTests() {
    app.getNavigationHelper().goToAddNewContact();
    app.getContactHelper().fillContactInfo(new ContactData("Игорь", "Сергеевич", "Заляутдинов", "Zollas", "специалист", "Dosker", "Москва, 5 Пролетарский проезд, д. 17, кв. 1", "523-43-65", "89908761223"));
    app.getContactHelper().submitContactInfo();
  }

}
