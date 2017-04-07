package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Zakhidat on 06.04.2017.
 */
public class ContactFullInfoTests extends TestBase {

  @Test/*(enabled=false)*/
  public void testContactFullInfo(){
    app.goTo().ContactPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactFullInfoFromDetailsForm = app.contact().FullInfoFromDetailsForm(contact);
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    String form = cleaned(contactFullInfoFromDetailsForm.getFullInfo());
    String content = mergeFullInfo(contactInfoFromEditForm);
    if (contactFullInfoFromDetailsForm.getFullInfo() != null) {
      assertThat(cleaned(contactFullInfoFromDetailsForm.getFullInfo()), equalTo(mergeFullInfo(contactInfoFromEditForm)));
    }
  }

  private String mergeFullInfo(ContactData fullInfo) {
    return Arrays.asList(fullInfo.getName(),fullInfo.getLastname(),fullInfo.getAddress(),fullInfo.getHometel(),fullInfo.getMobile(),fullInfo.getWorktel(),fullInfo.getEmail(),fullInfo.getEmail2(),fullInfo.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining(""));

  }

  public static String cleaned(String fullInfo) {
    return fullInfo.replaceAll("\\s","").replaceAll("[-()]","")
            .replaceAll("Memberof.*","")
            .replace("M:", "")
            .replace("H:", "")
            .replace("W:", "");
  }
}
