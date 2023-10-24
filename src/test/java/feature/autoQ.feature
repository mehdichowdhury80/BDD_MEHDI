Feature: Validation AAA Northeast popup

  @smoke
  Scenario: Auto quote test
    Given homepage title is 'Welcome to AAA Northeast'
    And subtitle is 'To ensure you receive the best service possible, <br>, please enter your zIpcode below'
    And footer is ' AAA Northeast serves members in CT,MA, MH,NJ, NY & RI, '
    When user click submit button
    Then verify zipcode error message is 'Please enter a valid zipcode so we can direct you to the,<br>, Website in your area'
    When user input zipcode 'abvd'
    Then verify zipcode length is '5'
    When user click zipcode field
