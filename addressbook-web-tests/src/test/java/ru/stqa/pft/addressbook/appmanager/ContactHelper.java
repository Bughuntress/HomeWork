package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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


  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='"+id+"']")).click();;
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

  public void create(ContactData contact) {
    initContactCreation();
    fillContactCreation(contact, true);
    inputContactCreation();
    contactCashe = null;
    returnToContactCreation();

  }
  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initContactModification();
    fillContactCreation(contact,false);
    submitContactModification();
    contactCashe = null;
    returnToContactPage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    selectedDeleteContact();
    closePopup();
    contactCashe = null;
    returnToContactPage();
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

  private Contacts contactCashe =null;


  public Contacts all() {
    if (contactCashe != null) {
      return new Contacts(contactCashe);
    }
    contactCashe = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    List<WebElement> cells = wd.findElements(By.tagName("td"));
    for (WebElement element: elements){
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String name = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      contactCashe.add( new ContactData().withId(id).withName(name).withLastname(lastname));

    }
    return new Contacts(contactCashe);
  }


}
