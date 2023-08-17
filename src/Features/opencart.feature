Feature: Open cart adding item to the cart
  Background:
    Given user open the browser and pass the url "https://awesomeqa.com/ui/"

#  @datavalidation
#  Scenario Outline:To validate the login feature with vlid data
#    When user click on my account and click on login
#    And pass Uname <un> Password <pwd>
#    And click on login button
#    Then validate user is on myaccount page
#    Examples:
#    | un  | pwd |
#    |deekshithgowda9897@gmail.com|Blackfield@562123|
#    |manojms@gmail.com           |msmanoju         |
#    |wrongpassword@gmail.com     |wrongpassword    |
#    |msmanojugmail.com           |msmanoj          |

    @cart
    Scenario: To validate cart feature
      When login with username "deekshithgowda9897@gmail.com" and password "Blackfield@562123"
      And mousehover on camera and click and select the item "Canon EOS 5D"
      And select the avilable options
      And click on add to cart
      Then verify valid product is added in shopping cart





