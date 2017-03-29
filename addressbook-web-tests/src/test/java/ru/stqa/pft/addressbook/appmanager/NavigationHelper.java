package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Zakhidat on 27.02.2017.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if (isElementPressent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPressent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));

  }

  public void ContactPage() {
    if (isElementPressent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }
}
