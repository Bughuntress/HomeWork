package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().ContactPage();
    if (app.contact().all().size()==0){
      app.contact().create(new ContactData().withName("Белль").withLastname("Джейсон").withAddress("1, Заколдованный Замок, Волшебный Лес").withHometel("+22222222").withMobile("+333333333").withWorktel("+4444444444").withEmail("bell@dis.com").withEmail2("bell2@dis.com").withEmail3("bell3@dis.com"));
    }
  }

  @Test
  public void testContactPhones() {
    app.goTo().ContactPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    if (contactInfoFromEditForm.getAllPhones() !=null) {
      assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    if (contactInfoFromEditForm.getAllEmails() != null) {
      assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }

    if (contactInfoFromEditForm.getAddress() != null) {
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }

  }



  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3())
            .stream().filter((s)->!s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHometel(),contact.getMobile(),contact.getWorktel())
            .stream().filter((s)->!s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }
    
  public static String cleaned(String phone) {
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }

}
