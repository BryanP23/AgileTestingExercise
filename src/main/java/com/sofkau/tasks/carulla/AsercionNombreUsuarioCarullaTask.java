package com.sofkau.tasks.carulla;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sofkau.ui.carulla.AsercionInicioSesionCarullaUI.BOTON_CUENTA;
import static com.sofkau.ui.carulla.AsercionInicioSesionCarullaUI.MI_CUENTA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class AsercionNombreUsuarioCarullaTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BOTON_CUENTA, isVisible()),
                WaitUntil.the(BOTON_CUENTA, isClickable()),
                Click.on(BOTON_CUENTA),
                WaitUntil.the(MI_CUENTA, isClickable()),
                Click.on(MI_CUENTA)
                );
    }
    public static AsercionNombreUsuarioCarullaTask asercionNombreUsuarioCarullaTask(){return new AsercionNombreUsuarioCarullaTask();
    }
}
