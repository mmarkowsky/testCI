package core;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MetodosUtils {
    public WebDriver driver;
    public static final int TIME_OUT = 10;

    public MetodosUtils(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIME_OUT), this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void clear(WebElement element) {
        element.clear();
    }

    public void clicar(WebElement element) {
        try {
            element.click();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }

    public void enviarMensagem(WebElement element, String mensagem) {
        element.sendKeys(mensagem);
    }

    public void sendKeys(WebElement element, Keys key) {
        element.sendKeys(key);
    }

    public void sendKeysViaActions(WebElement element, String fillWith) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(fillWith);
        actions.build().perform();
    }

    public void javascriptClicar(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public void scroll(String scl) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + scl + ")");
    }

    // Função mouseover
    public void mouseOver(WebElement element) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(1000);
    }

    public void limparTextoKeys(WebElement element) throws InterruptedException {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        Thread.sleep(1000);
    }

    public void assertNotEquals(String v1, String v2) throws InterruptedException {
        assertNotEquals(v1, v2);
        System.out.println("Os textos não são iguais");
        Thread.sleep(2000);
    }

    public void assertEquals(String v1, String v2) throws InterruptedException {
        Assert.assertEquals(v1, v2);
        System.out.println("Os textos são iguais");
        Thread.sleep(2000);
    }

    public void isDisplayed(WebElement element) {
        try {
            Boolean display = element.isDisplayed();
            Assert.assertTrue(display);
            System.out.println("O elemento está na tela");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("O elemento não está na tela");
        }
    }

    public void alertAccept() {
        this.driver.switchTo().alert().accept();
    }

    public void alertDismiss() {
        this.driver.switchTo().alert().dismiss();
    }

    public void alertText(String message) {
        this.driver.switchTo().alert().sendKeys(message);
    }

    public void switchFrame(WebElement element) {
        this.driver.switchTo().frame(element);
    }

    public String buscaVariavelAmbiente(String variavel) {
        try {
            Properties info = new Properties();
            InputStream is = MetodosUtils.class.getResourceAsStream("/config.properties");
            info.load(is);
            return info.getProperty(variavel);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
