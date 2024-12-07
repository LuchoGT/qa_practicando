package step;

import org.junit.Assert;
import page.Ejercicio01Page;
import page.NavigationPage;

public class BaseSteps {
    NavigationPage navigatePage = new NavigationPage();

    Ejercicio01Page ejercicio01Page = new Ejercicio01Page();

    public void openBrowser(){
        navigatePage.navigatePageUrl();
    }

    public void validateIncioSesion(String txtTitle){
        Assert.assertEquals(txtTitle, ejercicio01Page.verifyResult());
        //assertEquals=comparar
    }
}
