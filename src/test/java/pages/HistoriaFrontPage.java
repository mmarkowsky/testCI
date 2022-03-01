package pages;

import core.MetodosUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HistoriaFrontPage extends MetodosUtils {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement _txtDoodle;

    @FindBy(xpath = "//ul[@id='archive-list']//div[@class='title']//a[@title]")
    private List<WebElement> _listDoodles;

    public HistoriaFrontPage(WebDriver driver) {
        super(driver);
    }

    public void buscarDoodle(String doodle) {
        enviarMensagem(_txtDoodle,doodle);
        sendKeys(_txtDoodle, Keys.ENTER);
    }

    public void verificarDoodle(String doodle) {
        List<WebElement> doodles = _listDoodles;
        Boolean existe = false;
        for (WebElement element : doodles) {
            if(element.getText().toLowerCase().contains(doodle.toLowerCase())){
                existe = true;
            }
        }
        if (existe){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
    }
}
