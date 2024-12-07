package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Ejercicio01Page extends BasePage{
    @FindBy(id = "email")
    public WebElement txtUserName;
    @FindBy(id = "pass")
    public WebElement txtPassword;
    @FindBy(name = "login")
    public WebElement btnLogin;
    @FindBy(linkText = "Amigos")
    public WebElement txtResult;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[2]/div[5]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div[1]")
    public WebElement btnNotificacion;

//    @FindBy(xpath = "//*[@id=\"mount_0_0_Y0\"]/div/div[1]/div/div[2]/div[5]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div[1]/div[3]/div[1]/div[1]")
//    public WebElement txtResultNotifacion;
//
//    @FindBy(xpath = "//*[@id=\":r1h:\"]")
//    public WebElement txtAAA;

    public Ejercicio01Page() {
        super(driver);
    }

    public void writeFields(String user, String password){
        writeToElememt(txtUserName,user);
        writeToElememt(txtPassword,password);
    }

    public void clickButton(){
        clickElement(btnLogin);
    }

    public String verifyResult(){
       return getTotext(txtResult);
    }

    public void clickNoti(){clickElement(btnNotificacion);}

//    public String verifyNotifacion(){return txtResultNotifacion.getText();}

//    public void verifyNotificacion(){clickElement(txtAAA);}
}
