package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    if (isElementPressent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPressent(By.name("submit"))) {
      return;
    }
    click(By.name("submit"));
  }

  public void fillGroupCreation(GroupData groupData) {
    if (isElementPressent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPressent(By.name("submit"))) {
      return;
    }
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    if (isElementPressent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPressent(By.name("new"))) {
      return;
    }
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroupById(int id) {
    if (isElementPressent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPressent(By.name("new"))) {
      return;
    }
    wd.findElement(By.cssSelector("input[value='"+id+"']")).click();
  }
  public void initGroupModification() {
    if (isElementPressent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPressent(By.name("update"))) {
      return;
    }
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    if (isElementPressent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPressent(By.name("update"))) {
      return;
    }
    click(By.name("update"));
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupCreation(group);
    submitGroupCreation();
    groupCache = null;
    returnToGroupPage();
  }
  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupCreation(group);
    submitGroupModification();
    groupCache = null;
    returnToGroupPage();
  }

  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroups();
    groupCache = null;
    returnToGroupPage();

  }
  public boolean isThereAGroup() {
    return isElementPressent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Groups groupCache=null;

  public Groups all() {
    if(groupCache !=null) {
      return  new Groups(groupCache);
      }
    groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element: elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCache.add(new GroupData().withId(id).withName(name));
    }
    return new Groups(groupCache);
  }


}
