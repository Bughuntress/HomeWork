package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {

        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupCreation(new GroupData("Creationgroup", "name", "test1"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}
