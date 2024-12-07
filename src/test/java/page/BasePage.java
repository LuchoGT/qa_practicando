package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;

    private static Actions action;

    static {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    private WebElement findElement(WebElement locator){
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void clickElement(WebElement locator){
        findElement(locator).click();
    }

    public void writeToElememt(WebElement locator, String textToWrite){
        findElement(locator).sendKeys(textToWrite);
    }

    public String getTotext(WebElement locator){
        return findElement(locator).getText();
    }

    public void selectFromDropdownByText(WebElement locator, String textToSelect){
        Select dropdown = new Select(findElement(locator));
        dropdown.selectByVisibleText(textToSelect);
    }

    public void doubleClick(WebElement locator){
        action.doubleClick(findElement(locator));
    }

    public void rightClick(WebElement locator){
        action.contextClick(findElement(locator));
    }

    public void scrollVerticalSmooth(int totalPixels, int stepSize, int delayInMillis) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Determinar la dirección del scroll (positivo o negativo)
        int direction = totalPixels > 0 ? 1 : -1;

        // Calcular el número de pasos
        int steps = Math.abs(totalPixels / stepSize);

        for (int i = 0; i < steps; i++) {
            jsExecutor.executeScript("window.scrollBy(0, arguments[0]);", direction * stepSize);
            try {
                Thread.sleep(delayInMillis); // Retraso entre cada paso
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Manejar interrupciones
            }
        }

        // Scroll final si quedan píxeles sobrantes
        int remainingPixels = Math.abs(totalPixels) % stepSize;
        if (remainingPixels > 0) {
            jsExecutor.executeScript("window.scrollBy(0, arguments[0]);", direction * remainingPixels);
        }
    }

    public void scrollVerticalSmoothInElement(WebElement element, int totalPixels, int stepSize, int delayInMillis) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Determinar la dirección del scroll (positivo o negativo)
        int direction = totalPixels > 0 ? 1 : -1;

        // Calcular el número de pasos
        int steps = Math.abs(totalPixels / stepSize);

        for (int i = 0; i < steps; i++) {
            jsExecutor.executeScript("arguments[0].scrollTop += arguments[1];", element, direction * stepSize);
            try {
                Thread.sleep(delayInMillis); // Retraso entre cada paso
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Manejar interrupciones
            }
        }

        // Scroll final si quedan píxeles sobrantes
        int remainingPixels = Math.abs(totalPixels) % stepSize;
        if (remainingPixels > 0) {
            jsExecutor.executeScript("arguments[0].scrollTop += arguments[1];", element, direction * remainingPixels);
        }
    }



}
