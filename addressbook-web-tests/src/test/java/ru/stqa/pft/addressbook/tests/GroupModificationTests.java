package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Zakhidat on 01.03.2017.
 */
public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification(){

    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
     

    if (!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("Сказочные герои", "name", null));
    }

    app.getGroupHelper().selectGroup(before-1);
    app.getGroupHelper().initGroupModification();

    app.getGroupHelper().fillGroupCreation(new GroupData("Сказочные герои", "name", null));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after,before);
  }
}
