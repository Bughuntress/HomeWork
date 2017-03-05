package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Zakhidat on 27.02.2017.
 */
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

  public void selectGroup() {
    if (isElementPressent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPressent(By.name("new"))) {
      return;
    }
    click(By.name("selected[]"));
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
}
