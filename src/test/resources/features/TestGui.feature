Feature: test gui

  @test1
  Scenario: Login test
    Given I login on dispatcher with admin credentials
    Then I check if page is "MainPage" and title is "Transmiterea fara drept a datelor catre terti se pedepseste penal"
    And I click on "Cauta" from page "Common Page"
