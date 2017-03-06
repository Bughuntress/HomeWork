package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoContactPage();
    if (!app.getContactHelper().ThereisAContact()){
      app.getContactHelper().createContact(new ContactData(null, "Джейсон", "Красавица", "Красавица и Чудовище", "Диснейлэнд", "1, Заколдованный Замок, Волшебный Лес", "+22222222", "22, Дом Отца, Маленькая деревушка", "Сказочные герои"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().selectedDeleteContact();
    app.getContactHelper().closePopup();
  }


}
