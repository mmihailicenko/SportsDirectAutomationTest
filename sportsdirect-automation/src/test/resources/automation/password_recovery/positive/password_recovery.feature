Feature: Password recovery functionality positive scenario
Description: password recovery testing

Scenario Outline:

    Given I go to <web_site>
    And I am not logged in
    Then from <home_page> I click "login_element" by id
    And from <login_page> I click "forgotten_password_link" by id
    Then from <password_recovery_page> I click "email_address_input_label" and enter "mmtest4finance@gmail.com" by id
    And from <password_recovery_page> I click "send_email_button" by id
    When I get the recovery link from "mmtest4finance@gmail.com" and navigate to it
    Then from "new_password_page" I click "enter_new_password" and enter "MMtest123" by id
    And from "new_password_page" I click "confirm_new_password" and enter "MMtest123" by id
    Then from "new_password_page" I click "change_password_button" by id
    Then from "password_change_confirmation_page" I check for message "password_reset_success" by id
    Then from "password_change_confirmation_page" I click "continue_button" by id
    Then from <home_page> I click "account" by id
    And from <home_page> I click "log_out" by css

Examples:
| browser   | web_site                     | home_page   | login_page   | password_recovery_page   |
| "Firefox" | "http://lv.sportsdirect.com" | "home_page" | "login_page" | "password_recovery_page" |