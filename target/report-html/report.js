$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/historiaBack.feature");
formatter.feature({
  "name": "Metodos de exemplos utilizando biblioteca typicode",
  "description": "  Eu como .....\n  Quero ....\n  Para ....",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Obter posts",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@back"
    }
  ]
});
formatter.step({
  "name": "que eu envio a url para obter posts",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.HistoriaBackStep.queEuEnvioAUrlParaObterPosts()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "eu envio um post para consultar",
  "keyword": "When "
});
formatter.match({
  "location": "steps.HistoriaBackStep.euEnvioUmPostParaConsultar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "eu vejo na resposta as informações do post consultado",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.HistoriaBackStep.euVejoNaRespostaAsInformaçõesDoPostConsultado()"
});
formatter.result({
  "status": "passed"
});
});