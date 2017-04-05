package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import sun.font.CoreMetrics;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;


public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().ContactPage();
    if (app.contact().all().size()==0){
      app.contact().create(new ContactData().withName("Белль").withLastname("Джейсон").withNickname("Красавица").withTitle("Красавица и Чудовище").withCompany("Диснейлэнд").withAddress("1, Заколдованный Замок, Волшебный Лес").withHometel("+22222222").withMobile("+333333333").withWorktel("+4444444444").withEmail("bell@dis.com").withEmail2("bell2@dis.com").withEmail3("bell3@dis.com").withGroup("Сказочные герои"));
    }
  }

  @Test/*(enabled=false)*/
  public void testContactModification(){

    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("Белль").withLastname("Джейсон").withNickname("Красавица").withTitle("Красавица и Чудовище").withCompany("Диснейлэнд").withAddress("1, Заколдованный Замок, Волшебный Лес").withHometel("+22222222").withMobile("+333333333").withWorktel("+4444444444").withEmail("bell@dis.com").withEmail2("bell2@dis.com").withEmail3("bell3@dis.com").withGroup("Сказочные герои");
    app.contact().modify(contact);
    assertThat(app.contact().count(),equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

  }


}
