package ru.stqa.pft.addressbook.model;

public class GroupData {
  private final String id;
  private final String name;
  private final String header;
  private final String footer;

  public String getId() {
    return id;
  }

  public GroupData(String name, String header, String footer) {
    this.id = null;
    this.name = name;
    this.header = header;
    this.footer = footer;

  }

  public GroupData(String id, String name, String header, String footer) {
    this.id = id;
    this.name = name;
    this.header = header;
    this.footer = footer;

  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "name='" + name + '\'' +
            ", header='" + header + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (name != null ? !name.equals(groupData.name) : groupData.name != null) return false;
    return header != null ? header.equals(groupData.header) : groupData.header == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (header != null ? header.hashCode() : 0);
    return result;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }
}
