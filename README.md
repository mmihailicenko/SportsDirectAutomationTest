# SportsDirectAutomationTest
Automation tests for SportsDirect website 
Made for 4finance test assignment

Frameworks used:
Selenium and Cucumber

Firefox browser will open only using geckodriver.
For correct run please change GECKO_DRIVER_PATH in CommonSteps class to location of your geckodriver.exe (https://github.com/mozilla/geckodriver/releases)

In order to run please deliberately "run" SportsDirectTest class

Attention: Selenium.checkForElementsInRange(); and Selenium.checkForPresentElements(); are unstable and can fail time to time, please rerun tests to get positive results. This will continue until a better solution can be found.
