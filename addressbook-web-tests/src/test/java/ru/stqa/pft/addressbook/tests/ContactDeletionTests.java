package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    

    
    @Test
    public void testContactDeletion() {
        app.gotoContactPage();
        app.selectGroup();
        app.selectedDeleteContact();
        app.closePopup();


    }


}
