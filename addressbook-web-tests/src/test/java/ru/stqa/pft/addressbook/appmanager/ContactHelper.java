package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zakhidat on 27.02.2017.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void closePopup() {
    wd.switchTo().alert().accept();
  }

  public void selectedDeleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContact() {
    wd.findElements(By.name("selected[]"));
    }

  public void returnToContactCreation() {
    click(By.id("content"));
  }

  public void inputContactCreation() {

    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactCreation(ContactData contactData, boolean creation) {
    if (isElementPressent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
            && isElementPressent(By.name("update"))) {
      return;
    }
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHometel());
    type(By.name("address2"), contactData.getAddress2());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPressent(By.name("new_group")));

    }

  }

  public void initContactCreation() {
      click(By.linkText("add new"));
  }

  public void initContactModification(/*index*/) {
    if (isElementPressent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
            && isElementPressent(By.name("update"))) {
      return;
    }
    //wd.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    if (isElementPressent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
            && isElementPressent(By.name("update"))) {
      return;
    }
    click(By.name("update"));
  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactCreation(contact, true);
    inputContactCreation();
    returnToContactCreation();

  }

  public boolean ThereisAContact() {
    return isElementPressent(By.name("selected[]"));
  }
  public void returnToContactPage() {
    click(By.linkText("home"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

 /* public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element: elements){
      String lastname = element.findElement(By.xpath(".//td[3]")).getText();
      String address = element.findElement(By.xpath(".//td[2]")).getText();
      ContactData contact = new ContactData( lastname, address,null, null, null,null,null,null,null);
      contacts.add(contact);
    }
    return contacts;

  }*/
}
