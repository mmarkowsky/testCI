package steps;

import io.cucumber.datatable.DataTable;
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
    public void euVejoNaRespostaAsInformacoesDoPostConsultado() {
        historiaBackPage.verificarInformacoesPost();
    }

    @Then("eu vejo na resposta as informações Title , Body, UserId  do post consultado")
    public void euVejoNaRespostaAsInformacoesTitleBodyUserIdDoPostConsultado(DataTable table) {
        historiaBackPage.verificarInformacoesPostTable(table);
    }
}