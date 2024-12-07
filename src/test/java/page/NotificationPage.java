package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class NotificationPage extends BasePage{

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[2]/div[5]/div[1]/div[3]")
    public WebElement btnNotificacion;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[2]/div[5]/div[2]/div/div[2]/div[1]/div[1]/div/div/div/div/div/div/div")
    public WebElement notificationContainer;

    @FindBy(xpath="/html/body/div[1]/div/div[1]/div/div[2]/div[5]/div[2]/div/div[2]/div[1]")
    public List<WebElement> listaNotificaciones;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[2]/div[5]/div[2]/div/div[2]/div[1]/div[1]/div/div/div/div/div/div/div/div[1]/div[3]/div[2]/div/div/div[2]")
    public WebElement cardNotificacion ;

    public NotificationPage() {
        super(driver);
    }

    public void clickNoti(){clickElement(btnNotificacion);}

    public void scrollVertical(int totalPixels, int stepSize, int delayInMillis) {
        scrollVerticalSmooth(totalPixels,stepSize,delayInMillis);
    }

    public void scrollNotificationsSmooth(int totalPixels, int stepSize, int delayInMillis) {
        scrollVerticalSmoothInElement(notificationContainer, totalPixels, stepSize, delayInMillis);
    }

    public void hacerScrollEnBarraDeNotificaciones(int totalPixels, int stepSize, int delayInMillis) {
        if (notificationContainer == null) {
            throw new IllegalStateException("No se encontró el contenedor de la barra de notificaciones.");
        }

        // Determinar la dirección del scroll (positivo: hacia abajo, negativo: hacia arriba)
        int direction = totalPixels > 0 ? 1 : -1;

        // Calcular el número de pasos
        int steps = Math.abs(totalPixels / stepSize);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        for (int i = 0; i < steps; i++) {
            jsExecutor.executeScript("arguments[0].scrollTop += arguments[1];", notificationContainer, direction * stepSize);

            // Retraso entre cada paso
            try {
                Thread.sleep(delayInMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Scroll final si quedan píxeles sobrantes
        int remainingPixels = Math.abs(totalPixels) % stepSize;
        if (remainingPixels > 0) {
            jsExecutor.executeScript("arguments[0].scrollTop += arguments[1];", notificationContainer, direction * remainingPixels);
        }
    }

    private int lastRandomIndex = -1; // Variable para almacenar el índice del último producto aleatorio

    public void seleccionarNotificacionAleatoria() {
        if (listaNotificaciones.isEmpty()) {
            throw new IllegalStateException("No hay notificaciones disponibles para seleccionar.");
        }

        // Generar un índice aleatorio
        int randomIndex = new Random().nextInt(listaNotificaciones.size());
        lastRandomIndex = randomIndex; // Guardar el índice seleccionado

        // Seleccionar la notificación aleatoria (clic en el contenedor de la notificación)
        clickElement(listaNotificaciones.get(randomIndex));

        // Imprimir información de depuración (opcional)
        System.out.println("Notificación seleccionada: " + listaNotificaciones.get(randomIndex).getText());
    }

    public void entrarEnNotificacionSeleccionada() {
        if (lastRandomIndex == -1) {
            throw new IllegalStateException("No se ha seleccionado ninguna notificación aún.");
        }

        // Hacer clic en el enlace o elemento dentro de la notificación para entrar (si aplica)
        WebElement notificacionSeleccionada = listaNotificaciones.get(lastRandomIndex);

        // Supongamos que la notificación tiene un enlace clickeable
        WebElement linkDentroDeNotificacion = notificacionSeleccionada.findElement(By.tagName("a"));
        clickElement(linkDentroDeNotificacion);

        // Imprimir información de depuración (opcional)
        System.out.println("Entrando en la notificación: " + notificacionSeleccionada.getText());
    }



}
