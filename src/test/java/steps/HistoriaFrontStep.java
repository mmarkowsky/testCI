package steps;

import initializar.ClassInit;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import org.openqa.selenium.WebDriver;
import pages.HistoriaFrontPage;

public class HistoriaFrontStep {

    private WebDriver driver = ClassInit.getDriver();
    HistoriaFrontPage historiaFrontPage = new HistoriaFrontPage(driver);

    @Quando("eu envio um texto {string}")
    public void euEnvioUmTexto(String doodle){
        historiaFrontPage.buscarDoodle(doodle);
    }

    @Entao("deve mostrar coincidencias sobre o texto enviado {string}")
    public void deveMostrarCoincidenciasSobreOTextoEnviado(String doodle) throws InterruptedException {
        historiaFrontPage.verificarDoodle(doodle);
    }
}