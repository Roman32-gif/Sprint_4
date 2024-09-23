import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import pageObjects.ListWindow;

@RunWith(Parameterized.class)
public class TextFromWindowListTest {
    private final DriversBrowsers driversSettings = new DriversBrowsers();
    private final String locator;
    private final String expected;

    public TextFromWindowListTest(String locator, String expected) {
        this.locator = locator;
        this.expected = expected;
    }

    @Before
    public void startUp() {
            driversSettings.initDriver();
    }

    @Parameters
    public static Object[][] dataForTests() {
        return new Object[][]{
                {"0", "0"},
                {"1", "1"},
                {"2", "2"},
                {"3", "3"},
                {"4", "4"},
                {"5", "5"},
                {"6", "6"},
                {"7", "7"}};
    }
    //тест для проверки правилтности текста
    @Test
    public void checkInfoButton() {
        WebDriver driver = driversSettings.getDriver();
        ListWindow settings = new ListWindow(driver);
        settings.open();
        settings.clickCookie();
        settings.scrollDown(locator);
        settings.clickButton(locator);
        settings.checkRightText(expected);
    }

    @After
    public void tearDown() {
        driversSettings.getDriver().quit();
    }
}
