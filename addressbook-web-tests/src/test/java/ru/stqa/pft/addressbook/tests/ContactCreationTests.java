package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test/*(enabled=false)*/
  public void testContactCreation() {
    app.goTo().ContactPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withName("Белль").withLastname("Джейсон").withNickname("Красавица").withTitle("Красавица и Чудовище").withCompany("Диснейлэнд").withAddress("1, Заколдованный Замок, Волшебный Лес").withHometel("+22222222").withMobile("+333333333").withWorktel("+4444444444").withGroup("Сказочные герои");
    app.contact().create(contact);
    app.contact().returnToContactPage();
    assertThat(app.contact().count(),equalTo(before.size()+1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
  }

  @Test/*(enabled=false)*/
  public void testBadContactCreation() {
    app.goTo().ContactPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withName("Белль'").withLastname("Джейсон").withNickname("Красавица").withTitle("Красавица и Чудовище").withCompany("Диснейлэнд").withAddress("1, Заколдованный Замок, Волшебный Лес").withHometel("+22222222").withMobile("+333333333").withWorktel("+4444444444").withGroup("Сказочные герои");
    app.contact().create(contact);
    app.contact().returnToContactPage();
    assertThat(app.contact().count(),equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }


}
