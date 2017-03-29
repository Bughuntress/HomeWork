package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test/*(enabled=false)*/
  public void testContactCreation() {
    app.goTo().ContactPage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withName("Белль").withLastname("Джейсон").withNickname("Красавица").withTitle("Красавица и Чудовище").withCompany("Диснейлэнд").withAddress("1, Заколдованный Замок, Волшебный Лес").withHometel("+22222222").withGroup("Сказочные герои");
    app.contact().create(contact);
    app.contact().returnToContactPage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(),before.size()+1);


    contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before,after);
  }


}
