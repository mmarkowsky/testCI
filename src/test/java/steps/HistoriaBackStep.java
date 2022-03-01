package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HistoriaBackPage;

public class HistoriaBackStep {

    private HistoriaBackPage historiaBackPage = new HistoriaBackPage();

    @Given("que eu envio a url para obter posts")
    public void queEuEnvioAUrlParaObterPosts() {
        historiaBackPage.enviarUrl("/comments?postId=");
    }

    @When("eu envio um post para consultar")
    public void euEnvioUmPostParaConsultar() {
        historiaBackPage.enviarIdPost(3);
    }

    @Then("eu vejo na resposta as informações do post consultado")
    public void euVejoNaRespostaAsInformaçõesDoPostConsultado() {
        historiaBackPage.verificarInformacoesPost();
    }
}