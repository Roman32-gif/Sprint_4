package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderInfo {
    //драйвер
    private final WebDriver driver;
    //локатор поля имя
    private final By firstNameClient = By.cssSelector("[placeholder='* Имя']");
    //локатор поля фамилия
    private final By lastNameClient = By.cssSelector("[placeholder='* Фамилия']");
    //локатор поля адресс
    private final By addressClient = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']");
    //локатор поля метро
    private final By metro = By.cssSelector("[placeholder='* Станция метро']");
    //локатор кнопки выбора станции
    private final String metroStation = "[data-index='";
    // закрытие для cssSelector
    private final String closingCssSelectorForMetro = "']";
    //локатор поля номера телефона
    private final By phoneNumberClient = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");
    //локатор кнопки Далее
    private final By ButtonNext = By.xpath(".//div[contains(@class,'Order_NextButton__1')]/button");
    //конструктор
    public OrderInfo(WebDriver driver) {
        this.driver = driver;
    }
    //метод ввода имени
    public void fillFirstNameClient(String firstName) {
        driver.findElement(firstNameClient).sendKeys(firstName);
    }
    //метод ввода фамилии
    public void fillLastNameClient(String lastName) {
        driver.findElement(lastNameClient).sendKeys(lastName);
    }
    //метод ввода адресса
    public void fillAddressClient(String Address) {
        driver.findElement(addressClient).sendKeys(Address);
    }
    //метод выбора метро
    public void fillMetroClient(String id) {
        driver.findElement(metro).click();
        driver.findElement(By.cssSelector(metroStation+ id + closingCssSelectorForMetro)).click();
    }
    //метод ввода телефона
    public void fillPhoneNumberClient(String number) {
        driver.findElement(phoneNumberClient).sendKeys(number);
    }
    //метод нажатия на кнопку
    public void clickNextButton() {
        driver.findElement(ButtonNext).click();
    }
}
