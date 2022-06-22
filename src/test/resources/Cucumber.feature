Feature: Film Actor tests
  Scenario: Created a dummy Film Actor to populate values and to then test the assert values on,
  This is to confirm my inbuilt methods in realtime application work, also due to it being 3NF I wanted to
  have code coverage and proof of testing methods at least as some tests done in mockito couldn't be applied to it.

    Given I have Film Actor Field Details
    When Set the Actor Id
    And I set the Film Id


    Then The Film Actor returns the values


