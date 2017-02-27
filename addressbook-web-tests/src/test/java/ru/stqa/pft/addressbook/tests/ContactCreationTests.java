package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    




    @Test
    public void testContactCreation() {
        app.gotoContactPage();
        app.initContactCreation();
        app.fillContactCreation(new ContactData("Белль", "Джейсон", "Красавица", "Красавица и Чудовище", "Диснейлэнд", "1, Заколдованный Замок, Волшебный Лес", "+22222222", "22, Дом Отца, Маленькая деревушка"));
        app.inputContactCreation();
        app.returnToContactCreation();
    }


}
