package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ConfirmOrder {
    // драйвер
    private final WebDriver driver;
    // локатор окна Заказ оформлен
    private final By confirmForm = By.xpath("//div[@class='Order_Modal__YZ-d3']/div/button[text()='Посмотреть статус']");
    //конструктор
    public ConfirmOrder(WebDriver driver) {
        this.driver = driver;
    }
        public void checkConfirmWindowIsVisible () {
            assert driver.findElement(confirmForm).isDisplayed();
        }
    }

