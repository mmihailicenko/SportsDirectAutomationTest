Feature: Filter functionality positive scenario
Description: filter fuinctionality testing by choosing gender and price range

Scenario Outline:

    Given I go to <web_site>
    And I am not logged in
    Then from <home_page> I click "men_category" by css
    And from <home_page> I click "men_shoes_category" by css
    Then from <men_shoes_page> I choose "firetrap_brand_filter_checkbox" by css
    And from <men_shoes_page> I choose "skechers_brand_filter_checkbox" by css
    And from <men_shoes_page> I click "price_range_filter_min" and enter "30" by id
    And from <men_shoes_page> I click "price_range_filter_max" and enter "60" by id
    When from <men_shoes_page> I click "filter_apply_button" by id
    Then from "productdescriptionbrand" I check if search contains "Skechers" and "Firetrap"
    Then from "CurrencySizeLarge" I check if search contains price from "30" to "60"

Examples:
| browser   | web_site                     | home_page   | men_shoes_page   |
| "Firefox" | "http://lv.sportsdirect.com" | "home_page" | "men_shoes_page" |
