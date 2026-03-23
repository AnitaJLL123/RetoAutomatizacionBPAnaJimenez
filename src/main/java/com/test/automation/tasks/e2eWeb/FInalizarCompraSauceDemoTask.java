package com.test.automation.tasks.e2eWeb;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.test.automation.userinterface.e2eWeb.PageSauceDemoProducts.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FInalizarCompraSauceDemoTask implements Task {

    private final String mensaje;

    public FInalizarCompraSauceDemoTask(String mensaje) {
        this.mensaje = mensaje;
    }

    public static Performable coninformacionfinalizar(String mensaje){
        return instrumented(FInalizarCompraSauceDemoTask.class, mensaje);
    }

    @Step("{0} finaliza la compra y valida el mensaje de confirmacion")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_FINALIZAR_COMPRA),
                Ensure.that(VALIDA_MENSAJE).text().isEqualTo(mensaje),
                Click.on(BOTON_REGRESAR_HOME),
                Ensure.that(VALIDA_INFORMACION).isDisplayed()
        );
    }
}