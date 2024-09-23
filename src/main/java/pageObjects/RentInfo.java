package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentInfo {
    //драйвер
    private final WebDriver driver;
    //локатор поля даты доставки
    private final By deliveryTimeClient = By.cssSelector("[placeholder='* Когда привезти самокат']");
    //локатор кнопки выбора даты
    private final String datePickedClient = ".//div[contains(@class,'day--";
    //закрытие xpath для datePicked
    private final String closerForDatePickedClient = "')]";
    //локатор в поле выбора времени аренды
    private final By rentTimeClient = By.xpath(".//span");
    //локатор кнопки выбора времени аренды
    private final String rentTimePickedClient = ".//div[@class='Dropdown-menu']/div[";
    //локатор  закрытие xpath для rentTimePickedClient
    private final String closerForRentTimePickedClient = "]";
    //локатор кнопки выбора цвета
    private final String colorScooter = "[for='";
    //закрытие cssSelector для color
    private final String closerForColorScooter = "']";
    //локатор поля комментария для курьера
    private final By commentclient = By.cssSelector("[placeholder='Комментарий для курьера']");
    //локатор кнопки Заказать
    private final By orderButton = By.xpath(".//div[contains(@class,'Order_Buttons')]/button[2]");
    //конструктор
    public RentInfo(WebDriver driver) {
        this.driver = driver;
    }
    //метод ввода даты доставки
    public void fillDateClient(String day) {
        driver.findElement(deliveryTimeClient).click();
        driver.findElement(By.xpath(datePickedClient + day + closerForDatePickedClient)).click();
    }
    //метод ввода срока аренды
    public void fillRentTimeClient(String daysCount) {
        driver.findElement(rentTimeClient).click();
        driver.findElement(By.xpath(rentTimePickedClient + daysCount + closerForRentTimePickedClient)).click();
    }
    //метод выбора цвета
    public void fillColorClient(String pickedColor) {
        driver.findElement(By.cssSelector(colorScooter + pickedColor + closerForColorScooter)).click();
    }
    //метод ввода комментария
    public void fillCommentClient(String commentForCourier) {
        driver.findElement(commentclient).sendKeys(commentForCourier);
    }
    //метод нажатия кнопки
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
}
