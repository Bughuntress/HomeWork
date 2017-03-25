package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String name;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String hometel;
  private final String address2;
  private String group;

  public ContactData(String name, String lastname, String nickname, String title, String company, String address, String hometel, String address2, String group) {
    this.name = name;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.hometel = hometel;
    this.address2 = address2;
    this.group = group;
  }
 /* public ContactData( String lastname, String nickname, String title, String company, String address, String hometel, String address2, String group) {
    this.name = null;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.hometel = hometel;
    this.address2 = address2;
    this.group = group;
  }*/

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "lastname='" + lastname + '\'' +
            ", nickname='" + nickname + '\'' +
            ", company='" + company + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
    return company != null ? company.equals(that.company) : that.company == null;
  }

  @Override
  public int hashCode() {
    int result = lastname != null ? lastname.hashCode() : 0;
    result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
    result = 31 * result + (company != null ? company.hashCode() : 0);
    return result;
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

  public String getAddress2() {
    return address2;
  }

  public String getGroup() {
    return group;
  }
}
