package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test/*(enabled=false)*/
  public void testContactCreation() {
    app.goTo().ContactPage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withName("Белль").withLastname("Джейсон").withNickname("Красавица").withTitle("Красавица и Чудовище").withCompany("Диснейлэнд").withAddress("1, Заколдованный Замок, Волшебный Лес").withHometel("+22222222").withGroup("Сказочные герои");
    app.contact().create(contact);
    app.contact().returnToContactPage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size()+1);



    before.add(contact);
    Comparator<? super ContactData> byId = (g1,g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }


}
