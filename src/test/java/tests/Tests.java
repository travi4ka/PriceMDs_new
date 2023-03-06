package tests;

import entitites.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase{
    @Test
    @Tag("Smoke")
    @Tag("Prod")
    @DisplayName("Check elements on the Main Page")
    void checkElementOnTheMainPage(){
        mainPage
                .openPage()
                .checkTitle()
                .checkUrl()
                .checkElementsOnThePage();
    }

    @Test
    @Tag("Smoke")
    @Tag("Prod")
    @DisplayName("Log in as Main Admin")
    void logIn(){
        mainPage
                .openPage()
                .logInAsMainAdmin();
    }

    @Test
    @Tag("Smoke")
    @Tag("Prod")
    @DisplayName("Log in as Main Admin")
    void logIn2222(){
        User jii=new User();
        jii.fewfwe();
   //     System.out.println(new User().getTokenForAdmin());
    }
}
