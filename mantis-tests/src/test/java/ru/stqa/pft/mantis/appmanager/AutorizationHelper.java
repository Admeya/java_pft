package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;

import java.util.List;

public class AutorizationHelper extends HelperBase{

    public AutorizationHelper(ApplicationManager app) {
        super(app);
    }

    public void login(String username, String pass) {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"),username);
        type(By.name("password"), pass);
        click(By.cssSelector("input[value='Login']"));
    }

    public void finishChangePass(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Update User']"));
    }

    public void clickToLink(String nameLink){
        click(By.xpath(String.format("//*[contains(text(),'%s')]",nameLink)));
    }

    public void clickToBtn(String xpathBtn){
        click(By.cssSelector(String.format("input[value='%s']",xpathBtn)));
    }

    public UserData selectUser(List<UserData> users){
        int i = 0;
        String nameUser = users.get(i).getUserName();
        if (nameUser.equals(System.getProperty("web.adminLogin"))){
            i++;
            nameUser = users.get(i).getUserName();
        }
        return users.get(i);
    }
}
