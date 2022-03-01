#enconding: UTF-8
#language: pt
Funcionalidade: Buscar informação no Google
  Contexto: Abrir url google
    Dado eu ingresso na home de google na opção de me sinto com sorte

  @front
  Cenario: Verificar que seja possivel retornar os sites a partir das coicidencias de um texto especifico
    Quando eu envio um texto "Gardel"
    Entao deve mostrar coincidencias sobre o texto enviado "Gardel"