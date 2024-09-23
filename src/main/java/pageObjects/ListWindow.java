package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListWindow {
    //драйвер
    private final WebDriver driver;
    private final String topHover = "accordion__heading-";
    private final String underText = "accordion__panel-";

    //конструктор
    public ListWindow(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickCookie() {
        driver.findElement(Config.BASE_COOKIE_PATH).click();
    }

    public void scrollDown(String locator) {
        WebElement element = driver.findElement(By.id(topHover + locator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickButton(String locator) {
        driver.findElement(By.id(topHover + locator)).click();
    }

    public void checkRightText(String expected) {
        assert this.driver.findElement(By.id(underText+ expected)).isDisplayed();

    }
}
