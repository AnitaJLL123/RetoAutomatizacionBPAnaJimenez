package com.test.automation.tasks.e2eWeb;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.test.automation.userinterface.e2eWeb.PageSauceDemoProducts.*;

public class FormularioSauceDemoTask implements Task {
    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public FormularioSauceDemoTask(String firstName, String lastName, String postalCode){
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }
    public static FormularioSauceDemoTask conDatosFormulario(String firstName, String lastName, String postalCode){
        return Tasks.instrumented(FormularioSauceDemoTask.class, firstName, lastName,postalCode);
    }
    @Step("{0} inicia sesión:")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Task.where("Ingresa Productos",
                        Enter.keyValues(this.firstName).into(FIRST_NAME),
                        Enter.keyValues(this.lastName).into(LAST_NAME),
                        Enter.keyValues(this.postalCode).into(POSTAL_CODE),
                        Click.on(BOTON_CONTINUAR)
                )
        );
    }
}
