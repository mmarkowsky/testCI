package steps;

import initializar.ClassInit;
import io.cucumber.java.pt.Dado;
import org.openqa.selenium.WebDriver;
import pages.ComunFrontPage;

public class ComunStep {

    //Steps em comuns para diferentes features
    private WebDriver driver = ClassInit.getDriver();

    ComunFrontPage comunPage = new ComunFrontPage(driver);

    @Dado("eu ingresso na home de google na opção de me sinto com sorte")
    public void euIngressoNaHomeDeGoogleNaOpcaoDeMeSintoComSorte() {
        comunPage.acessarMeSintoComSorte();
    }
}