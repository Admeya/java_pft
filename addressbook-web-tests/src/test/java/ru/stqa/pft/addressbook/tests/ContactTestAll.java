package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

/**
 * Created by Home on 18.05.2016.
 */
public class ContactTestAll extends TestBase{
  @Test
  public void testContactAll(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    String contactInfoFromViewForm = app.contact().infoFromViewForm(contact).replaceAll("\\n","").replaceAll("\\s\\(\\d\\d\\)","").replaceAll("\\s\\([a-z.]*\\)","");
    app.goTo().homePage();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contactInfoFromViewForm, equalTo(mergeInfo(contactInfoFromEditForm)));


  }

  private String mergeInfo(ContactData contact) {
    String FIO = Arrays.asList(contact.getFirstname(), contact.getMiddlename(), contact.getLastname())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining(" "));
    String all =  Arrays.asList(FIO, contact.getNickname(), contact.getTitle(), contact.getCompany(),
            contact.getAddress(), mergePhones("H: ",contact.getHomePhone()), mergePhones("M: ",contact.getMobilePhone()),
            mergePhones("W: ",contact.getWorkPhone()), mergePhones("F: ", contact.getFaxPhone()),
            contact.getEmail(),contact.getEmail2(), contact.getEmail3(), mergeHomePage(contact.getHomePage()),
            mergeDates("Birthday ",contact.getBirthdate()), mergeDates("Anniversary ",contact.getAnniversary()),
            contact.getAddress2(), mergePhones("P: ",contact.getPhone2()), contact.getNotes())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining(""));

    return all;

  }

  public String mergePhones(String prefix, String phone){
    if (!phone.equals("")) {
      return prefix + phone;
    } else return "";
  }

  public String mergeDates(String str, String birth){
    if (!birth.equals("")) {
      return str + birth;
    } else return "";
  }

  public String mergeHomePage(String hp){
    if (!hp.equals("")) {
      return "Homepage:" + hp;
    } else return "";

  }

}
