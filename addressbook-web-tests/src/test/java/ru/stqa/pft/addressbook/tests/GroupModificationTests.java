package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by Zakhidat on 01.03.2017.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().all().size() == 0){
      app.group().create(new GroupData().withName("Сказочные герои"));
    }
  }

  @Test
  public void testGroupModification(){


    Set<GroupData> before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("Сказочные герои").withHeader("Мультики").withFooter("Сказки");
    app.group().modify(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(),before.size());

    before.remove(modifiedGroup);
    before.add(group);
    Assert.assertEquals(before,after);
  }


}
