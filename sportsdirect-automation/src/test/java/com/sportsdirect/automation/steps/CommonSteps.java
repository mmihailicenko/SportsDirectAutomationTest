package com.sportsdirect.automation.steps;

import com.sportsdirect.automation.selenium.Selenium;
import com.sportsdirect.automation.utility.JsonUtility;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import static com.sportsdirect.automation.utility.MailUtility.retrieveRecoveryLink;


public class CommonSteps {

    private static final String GECKO_DRIVER_PATH = "C:\\Java Projects\\";
    private static WebDriver driver;

    @Before
    public void start_driver() {
        System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH + "geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @After
    public void close_driver() {
        driver.quit();
    }

    @Given("^I am not logged in$")
    public void i_am_not_logged_in() {
        Assert.assertNotNull(Selenium.findElementById(driver, JsonUtility.JsonFileParsing("home_page", "login_element")));
    }

    @When("^I go to \"([^\"]*)\"$")
    public void i_go_to_a_website(String URL) {
        driver.get(URL);
        if (driver.findElement(By.cssSelector(JsonUtility.JsonFileParsing("home_page", "pop_up"))).isDisplayed()) {
            Selenium.click(Selenium.findElementByCssSelector(driver, JsonUtility.JsonFileParsing("home_page", "pop_up")));
        }
    }

    @Then("^from \"([^\"]*)\" I (?:navigate to|click|choose) \"([^\"]*)\" by id$")
    public void from_a_webpage_I_make_action_by_id(String key, String value) {
        Selenium.click(Selenium.findElementById(driver, JsonUtility.JsonFileParsing(key, value)));
    }

    @Then("^from \"([^\"]*)\" I (?:navigate to|click|choose) \"([^\"]*)\" by css$")
    public void from_a_webpage_I_make_action_by_css(String key, String value) {
        Selenium.click(Selenium.findElementByCssSelector(driver, JsonUtility.JsonFileParsing(key, value)));
    }

    @Then("^from \"([^\"]*)\" I (?:navigate to|click|choose) \"([^\"]*)\" by xpath")
    public void from_a_webpage_I_make_action_by_xpath(String key, String value) {
        Selenium.click(Selenium.findElementByXpath(driver, JsonUtility.JsonFileParsing(key, value)));
    }

    @Then("^from \"([^\"]*)\" I click \"([^\"]*)\" and enter \"([^\"]*)\" by id$")
    public void from_I_click_and_enter_by_id(String key, String value, String amount) {
        Selenium.sendKeys(Selenium.findElementById(driver, JsonUtility.JsonFileParsing(key, value)), amount);
    }

    @Then("^from \"([^\"]*)\" I check if search contains \"([^\"]*)\" and \"([^\"]*)\"$")
    public void from_I_check_if_search_contains_and(String filterObject, String firstFilterArg, String secondFilterArg) throws Exception {
        Selenium.checkForPresentElements(driver, filterObject, firstFilterArg, secondFilterArg);
    }

    @Then("^from \"([^\"]*)\" I check if search contains price from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void from_I_check_if_search_contains_price_from_to(String filterObject, int minAmount, int maxAmount) throws Exception {
        Selenium.checkForElementsInRange(driver, filterObject, minAmount, maxAmount);
    }

    @When("^I get the recovery link from \"([^\"]*)\" and navigate to it$")
    public void i_get_the_recovery_link_from_and_navigate_to_it(String arg1) {
        String host = "pop.gmail.com";
        String mailStoreType = "pop3";
        String username = "mmtest4finance@gmail.com";
        String password = "MMtest123";
        String recoveryLink = retrieveRecoveryLink(host, mailStoreType, username, password);
        driver.get(recoveryLink);
    }

    @Then("^from \"([^\"]*)\" I check for message \"([^\"]*)\" by id$")
    public void from_I_check_for_message_by_id(String key, String value) {
        Assert.assertNotNull(Selenium.findElementById(driver, JsonUtility.JsonFileParsing(key, value)));
    }
}