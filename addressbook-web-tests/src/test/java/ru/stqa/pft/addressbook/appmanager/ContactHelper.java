package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 18.04.2016.
 */
public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactInfo() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactInfo(ContactData contactData, boolean creation) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("middlename"),contactData.getMiddlename());
    type(By.name("lastname"),contactData.getLastname());
    type(By.name("nickname"),contactData.getNickname());
    type(By.name("title"),contactData.getTitle());
    type(By.name("company"),contactData.getCompany());
    type(By.name("address"),contactData.getAddress());
    type(By.name("home"),contactData.getHomePhone());
    type(By.name("mobile"),contactData.getMobilePhone());

    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    }
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath(".//*[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("//*[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void createContact(ContactData contactData, boolean creation) {
    fillContactInfo(contactData, creation);
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element: elements){
      String name = element.findElement(By.xpath(".//td[3]")).getText();
      String lastName = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact  = new ContactData(id, name, lastName, "test1");
      contacts.add(contact);
    }
    return contacts;
  }
}
