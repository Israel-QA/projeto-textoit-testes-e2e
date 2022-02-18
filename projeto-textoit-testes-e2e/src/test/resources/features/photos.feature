#Author: israel.r.santos@outlook.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@PhotosTeste
Feature: Validar dados dos albuns de fotos pelo Id
  
  Scenario: Validar dados do objeto pelo id = 6
    Given Que eu acessei a pagina "https://jsonplaceholder.typicode.com"
    And acessei o menu Guide
    And cliquei no link photos 
    When Eu copiei os dados apresentados na tela 
    And salvei os dados em um array json
    Then Eu validei os dados do objeto com o id = <id>, albumId = <albumId>, title = <title>, url = <url> e thumbnailUrl = <thumbnailUrl>
    And fechei o browser

    Examples:
    | albumId | id | title                                     | url 																		  | thumbnailUrl 														 |
    | 1				| 6  | "accusamus ea aliquid et amet sequi nemo" | "https://via.placeholder.com/600/56a8c2" | "https://via.placeholder.com/150/56a8c2" |
    