package page;

import utils.ConfigManager;

public class NavigationPage extends BasePage {
    public NavigationPage() {
        super(driver);
    }

    public void navigatePageUrl() {
        navigateTo(ConfigManager.getProperty("baseURL"));
    }
}
