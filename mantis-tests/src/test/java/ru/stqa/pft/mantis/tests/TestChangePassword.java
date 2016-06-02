package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by ilugovova on 02.06.2016.
 */
public class TestChangePassword extends TestBase{
    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test
   public void changePasswordTest() throws IOException, MessagingException {
       app.autorization().login("administrator", "root"); // System.getProperty("web.adminLogin"), System.getProperty("web.adminPass")
       app.autorization().clickToLink("Manage Users");
        List<UserData> users = app.hbConnection().queryToUserTable();
       String user = app.autorization().selectUser(users).getUserName();//"user1";//
       String email = app.autorization().selectUser(users).getEmail(); //user1@localhost.localdomain";
       String password = "111";
       app.autorization().clickToLink(user);
       app.autorization().clickToBtn("Reset Password");
       List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
       String confirmationLink = findConfirmationLink(mailMessages, email);
       app.registration().finish(confirmationLink,  password);
       assertTrue(app.newSession().login(user, password));
   }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
}
