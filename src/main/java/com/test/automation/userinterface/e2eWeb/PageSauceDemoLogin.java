package com.test.automation.userinterface.e2eWeb;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("page:webdriver.base.url.saucedemo")
public class PageSauceDemoLogin extends PageObject {

    public static final Target USER_NAME_FIELD = Target.the("Campo de ingreso del usuario").locatedBy("#user-name");
    public static final Target PASSWORD_FIELD = Target.the("Campo de ingreso de contraseña").locatedBy("#password");
    public static final Target LOGIN_BUTTON = Target.the("Botón para iniciar sesión").locatedBy("#login-button");
}
