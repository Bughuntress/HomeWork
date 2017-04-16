package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test

  public void testContactCreation() {
    app.goTo();
    app.contact().initContactCreation();
    File photo = new File("src/test/resources/Atlantis.jpg");
    app.contact().fillContactCreation(new ContactData().withName("Белль").withLastname("Джейсон")
            .withAddress("1, Заколдованный Замок, Волшебный Лес")
            .withHometel("+22222222").withMobile("+333333333").withWorktel("+4444444444")
            .withEmail("bell@dis.com").withEmail2("bell2@dis.com").withEmail3("bell3@dis.com")
            .withPhoto(photo),true);
    app.contact().inputContactCreation();
    app.contact().returnToContactPage();
  }

/*@Test //проверка на наличие файла по относительному адресу
public void testCurrentDir(){
  File currentDir = new File(".");
  System.out.println(currentDir.getAbsolutePath());
  File photo = new File("src/test/resources/Atlantis.jpg");
  System.out.println(photo.getAbsolutePath());
  System.out.println(photo.exists());
}*/



 /* @Test(enabled=false)
  public void testContactCreation() {
    app.goTo().ContactPage();
    Contacts before = app.contact().all();
    File photo = new File();
    ContactData contact = new ContactData().withName("Белль").withLastname("Джейсон")
            .withAddress("1, Заколдованный Замок, Волшебный Лес")
            .withHometel("+22222222").withMobile("+333333333").withWorktel("+4444444444")
            .withEmail("bell@dis.com").withEmail2("bell2@dis.com").withEmail3("bell3@dis.com")
            .withPhoto(photo);
    app.contact().create(contact);
    app.contact().returnToContactPage();
    assertThat(app.contact().count(),equalTo(before.size()+1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
  }


   /* @Test/*(enabled=false)
  public void testBadContactCreation() {
    app.goTo().ContactPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withName("Белль'").withLastname("Джейсон").withAddress("1, Заколдованный Замок, Волшебный Лес").withHometel("+22222222").withMobile("+333333333").withWorktel("+4444444444").withEmail("bell@dis.com").withEmail2("bell2@dis.com").withEmail3("bell3@dis.com").withGroup("Сказочные герои");
    app.contact().create(contact);
    app.contact().returnToContactPage();
    assertThat(app.contact().count(),equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
*/

}
