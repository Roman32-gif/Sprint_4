import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import pageObjects.ConfirmOrder;
import pageObjects.MainPage;
import pageObjects.OrderInfo;
import pageObjects.RentInfo;

@RunWith(Parameterized.class)
public class OrderTest {
    private final DriversBrowsers driversSettings = new DriversBrowsers();
    private final String whichButtonToClick;
    private final String firstName;
    private final String lastName;
    private final String Address;
    private final String idMetroStation;
    private final String phoneNumber;
    private final String date;
    private final String howMuchDays;
    private final String color;
    private final String comment;

    public OrderTest(String whichButtonToClick,
                     String firstName,
                     String lastName,
                     String Address,
                     String idMetroStation,
                     String phoneNumber,
                     String date,
                     String daysCount,
                     String color,
                     String comment) {
        this.whichButtonToClick = whichButtonToClick;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Address = Address;
        this.idMetroStation = idMetroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.howMuchDays = daysCount;
        this.color = color;
        this.comment = comment;
    }

    @Before
    public void startUp() {
        driversSettings.initDriver();
    }

    @Parameters
    public static Object[][] dataForTests() {
        return new Object[][]{
                {"header", "Роман", "Егоров", "Пермь", "5", "89344326677", "024", "3", "black", "Самый новый"},
                {"bottom", "Василий", "Петрович", "Москва", "8", "87546754455", "027", "1", "grey", "Аккуратнее пожалуйста"}};
    }

    //тест для заказа самоката
    @Test
    public void OrderOfScooter() {
        WebDriver driver = driversSettings.getDriver();
        driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
        MainPage main = new MainPage(driver);
        main.open();
        main.clickHeaderRightButtonOrBottomButton(whichButtonToClick);

        OrderInfo order = new OrderInfo(driver);
        order.fillFirstNameClient(firstName);
        order.fillLastNameClient(lastName);
        order.fillAddressClient(Address);
        order.fillMetroClient(idMetroStation);
        order.fillPhoneNumberClient(phoneNumber);
        order.clickNextButton();

        RentInfo rent = new RentInfo(driver);
        rent.fillDateClient(date);
        rent.fillRentTimeClient(howMuchDays);
        rent.fillColorClient(color);
        rent.fillCommentClient(comment);
        rent.clickOrderButton();
        ConfirmOrder confirm = new ConfirmOrder(driver);
        confirm.checkConfirmWindowIsVisible();
    }

    @After
    public void tearDown() {
        driversSettings.getDriver().quit();
    }
}

