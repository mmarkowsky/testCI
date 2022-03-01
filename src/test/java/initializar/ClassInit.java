package initializar;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import core.MetodosUtils;
import java.util.concurrent.TimeUnit;

public class ClassInit {
    public static WebDriver driver;
    private static String scenarioName;
    private static MetodosUtils metodosUtils = new MetodosUtils(driver);

    @Before
    public void initializeTest(Scenario scenario) {
        scenarioName = scenario.getName().replaceAll(" ", "_");
        switch (metodosUtils.buscaVariavelAmbiente("BROWSER")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", getPathFirefoxDriver());
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", getPathChromeDriver());
                driver = new ChromeDriver(addOptions());
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", getPathIEDriver());
                DesiredCapabilities capabilities = addCapabilitiesIE();
                driver = new InternetExplorerDriver(capabilities);
                break;
        }
        switch (metodosUtils.buscaVariavelAmbiente("SIZE")) {
            case "desktop":
                driver.manage().window().maximize();
                break;
            case "mobile":
                driver.manage().window().setSize(new Dimension(300, 200));
                break;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(metodosUtils.buscaVariavelAmbiente("URL_BASE"));
    }

    @After
    public static void endTest(Scenario scenario) {
        try {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
            System.out.println("Starting - " + scenario.getName());
            System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getScenarioName() {
        return scenarioName;
    }

    public static String getPathChromeDriver() {
        String so = System.getProperty("os.name").toLowerCase();
        so = so.replaceAll(" ", "");
        so = so.replaceAll("[0-9]", "");
        String directory = System.getProperty("user.dir");
        //return "C:\\Users\\Public\\drivers\\windows\\chromedriver.exe";
        if ("windows".equals(so)) {
            return directory + String.format("\\drivers\\windows\\chromedriver.exe", so);
        } else {
            return directory + String.format("/drivers/%s/chromedriver", so);
        }
    }

    public static String getPathIEDriver() {
        String so = System.getProperty("os.name").toLowerCase();
        so = so.replaceAll(" ", "");
        so = so.replaceAll("[0-9]", "");
        String directory = System.getProperty("user.dir");
        //return "C:\\Users\\Public\\drivers\\windows\\chromedriver.exe";
        if ("windows".equals(so)) {
            return directory + String.format("\\drivers\\windows\\chromedriver.exe", so);
        } else {
            return directory + String.format("/drivers/%s/chromedriver", so);
        }
    }

    static String getPathFirefoxDriver() {
        String so = System.getProperty("os.name").toLowerCase();
        so = so.replaceAll(" ", "");
        so = so.replaceAll("[0-9]", "");
        String directory = System.getProperty("user.dir");
        //return "C:\\Users\\Public\\drivers\\windows\\chromedriver.exe";
        if ("windows".equals(so)) {
            return directory + String.format("\\drivers\\windows\\chromedriver.exe", so);
        } else {
            return directory + String.format("/drivers/%s/chromedriver", so);
        }
    }

    static ChromeOptions addOptions() {
        String so = System.getProperty("os.name").toLowerCase();
        so = so.replaceAll(" ", "");
        so = so.replaceAll("[0-9]", "");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        if ("linux".equals(so)) {
            options.addArguments("--no-sandbox");
        }
        return options;
    }

    static DesiredCapabilities addCapabilitiesIE() {
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability("nativeEvents", false);
        capabilities.setCapability("unexpectedAlertBehaviour", "accept");
        capabilities.setCapability("ignoreProtectedModeSettings", true);
        capabilities.setCapability("disable-popup-blocking", true);
        capabilities.setCapability("enablePersistentHover", true);
        capabilities.setCapability("IgnoreZoomLevel", true);
        capabilities.setCapability("IntroduceInstabilityByIgnoringProtectedModeSettings", true);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability("setJavascriptEnabled", true);
        capabilities.setCapability("requireWindowFocus", true);
        return capabilities;
    }
}