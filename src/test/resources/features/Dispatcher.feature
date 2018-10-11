Feature: Dispatcher

  @test1
  Scenario Outline: Cautare simpla -
    Given I login on dispatcher with admin credentials
    Then I check if page is "Main Page" and title is "Transmiterea fara drept a datelor catre terti se pedepseste penal"
    And I navigate to "Cautari Simple" tab
    Then I check if page is "Cautari Simple Page" and title is "Cautare simpla persoane fizice"
    When I type "<nume>" in "Nume" on page "Cautari Simple Page"
    And I type "<prenume>" in "Prenume" on page "Cautari Simple Page"
    And I select "<gender>" from "Sex" list on page "Cautari Simple Page"
    And I type "<cnp>" in "CNP" on page "Cautari Simple Page"
    And I type "<motivulInterogarii>" in "Motivul Interogarii" on page "Cautari Simple Page"
    And I click on "Cauta" from page "Cautari Simple Page"


    Examples:
      | nume      | prenume | gender | cnp           | motivulInterogarii |
      | O'DONOHUE | BAILEY  | M      | 1630703162801 | testAutomat        |
