package pages;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class GunceMethods extends BaseMethods {

    private final By EMAIL_INPUT = By.id("Email");
    private final By PASSWORD_INPUT = By.id("password-field");
    private final By firstcaptcha = By.xpath("//*[@role='checkbox']");


    private final By SIGN_IN_BUTTON = By.xpath("//*[@type='submit']");

    @Step("Sign in with <email> and <password>")
    public void login(String email, String password) {

       // driver.get().send(Network.clearBrowserCache());
        setText(EMAIL_INPUT, email);
        wait(1);
        setText(PASSWORD_INPUT, password);
        wait(1);

    }

    @Step("hit the captcha")
    public void implementation2() {
//wait(5);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id='enableCaptcha']/div/div/iframe")));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='recaptcha-checkbox-border']")));
        element.click();
        wait(3);
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        wait(2);
    }



    @Step("hit sign in button")
    public void implementation3() {
        click(SIGN_IN_BUTTON);
    }

    @Step("kullanici girisi yaptigini dogrular")
    public void implementation1() {
        assertThat("kullanici girisi yaptigini dogrulama", driver.getCurrentUrl(), is("https://app.gunce.com/Home/Dashboard"));

    }

//===============================================

    private final By buromuz = By.xpath("//*[text()='Büromuz']");
    private final By ekip_arkadaslarimiz = By.xpath("//*[text()='Ekip Arkadaşlarımız ']");
    private final By ekleButonu = By.xpath("(//*[@class='font-size-13 font-weight-600'])[1]");
    private final By nameBox = By.xpath("//*[@class='form-control empty is-invalid']");
    private final By unvanDropDown = By.id("select2-ParameterTitleId-container");
    private final By grupFirmasiDropDown = By.xpath("(//*[@class='select2-selection select2-selection--single'])[2]");
    private final By calismaGrubuDropDown = By.xpath("(//*[@class='select2-selection select2-selection--single'])[3]");
    private final By identityNumber = By.id("IdentityNumber");
    private final By gunceKullaniciRadioButton = By.xpath("//input[@value='False'])[1]");
    private final By buroIci = By.xpath("//*[contains(text(),'Büro İçi')]");
    private final By kisiselButonu = By.xpath("//a[@class='nav-link text-uppercase active show']");
    private final By birthday = By.xpath("//*[@class='form-control calendarDate is-valid']");
    private final By cinsiyetErkek = By.xpath("//*[@for='Erkek']");
    private final By uyruk = By.xpath("//*[contains(text(),'T.C')]");
    private final By calisanTipi = By.cssSelector("aria-labelledby=\\\"select2-PrmEmployeeRecordTypeId-container");
    private final By kaydetveKapat = By.xpath("//*[@class='gunceFonts gi-confirm-action']");
    private final By acilDurumKisisi = By.id("EmergencyReachPerson");


    @Step("kullanici menuden buromuz ekip arkadaslarimiz sayfasina gider")
    public void implementation4() {
        click(buromuz);
        click(ekip_arkadaslarimiz);
        click(ekleButonu);
    }



    @Step("ekip arkadaslarimiz listesinde olusturulan kaydin yer aldigi dogrulanir<name><surname><Rumuz><identityNo>")
    public void implementation6(String name,String surname,String Rumuz,String identityNo) {

        setText(nameBox,"Hasan");
        Select select=new Select((WebElement) unvanDropDown);
        select.selectByVisibleText("A1");

        Select selectGrupFirmasi=new Select((WebElement) grupFirmasiDropDown);
        selectGrupFirmasi.selectByVisibleText("Sigorta");



    }



}
