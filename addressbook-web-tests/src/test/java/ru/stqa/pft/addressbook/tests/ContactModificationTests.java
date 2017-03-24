package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Zakhidat on 01.03.2017.
 */
public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoContactPage();
    int before = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().ThereisAContact()){
      app.getContactHelper().createContact(new ContactData(null, "Джейсон", "Красавица", "Красавица и Чудовище", "Диснейлэнд", "1, Заколдованный Замок, Волшебный Лес", "+22222222", "22, Дом Отца, Маленькая деревушка", "Сказочные герои"));
    }

    app.getContactHelper().selectContact(before-1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactCreation(new ContactData("Белль", "Джейсон", "Красавица", "Красавица и Чудовище", "Диснейлэнд", "1, Заколдованный Замок, Волшебный Лес", "+22222222", "22, Дом Отца, Маленькая деревушка", null), false);		      app.getContactHelper().fillContactCreation(new ContactData("Белль", "Джейсон", "Красавица", "Красавица и Чудовище", "Диснейлэнд", "1, Заколдованный Замок, Волшебный Лес", "+22222222", "22, Дом Отца, Маленькая деревушка", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before);


   /* /*List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactCreation(new ContactData("Белль", "Джейсон", "Красавица", "Красавица и Чудовище", "Диснейлэнд", "1, Заколдованный Замок, Волшебный Лес", "+22222222", "22, Дом Отца, Маленькая деревушка", null), false);
    /*ContactData contact = new ContactData(before.get(before.size()-1).getLastname(), before.get(before.size()-1).getAddress(),"Белль", "Красавица", "Красавица и Чудовище", "Диснейлэнд", "+22222222", "22, Дом Отца, Маленькая деревушка", null);
    app.getContactHelper().fillContactCreation(contact, false);
    app.getContactHelper().submitContactModification();*/
    /*app.getContactHelper().returnToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size()-1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));*/
  }
}
