package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    //драйвер
    private final WebDriver driver;
    //локатор кнопки Заказать сверху справа
    private final By headerRightButton = By.xpath(".//div[contains(@class,'Header_Nav')]/button[contains(@class,'Button_Button')]");
    //локатор кнопки Заказать внизу
    private final By bottomButton = By.xpath(".//div[contains(@class,'Home_FinishButton')]/button[contains(@class,'Button_Button')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //метод открытия сайта и нажатия кнопки куки
    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(Config.BASE_COOKIE_PATH).click();
    }
    //метод нажатия кнопки Заказать сверху
    public void clickHeaderRightButton() {
        driver.findElement(headerRightButton).click();
    }
    //метод нажатия кнопки Заказать снизу
    public void clickBottomButton() {
        WebElement element = driver.findElement(bottomButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
        driver.findElement(bottomButton).click();
    }
    //метод выбора кнопки
    public void clickHeaderRightButtonOrBottomButton(String rightHeaderOrBottom) {
        if ("header".equals(rightHeaderOrBottom)) {
            clickHeaderRightButton();
        } else if ("bottom".equals(rightHeaderOrBottom)) {
            clickBottomButton();
        }

    }
}
