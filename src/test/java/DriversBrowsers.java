import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriversBrowsers {
    private WebDriver driver;


    public void initDriver() {
        if ("firefox".equals(System.getProperty("browser"))) {
            this.initFirefox();
        } else {
            this.initChrome();
        }

    }

    private void initFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions opts = (new FirefoxOptions()).addArguments();
        driver = new FirefoxDriver(opts);
        driver.manage().window().maximize();
    }

    private void initChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
