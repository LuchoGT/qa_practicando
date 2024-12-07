package glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.Ejercicio01Page;
import page.NotificationPage;
import step.BaseSteps;
import step.Ejercicio01Steps;
import step.NotificationSteps;


public class StepDefinitionEjercicio01 {

    Ejercicio01Steps ejercicio01Steps = new Ejercicio01Steps();
    BaseSteps baseSteps = new BaseSteps();
    NotificationSteps notificationSteps = new NotificationSteps();
    NotificationPage notificationPage = new NotificationPage();

    @Given("Abrir el navegador y navegar a la página de inicio de sesión")
    public void openBrowser(){
        baseSteps.openBrowser();
    }

    @When("Introducir un {string} y {string} válidos")
    public void ingreso_de_credenciales(String user, String password) {
        ejercicio01Steps.writeText(user,password);
    }

    @When("hago click en el botón de inicio de sesion")
    public void clickButton(){
        ejercicio01Steps.clickButton();
    }

//    @When("verificar login exitoso")
//    public void verifyResult(String user){
//        baseSteps.validateIncioSesion(user);
//    }

    @When("hago click en el boton de notificaciones")
    public void clickNotificacion(){
        notificationSteps.clickNoti();
    }

    @When("hago scrolling vertical")
    public void navigateNotificacion()throws  InterruptedException{
        Thread.sleep(1500);
//        notificationSteps.scrollNotificationsSmooth(500,50,50);
//        notificationPage.scrollNotificationsSmooth(500,50,50);
        notificationPage.hacerScrollEnBarraDeNotificaciones(500,50,100);
    }

    @When("selecciono una notificacion aleatoria")
    public void selec_noti()throws InterruptedException{
        Thread.sleep(1500);
        notificationSteps.seleccionarNotificacion();
    }

    @When("ingreso a la notificacion aleatoria")
    public void entrar_noti()throws InterruptedException{
        Thread.sleep(1500);
        notificationSteps.cargarNotificacion();
    }


}
