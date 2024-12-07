package step;

import page.Ejercicio01Page;

public class Ejercicio01Steps {

    Ejercicio01Page ejercicio01Page = new Ejercicio01Page();

    public void writeText(String user, String password){
       ejercicio01Page.writeFields(user, password);
    }

    public void clickButton(){
        ejercicio01Page.clickButton();
    }

    public void clickNoti(){
        ejercicio01Page.clickNoti();
    }


}
