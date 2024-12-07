package step;

import page.Ejercicio01Page;
import page.NotificationPage;

public class NotificationSteps {

    NotificationPage notificationPage = new NotificationPage();


    public void clickNoti(){
        notificationPage.clickNoti();
    }

    public void scrollDown(int totalPixels, int stepSize, int delayInMillis) {
        notificationPage.scrollVertical(totalPixels,stepSize,delayInMillis);
    }

    public void scrollNotificationsSmooth(int totalPixels, int stepSize, int delayInMillis) {
        notificationPage.scrollNotificationsSmooth(totalPixels, stepSize, delayInMillis);
    }

    public void seleccionarNotificacion(){
        notificationPage.seleccionarNotificacionAleatoria();
    }

    public void cargarNotificacion(){
        notificationPage.entrarEnNotificacionSeleccionada();
    }



}
