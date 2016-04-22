package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Home on 19.04.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testGroupModification(){
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().selectContact();

    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactInfo(new ContactData("Антуан", "Сергеевич", "Заляутдинов", "Zollas", "специалист", "Dosker", "Москва, 5 Пролетарский проезд, д. 17, кв. 1", "523-43-65", "89908761223", null), false);
    app.getContactHelper().submitContactModification();
  }
}