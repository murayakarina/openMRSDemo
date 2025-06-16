    package general;

    import config.ApplicationConfigReader;
    import com.mysql.cj.exceptions.AssertionFailedException;
    import org.junit.Assert;
    import org.openqa.selenium.*;
    import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;


    import java.awt.*;

    import java.util.ArrayList;
    import java.util.List;

    import static general.WebDriverFactory.getDriver;

    public class SeleniumFunctions {

        String device = ApplicationConfigReader.getConfig().getDevice();

        public void iHaveGivenInputWithDelay(By Locator, String textboxvalue) {
            try {
                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
                {
                    WebElement input = WebDriverFactory.getDriver().findElement(Locator);
                    Thread.sleep(2000);
                    while (!input.getAttribute("value").equals("")) {
                        input.sendKeys(Keys.BACK_SPACE);
                    }
                    input.clear();
                    for (int i = 0; i < textboxvalue.length(); i++) {
                        input.sendKeys(String.valueOf(textboxvalue.charAt(i)));
                        Thread.sleep(1000);
                    }

                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not on screen", Locator));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is Stale", Locator));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not in desired state", Locator));
            } catch (Exception e) {
                throw new AssertionFailedException(String.format("The element provided {0} is invalid", Locator));
            }
        }


        public void IhaveGivenInput(By Locator, String textboxvalue) {
            try {
                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 25);
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
                {
                    WebElement input = WebDriverFactory.getDriver().findElement(Locator);
                    Thread.sleep(2000);
                    while (!input.getAttribute("value").equals("")) {
                        input.sendKeys(Keys.BACK_SPACE);
                    }
                    input.clear();
                    input.sendKeys(textboxvalue);
                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not on screen", Locator));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is Stale", Locator));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not in desired state", Locator));
            } catch (Exception e) {
                throw new AssertionFailedException(String.format("The element provided {0} is invalid", Locator));
            }
        }

        public void IHaveGivenInputWithoutBackSpace(By Locator, String textboxvalue) {
            try {
                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
                {
                    WebElement input = WebDriverFactory.getDriver().findElement(Locator);
                    Thread.sleep(2000);
                    input.clear();
                    input.sendKeys(textboxvalue);
                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not on screen", Locator));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is Stale", Locator));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not in desired state", Locator));
            } catch (Exception e) {
                throw new AssertionFailedException(String.format("The element provided {0} is invalid", Locator));
            }
        }


        public void PressButton(By Locator) {
            try {

                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 25);
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
                {
                    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(Locator));
                    {
                        button.click();
                    }
                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not on screen", Locator));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is Stale", Locator));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not in desired state", Locator));
            } catch (Exception e) {
                throw new AssertionFailedException(String.format("The element provided {0} is invalid", Locator));
            }
        }

        public void doubleClick(By Locator) {
            try {
                Actions act = new Actions(WebDriverFactory.getDriver());
                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
                {
                    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(Locator));
                    {
                        act.doubleClick(button).perform();
                    }
                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not on screen", Locator));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is Stale", Locator));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not in desired state", Locator));
            } catch (Exception e) {
                throw new AssertionFailedException(String.format("The element provided {0} is invalid", Locator));
            }
        }

        public void ClickingOn(By locator) {
            try {

                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 25);

                wait.until(ExpectedConditions.elementToBeClickable(locator));
                {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                    {
                        wait.until(ExpectedConditions.elementToBeClickable(locator));
                        {
                            WebElement link = WebDriverFactory.getDriver().findElement(locator);
                            link.click();
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }


        public void uploadDocument(String FileName) {
            try {
                if (device.equals("Windows")) {
                    GeneralFunctions.fileSelectionforWindows(FileName);
                }
                if (device.equals("Linux")) {
                    GeneralFunctions.fileSelectionForLinux(FileName);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        public void VerificationMessageByMessage(By Locator, String message) {

            try {
                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
                {
                    Assert.assertEquals(WebDriverFactory.getDriver().findElement(Locator).getText(), message);
                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not on screen", Locator));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is Stale", Locator));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not in desired state", Locator));
            } catch (Exception e) {
                throw new AssertionFailedException(String.format("The element provided {0} is invalid", Locator));
            }

        }

        public String getText(By Locator) {

            try {
                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
                {
                    return WebDriverFactory.getDriver().findElement(Locator).getText();
                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not on screen", Locator));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is Stale", Locator));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not in desired state", Locator));
            } catch (Exception e) {
                throw new AssertionFailedException(String.format("The element provided {0} is invalid", Locator));
            }

        }

        public void VerificationMessageByPartialText(By Locator, String message) {

            try {
                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
                {
                    Assert.assertTrue(WebDriverFactory.getDriver().findElement(Locator).getText().contains(message));
                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not on screen", Locator));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is Stale", Locator));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not in desired state", Locator));
            } catch (Exception e) {
                throw new AssertionFailedException(String.format("The element provided {0} is invalid", Locator));
            }

        }

        public static void scrollDropDown(By Locator, String ListLocator) {
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
            WebElement Combobox = wait.until(ExpectedConditions.elementToBeClickable(Locator));
            {
                Combobox.click();
                JavascriptExecutor je = (JavascriptExecutor) getDriver();
                WebElement element = getDriver().findElement(By.xpath(ListLocator));
                je.executeScript("window.scrollTo(100,0);", element);
                element.click();
            }
        }

        public void SelectCombo(By Locator, By ListLocator, String value) {
            try {
                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
                WebElement Combobox = wait.until(ExpectedConditions.elementToBeClickable(Locator));
                {
                    Combobox.click();
                    Thread.sleep(3000);

                    wait.until(ExpectedConditions.visibilityOfElementLocated(ListLocator));
                    {
                        ArrayList<WebElement> comboValues = new ArrayList<>(Combobox.findElements(ListLocator));
                        {
                            String check = "";
                            for (WebElement element : comboValues) {

                                if (value.contentEquals(element.getText())) {
                                    check = element.getText();
                                    Thread.sleep(200);
                                    element.click();
                                    break;
                                }
                            }
                            if (check.isEmpty()) {
                                throw new Exception("No value found in Dropdown");
                            }
                        }
                    }

                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided " + Locator + " is not on screen"));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided " + Locator + " is Stale"));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided " + Locator + " is not in desired state"));
            } catch (Exception ex) {
                throw new AssertionFailedException(String.format(ex.getMessage()));
            }

        }


        public void ClickCheckBox(By locator, String value) {

            WebDriver driver = WebDriverFactory.getDriver();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
            try {
                wait.until((ExpectedConditions.presenceOfElementLocated(locator)));
                {
                    WebElement Checkbox = WebDriverFactory.getDriver().findElement(locator);
                    {
                        Checkbox.click();
                    }
                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided " + locator + " is not on screen"));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided " + locator + " is Stale"));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided " + locator + " is not in desired state"));
            } catch (Exception ex) {
                throw new AssertionFailedException(String.format(ex.getMessage()));
            }

        }

        public void navigate(String url) {

            WebDriverFactory.getDriver().navigate().to(url);
        }


        public void isExist(By Locator) {

            try {
                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 25);
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
                {

                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not on screen", Locator));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is Stale", Locator));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not in desired state", Locator));
            } catch (Exception e) {
                throw new AssertionFailedException(String.format("The element provided {0} is invalid", Locator));
            }
        }


        public void hower(By locator) {

            try {
                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
                Actions actions = new Actions(WebDriverFactory.getDriver());
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                {
                    Robot robot = new Robot();
                    robot.mouseMove(0, 1050);
                    Thread.sleep(3000);
                    actions.moveToElement(WebDriverFactory.getDriver().findElement(locator)).click().build().perform();

                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not on screen", locator));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is Stale", locator));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not in desired state", locator));
            } catch (Exception e) {
                throw new AssertionFailedException(String.format("The element provided {0} is invalid", locator));
            }
        }

        public void hoverToElement(By locator) {

            try {
                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
                Actions actions = new Actions(WebDriverFactory.getDriver());
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                {
                    Robot robot = new Robot();
                    robot.mouseMove(0, 1050);
                    Thread.sleep(3000);
                    actions.moveToElement(WebDriverFactory.getDriver().findElement(locator)).build().perform();

                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not on screen", locator));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is Stale", locator));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not in desired state", locator));
            } catch (Exception e) {
                throw new AssertionFailedException(String.format("The element provided {0} is invalid", locator));
            }
        }

        public void scrollToElement(By locator) {

            WebElement ele = getDriver().findElement(locator);

            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", ele);

        }

        public void scrollUp() {
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("scroll(0, -250);");
        }

        public void verifyListCount(By locator, int count) {

            try {
                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                {
                    Assert.assertEquals(WebDriverFactory.getDriver().findElements(locator).size(), count);
                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not on screen", locator));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is Stale", locator));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not in desired state", locator));
            } catch (Exception e) {
                throw new AssertionFailedException(String.format("The element provided {0} is invalid", locator));
            }
        }

        public static int getListCount(By locator) {

    //       if(WebDriverFactory.getDriver().findElements(locator).isEmpty())
    //          return 0;
    //       return WebDriverFactory.getDriver().findElements(locator).size();
            try {
                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 25);
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                {
                    return WebDriverFactory.getDriver().findElements(locator).size();
                }

            } catch (Exception e) {
                System.out.print(e);
            }
            return 0;
        }


        public void getTextNotNull(By Locator) {

            try {
                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
                {
                    Assert.assertNotNull(WebDriverFactory.getDriver().findElement(Locator).getText());
                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not on screen", Locator));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is Stale", Locator));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not in desired state", Locator));
            } catch (Exception e) {
                throw new AssertionFailedException(String.format("The element provided {0} is invalid", Locator));
            }

        }

        public void VerificationTextOfListElement(By Locator, String message) {

            try {
                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
                {
                    List<WebElement> element = WebDriverFactory.getDriver().findElements(Locator);
                    for (int i = 0; i < element.size(); i++) {
                        Assert.assertEquals(element.get(i).getText(), message);
                    }
                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not on screen", Locator));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is Stale", Locator));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not in desired state", Locator));
            } catch (Exception e) {
                throw new AssertionFailedException(String.format("The element provided {0} is invalid", Locator));
            }

        }

        public void VerificationTextOfListElement(By Locator, String[] elements) {

            try {
                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
                {
                    List<WebElement> element = WebDriverFactory.getDriver().findElements(Locator);
                    for (int i = 1; i < element.size(); i++) {
                        Assert.assertEquals(element.get(i).getText(), elements[i - 1]);
                    }
                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not on screen", Locator));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is Stale", Locator));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not in desired state", Locator));
            } catch (Exception e) {
                throw new AssertionFailedException(String.format("The element provided {0} is invalid", Locator));
            }

        }

        public void multiTextVerificationOfListElement(By Locator, String message1, String message2) {

            try {
                WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
                {
                    List<WebElement> element = WebDriverFactory.getDriver().findElements(Locator);
                    for (int i = 0; i < element.size(); i++) {
                        if (!(element.get(i).getText().equals(message1))) {
                            Assert.assertEquals(element.get(i).getText(), message2);
                        } else {
                            Assert.assertEquals(element.get(i).getText(), message1);
                        }
                    }
                }
            } catch (ElementNotVisibleException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not on screen", Locator));
            } catch (StaleElementReferenceException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is Stale", Locator));
            } catch (InvalidElementStateException e) {
                throw new AssertionFailedException(String.format("The element provided {0} is not in desired state", Locator));
            } catch (Exception e) {
                throw new AssertionFailedException(String.format("The element provided {0} is invalid", Locator));
            }

        }


        public void searchForm(String naveen) {
        }

        public void refreshPage() {
           getDriver().navigate().refresh();
        }
        public void hitEnterOnTableSearch() {
            getDriver().findElement(By.id("table-search-input")).sendKeys(Keys.ENTER);
        }
        public void deleteSearchResponse() {
            getDriver().findElement(By.id("table-search-input")).sendKeys(Keys.BACK_SPACE);
            getDriver().findElement(By.id("table-search-input")).sendKeys(Keys.BACK_SPACE);
            getDriver().findElement(By.id("table-search-input")).sendKeys(Keys.BACK_SPACE);
        }
        public void closeWindow() {
            getDriver().close();
        }
        public void switchToPreviousWindow(String originalWindow) {
            getDriver().switchTo().window(originalWindow);
        }


    }