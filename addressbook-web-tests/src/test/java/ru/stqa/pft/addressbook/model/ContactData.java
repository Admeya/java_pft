package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String homePhone;
  private final String mobilePhone;

  public String getGroup() {
    return group;
  }

  private String group;

  public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String homePhone, String mobilePhone, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.group = group;
  }

  public ContactData(String firstname, String lastname, String group) {
    this.firstname = firstname;
    this.middlename = null;
    this.lastname = lastname;
    this.nickname = null;
    this.title = null;
    this.company = null;
    this.address = null;
    this.homePhone = null;
    this.mobilePhone = null;
    this.group = group;
  }

  public ContactData(int id, String firstname, String lastname, String group) {
    this.id = id;
    this.firstname = firstname;
    this.middlename = null;
    this.lastname = lastname;
    this.nickname = null;
    this.title = null;
    this.company = null;
    this.address = null;
    this.homePhone = null;
    this.mobilePhone = null;
    this.group = group;
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

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
