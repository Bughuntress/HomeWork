package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Zakhidat on 01.03.2017.
 */
public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoContactPage();
    app.getGroupHelper().selectGroup();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactCreation(new ContactData("Белль", "Джейсон", "Красавица", "Красавица и Чудовище", "Диснейлэнд", "1, Заколдованный Замок, Волшебный Лес", "+22222222", "22, Дом Отца, Маленькая деревушка", null), false);
    app.getContactHelper().submitContactModification();

  }
}
