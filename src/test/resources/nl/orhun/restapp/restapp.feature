Feature: Getting persons from the system

  Scenario: As user I want to get all persons
    When I request persons from the system
    Then I get a response with status 200
    And I get a list of 4 persons
    And field [0].id has value 1
    And field [0].first_name has value Jeanette
    And field [0].last_name has value Penddreth
    And field [0].gender has value Female
    And field [0].ip_address has value 26.58.193.2
    And field [0].email has value jpenddreth0@census.gov
    And field [1].first_name has value Giavani
