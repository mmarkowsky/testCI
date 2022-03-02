Feature: Metodos de exemplos utilizando biblioteca typicode
  Eu como .....
  Quero ....
  Para ....


  Scenario: Obter posts
    Given que eu envio a url para obter posts
    When eu envio um post para consultar
    Then eu vejo na resposta as informações do post consultado

  @back
  Scenario: Obter posts enviando tabla
    Given que eu envio a url para obter posts
    When eu envio um post para consultar
    Then eu vejo na resposta as informações Title , Body, UserId  do post consultado
      | titulo             | comentario      | userId |
      | "Testando Titulo" | "Testando" | "12"   |