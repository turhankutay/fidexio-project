package com.fidexio.pages;

import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FidexioLogOutPage {

    public FidexioLogOutPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement usernameInTheUpperRightCorner;

    @FindBy(linkText = "Log out")
    public WebElement logoutLink;

    @FindBy(xpath = "//h4[@class='modal-title']")
    public WebElement expiredAlert;

}
