package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

/**
 * Created by Home on 18.04.2016.
 */
public class ContactHelper extends HelperBase {

  private Contacts contactCache = null;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void submitContactInfo() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactInfo(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void delete(ContactData contact){
    selectContactById(contact.getId());
    deleteSelectedContact();
    contactCache = null;
    returnToHomePage();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector(String.format("input[value='%s']",id))).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath(".//*[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void initContactModification(int id) {
    click(By.xpath(String.format("//input[@value='%s']/../../td[8]/a",id)));
  }

  private void initContactView(int id) {
    click(By.xpath(String.format("//input[@value='%s']/../../td[7]/a",id)));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void create(ContactData contactData, boolean creation) {
    fillContactInfo(contactData, creation);
    submitContactInfo();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initContactModification(contact.getId());
    fillContactInfo(contact, false);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }


  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastName = cells.get(1).getText();
      String name = cells.get(2).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      String address = cells.get(3).getText();

      contactCache.add(new ContactData().withId(id).withName(name).withLastName(lastName).withGroup("test1").
              withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));
    }
    return new Contacts(contactCache);
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModification(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String middleName = wd.findElement(By.name("middlename")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String nickName = wd.findElement(By.name("nickname")).getAttribute("value");
    String company = wd.findElement(By.name("company")).getAttribute("value");
    String title = wd.findElement(By.name("title")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String fax = wd.findElement(By.name("fax")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String homepage = wd.findElement(By.name("homepage")).getAttribute("value");
    String birthDay = wd.findElement(By.name("bday")).getAttribute("value");
    String birthMonth = wd.findElement(By.name("bmonth")).getAttribute("value");
    String birthYear = wd.findElement(By.name("byear")).getAttribute("value");
    String aDay = wd.findElement(By.name("aday")).getAttribute("value");
    String aMonth = wd.findElement(By.name("amonth")).getAttribute("value");
    String aYear = wd.findElement(By.name("ayear")).getAttribute("value");
    String address2 = wd.findElement(By.name("address2")).getAttribute("value");
    String phone2 = wd.findElement(By.name("phone2")).getAttribute("value");
    String notes = wd.findElement(By.name("notes")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withName(firstName).withMiddleName(middleName)
            .withLastName(lastName).withNickName(nickName).withCompany(company).withTitle(title)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withFaxPhone(fax)
            .withEmail(email).withEmail2(email2).withEmail3(email3).withHomePage(homepage)
            .withBirthdate(allDate(birthDay, birthMonth, birthYear)).withAnniversary(allDate(aDay, aMonth, aYear)).withAddress2(address2).withPhone2(phone2).withNotes(notes).withAddress(address);
  }

  public String allDate(String day, String month, String year){
    return day + ". " + month.replaceFirst("[\\D]{1}", month.substring(0,1).toUpperCase()) + " " + year;
  }

  public String infoFromViewForm(ContactData contact) {
    initContactView(contact.getId());
    String allStrings = wd.findElement(By.xpath(".//*[@id = 'content']")).getText();
    return allStrings;
  }


}
