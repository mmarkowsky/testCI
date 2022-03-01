package pages;

import core.MetodosUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComunFrontPage extends MetodosUtils {

    public ComunFrontPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".FPdoLc [value='Me siento con suerte ']")
    private WebElement _btnSorte;

    public void acessarMeSintoComSorte(){
        clicar(_btnSorte);
    }
}