package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoContactPage();
    int before = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().ThereisAContact()){
      app.getContactHelper().createContact(new ContactData(null, "Джейсон", "Красавица", "Красавица и Чудовище", "Диснейлэнд", "1, Заколдованный Замок, Волшебный Лес", "+22222222", "22, Дом Отца, Маленькая деревушка", "Сказочные герои"));
    }

    app.getContactHelper().selectContact(before-1);
    app.getContactHelper().selectedDeleteContact();
    app.getContactHelper().closePopup();
    app.getContactHelper().returnToContactPage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before-1);
  }


}
