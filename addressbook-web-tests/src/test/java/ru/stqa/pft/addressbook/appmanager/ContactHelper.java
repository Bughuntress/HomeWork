package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

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
      if (contactData.getGroup() != null) {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      } else {
        Assert.assertFalse(isElementPressent(By.name("new_group")));

      }

    }
  }

  public void initContactCreation() {
      click(By.linkText("add new"));
  }

  public void initContactModification() {
    if (isElementPressent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
            && isElementPressent(By.name("update"))) {
      return;
    }
    //click(By.cssSelector("img[alt='Edit']"));
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

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCashe =null;


 public Contacts all() {
    if (contactCashe != null) {
      return new Contacts(contactCashe);
    }
    contactCashe = new Contacts();

    List<WebElement> elements = wd.findElements(By.name("entry"));
    //List<WebElement> cells = wd.findElements(By.tagName("td"));
    for (WebElement element: elements){
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String name = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
      contactCashe.add( new ContactData().withId(id).withName(name).withLastname(lastname).withAllPhones(allPhones));

    }
    return new Contacts(contactCashe);
  }

  /*public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells =row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      contacts.add(new ContactData().withId(id).withName(firstname).withLastname(lastname));
    }
    return contacts;
    }
*/

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String name = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withName(name).withLastname(lastname)
            .withHometel(home).withMobile(mobile).withWorktel(work);
  }

  private void initContactModificationById(int id) {

    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    /*WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s]", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElements(By.tagName("a")).click();*/

    //wd.findElement(By.xpath(String.format("//input(@value='%s']/../../td[8]/a", id))).click();
    //wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[%]/a", id))).click();

  }
}
