package com.sofkau.ui.carulla;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class AsercionInicioSesionCarullaUI extends PageObject {
    public static final Target BOTON_CUENTA = Target.the("Boton Ingresar")
            .located(By.xpath("//span[@class='exito-login-4-x-greetingsIconContainer']//*[name()='svg']"));


    public static final Target MI_CUENTA = Target.the("Boton mi cuenta")
            .located(By.xpath("//div[contains(text(),'Mi cuenta')]"));
    public static final Target NOMBRE_USUARIO_CARULLA = Target.the("Boton del nombre de usuario")
            .located(By.xpath("(//div[normalize-space()='1035436114'])[1]"));
}
