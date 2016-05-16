Feature: Deve ser possível para procurar emprego em diversas áreas, http://www.indeed.pt

Scenario: Procurar Técnico de Electrónica Automação e Comando em Aveiro
    Given Eu quero saber a oferta de emprego de emprego na área de Electrónica Automação e Comando
    When Eu procurar por Electrónica Automação e Comando
    Then Eu deveria ser capaz de obter uma resposta referente a área de Electrónica Automação e Comando, e poder enviar o meu e-mail para receber notificações referente a pesquisa
