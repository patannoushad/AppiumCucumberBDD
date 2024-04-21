package com.qa.utils;



public class ElementUtils extends DriverManager {















//    AppiumDriver driver;
//    Actions actions= new Actions(driver);
//
//
//    public void clickOnElement(WebElement element)  {
//        WebElement webElement = waitForElement(element,CommonUtils.WAIT);
//        webElement.click();
//    }
//
//    public void typeTextIntoElement(WebElement element, String textToBeTyped) {
//        WebElement webElement = waitForElement(element,CommonUtils.WAIT);
//        webElement.click();
//        webElement.clear();
//        webElement.sendKeys(textToBeTyped);
//    }

//    public String getTextFromElement(WebElement element) {
//        WebElement webElement = waitForElement(element,CommonUtils.WAIT);
//        return webElement.getText();
//
//    }
//
//    public WebElement waitForElement(WebElement element, int durationInSeconds) {
//        WebElement webElement = null;
//        try {
//            WebDriverWait wait = new WebDriverWait(driver,durationInSeconds);
//            webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        return webElement;
//    }
//
//    public void selectOptionInDropdown(WebElement element, String dropDownOption, int dur) {
//        WebElement webElement = waitForElement(element, dur);
//        Select select = new Select(webElement);
//        select.selectByVisibleText(dropDownOption);
//    }
//
//    public void acceptAlert() {
//
//        Alert alert = waitForAlert(CommonUtils.WAIT);
//        alert.accept();
//
//    }
//
//    public void dismissAlert() {
//
//        Alert alert = waitForAlert(CommonUtils.WAIT);
//        alert.dismiss();
//
//    }
//
//    public Alert waitForAlert(long durationInSeconds) {
//
//        Alert alert = null;
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
//            alert = wait.until(ExpectedConditions.alertIsPresent());
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        return alert;
//
//    }
//
//    public void mouseHoverAndClick(WebElement element) {
//        WebElement webElement = waitForVisibilityOfElement(element,CommonUtils.WAIT);
//        // actions = new Actions(driver);
//        actions.moveToElement(webElement).build().perform();
//    }
//
//
//    public WebElement waitForVisibilityOfElement(WebElement element) {
//
//        WebElement webElement = null;
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, CommonUtils.WAIT);
//            webElement = wait.until(ExpectedConditions.visibilityOf(element));
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        return webElement;
//
//    }
//
//    public void javaScriptClick(WebElement element) {
//
//        WebElement webElement = waitForVisibilityOfElement(element,int durationT);
//        JavascriptExecutor jse = ((JavascriptExecutor) driver);
//        jse.executeScript("arguments[0].click();", webElement);
//
//    }
//
//    public void javaScriptType(WebElement element, String textToBeTyped, int duration) {
//
//        WebElement webElement = waitForVisibilityOfElement(element,duration);
//        JavascriptExecutor jse = ((JavascriptExecutor) driver);
//        jse.executeScript("arguments[0].value='" + textToBeTyped + "'", webElement);
//
//    }
//
//
//
//    public boolean displayStatusOfElement(WebElement element, int duration) {
//
//        try {
//            WebElement webElement = waitForVisibilityOfElement(element,duration);
//            return webElement.isDisplayed();
//        } catch (Throwable e) {
//            return false;
//        }
//
//    }
}
