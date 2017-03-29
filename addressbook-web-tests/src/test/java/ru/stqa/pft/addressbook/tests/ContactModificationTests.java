package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;



public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.getNavigationHelper().gotoContactPage();
    if (!app.getContactHelper().ThereisAContact()){
      app.getContactHelper().createContact(new ContactData(null, "Джейсон", "Красавица", "Красавица и Чудовище", "Диснейлэнд", "1, Заколдованный Замок, Волшебный Лес", "+22222222", "22, Дом Отца, Маленькая деревушка", "Сказочные герои"));
    }
  }

  @Test/*(enabled=false)*/
  public void testContactModification(){

    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size()-1;
    ContactData contact = new ContactData(before.get(index).getId(), "Белль", "Джейсон", "Красавица", "Красавица и Чудовище", "Диснейлэнд", "1, Заколдованный Замок, Волшебный Лес", "+22222222", "22, Дом Отца, Маленькая деревушка", null);
    app.getContactHelper().modifyContact(index, contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1,g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);

  }


}
