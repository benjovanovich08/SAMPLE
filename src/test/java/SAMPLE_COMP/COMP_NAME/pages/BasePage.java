package SAMPLE_COMP.COMP_NAME.pages;

import SAMPLE_COMP.COMP_NAME.utility.BrowserUtil;
import SAMPLE_COMP.COMP_NAME.utility.ConfigurationReader;
import SAMPLE_COMP.COMP_NAME.utility.Driver;
import SAMPLE_COMP.COMP_NAME.utility.Environment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//input[@class=\'gLFyf\']")
    public WebElement searchBar;

    @FindBy (xpath = "//a[.='Sign in'][1]")
    public WebElement signInBtn;

    @FindBy (xpath = "//input[@type='email']")
    public WebElement usernameInputBox;

    @FindBy (xpath = "//input[@type='password']")
    public WebElement passwordInputBox;

    @FindBy (xpath = "//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']")
    public WebElement loginNextBtn;

    @FindBy (xpath = "//a[starts-with(@aria-label,'Google Account:')]")
    public WebElement accountVerfier;




    public void login(String userType){
        BrowserUtil.sleep(1000);
        signInBtn.click();
        if(userType.equals("admin")){
            usernameInputBox.sendKeys(Environment.ADMIN_USERNAME);
            loginNextBtn.click();
            BrowserUtil.sleep(4000);
            passwordInputBox.sendKeys(Environment.ADMIN_PASSWORD);
            loginNextBtn.click();
        }else {
            usernameInputBox.sendKeys(Environment.END_USER_USERNAME);
            loginNextBtn.click();
            BrowserUtil.sleep(4000);
            passwordInputBox.sendKeys(Environment.END_USER_PASSWORD);
            loginNextBtn.click();
        }
    }


}
