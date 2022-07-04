package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class MultipleWindowsPage extends BaseSeleniumPage {
    @FindBy(xpath = "//a[@href='/windows/new']")
    private WebElement clickHereButton;

    @FindBy(xpath = "//h3")
    private WebElement header;

    public MultipleWindowsPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getClickHereButton() {
        return clickHereButton;
    }

    public ArrayList<String> getAllWindowsTitles() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    public void switchToTab(int number) {
        driver.switchTo().window(getAllWindowsTitles().get(number - 1));
    }

    public String getHeader() {
        return header.getText();
    }

    public void closeTab() {
        driver.close();
    }
}
