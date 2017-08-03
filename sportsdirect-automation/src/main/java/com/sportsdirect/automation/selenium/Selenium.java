package com.sportsdirect.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Selenium {

    private static WebDriverWait wait;

    public static void click(WebElement element) {
        element.click();
    }

    public static void sendKeys(WebElement element, String key) {
        element.sendKeys(key);
    }

    public static WebElement findElementById(WebDriver driver, String element) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(element)));
        return driver.findElement(By.id(element));
    }

    public static WebElement findElementByXpath(WebDriver driver, String element) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
        return driver.findElement(By.xpath(element));
    }

    public static WebElement findElementByCssSelector(WebDriver driver, String element) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(element)));
        return driver.findElement(By.cssSelector(element));
    }

    public static void checkForPresentElements(WebDriver driver, String filterObject, String firstFilterArg, String secondFilterArg) throws Exception {
        Thread.sleep(1000); //will fail if no wait, needs a better solution
        List<WebElement> allProducts = driver.findElements(By.className(filterObject));
        for (WebElement element : allProducts) {
            if (!element.getText().equals(firstFilterArg) && !element.getText().equals(secondFilterArg)) {
                System.out.println("Error: Filtering is not working properly, recheck objects");
            }
        }
    }

    public static void checkForElementsInRange(WebDriver driver, String filterObject, int minAmount, int maxAmount) throws Exception {
        Thread.sleep(1000); //will fail if no wait, needs a better solution
        List<WebElement> allProducts = driver.findElements(By.className(filterObject));
        String temp;
        for (WebElement element : allProducts) {
            temp = element.getText().substring(0, element.getText().indexOf(","));
            if (Integer.valueOf(temp) < minAmount && Integer.valueOf(temp) > maxAmount) {
                System.out.println("Error: Filtering is not working properly, recheck amounts");
            }
        }
    }
}

