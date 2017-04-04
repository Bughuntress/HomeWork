package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String name;
  private String lastname;
  private String nickname;
  private String title;
  private String company;
  private String address;
  private String hometel;
  private String address2;
  private String group;
  private String mobile;
  private String worktel;
  private String allPhones;

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;

  }

  public String getAllPhones() {
    return allPhones;
  }



  public ContactData withId(int id) {
    this.id = id;
    return this;
  }
  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickname(String nickname) {
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

  public ContactData withHometel(String hometel) {
    this.hometel = hometel;
    return this;
  }

  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }
  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }
  public ContactData withWorktel(String worktel) {
    this.worktel = worktel;
    return this;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
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

  public String getHometel() {
    return hometel;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWorktel() {
    return worktel;
  }

  public String getAddress2() {
    return address2;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

}