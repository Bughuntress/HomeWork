package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {

        gotoGroupPage();
        initGroupCreation();
        fillGroupCreation(new GroupData("Creationgroup", "name", "test1"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
