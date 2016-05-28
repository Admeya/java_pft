package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name="addressbook")
public class ContactData {
  @Id
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name="firstname")
  private String firstname;
  private String middlename;
  @Expose
  @Column(name="lastname")
  private String lastname;
  private String nickname;
  private String title;
  private String company;
  @Type(type="text")
  private String address;
  @Column(name="home")
  @Type(type="text")
  private String homePhone;
  @Column(name="mobile")
  @Type(type="text")
  private String mobilePhone;
  @Column(name="work")
  @Type(type="text")
  private String workPhone;
  @Column(name="fax")
  @Type(type="text")
  private String faxPhone;
  @Transient
  private String allPhones;
  @Type(type="text")
  private String email;
  @Type(type="text")
  private String email2;
  @Type(type="text")
  private String email3;
  @Transient
  private String allEmails;
  @Type(type="text")
  private String homePage;
  @Transient
  private String birthdate;
  @Transient
  private String anniversary;
  @Type(type="text")
  private String address2;
  @Type(type="text")
  private String phone2;
  @Type(type="text")
  private String notes;
  @Expose
  @Transient
  private String group;
  @Column(name="photo")
  @Transient
  private String photo;

  public int getId() { return id; }
  public String getGroup() {
    return group;
  }
  public String getFirstname() {
    return firstname;
  }
  public String getMiddlename() {
    return middlename;
  }
  public String getLastname() {
    return lastname;
  }
  public String getNickname() {
    return nickname;
  }
  public String getTitle() {
    return title;
  }
  public String getCompany() {
    return company;
  }
  public String getAddress() { return address; }
  public String getHomePhone() {
    return homePhone;
  }
  public String getMobilePhone() {
    return mobilePhone;
  }
  public String getWorkPhone() { return workPhone; }
  public String getAllPhones() { return allPhones; }
  public String getEmail() { return email; }
  public String getEmail2() { return email2; }
  public String getEmail3() { return email3; }
  public String getAllEmails() { return allEmails; }
  public String getFaxPhone() { return faxPhone; }
  public String getHomePage() { return homePage; }
  public String getBirthdate() { return birthdate; }
  public String getAnniversary() { return anniversary; }
  public String getAddress2() { return address2; }
  public String getPhone2() { return phone2; }
  public String getNotes() { return notes; }
  public File getPhoto() { return new File(photo); }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withName(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withMiddleName(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastName(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickName(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withFaxPhone(String faxPhone) {
    this.faxPhone = faxPhone;
    return this;
  }

  public ContactData withHomePage(String homePage) {
    this.homePage = homePage;
    return this;
  }

  public ContactData withBirthdate(String birthdate) {
    this.birthdate = birthdate;
    return this;
  }

  public ContactData withAnniversary(String anniversary) {
    this.anniversary = anniversary;
    return this;
  }

  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactData withPhone2(String phone2) {
    this.phone2 = phone2;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }


}
