import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class StepImplementation extends BaseTest{

    @Ignore
    @Step("deneme spec")
    public void appDeneme(){
        MobileElement el1 = (MobileElement) appiumDriver.findElementByAccessibilityId("Turkish Airlines");
        el1.click();
        MobileElement el2 = (MobileElement) appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.TextView");
        el2.click();

    }


    @Step("<id> id li elemente tıkla")
    public void clickById(String id){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30);
        MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        element.click();
    }

    @Step("<id> id li elemente <key> değerini yaz")
    public void sendKeys(String id, String key){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30);
        MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        element.sendKeys(key);
    }

    @Step("<xpth> xpath li elemente tıkla")
    public void clickByXpath(String xpth) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30);
        MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpth)));
        element.click();
    }

    @Step("<xpth> xpath li elemente <key> değerini yaz")
    public void sendKeysXpath(String xpth, String key){
        appiumDriver.findElement(By.xpath(xpth)).sendKeys(key);
    }

    @Step("<id> accesibility id li elemente tıkla")
    public void clickByAccessibilityId(String id){
        appiumDriver.findElementByAccessibilityId(id).click();
    }

    @Step("<id> id li elementi kontrol et")
    public void chechkFlight(String id){
        Assert.assertTrue(appiumDriver.findElementByXPath(id).isDisplayed());
    }

    @Step("Tarih seçimi yap <xpth>")
    public void selectDate(String xpth){

        List<MobileElement> dateSelect = (List<MobileElement>) appiumDriver.findElementsByXPath(xpth);
        dateSelect.get(0).isSelected();
        int selected = 0;
        for(MobileElement element : dateSelect){
            if (element.isSelected()){
                selected = dateSelect.indexOf(element) + 2;
            }
        }
        dateSelect.get(selected).click();
    }

    @Step("Uçuş seç <xpth>")
    public void selectFlight(String xpth){
        List<MobileElement> flightSelect = (List<MobileElement>) appiumDriver.findElementsByXPath(xpth);
        Random rnd = new Random();
        int randFlight = rnd.nextInt(flightSelect.size());
        flightSelect.get(randFlight).click();
    }
}