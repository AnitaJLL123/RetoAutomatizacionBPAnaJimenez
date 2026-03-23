package com.test.automation.tasks.e2eWeb;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.test.automation.userinterface.e2eWeb.PageSauceDemoLogin.*;

public class IniciaSesionSaucedemoTask implements Task {

    private final String usuario;
    private final String contrasena;

    public IniciaSesionSaucedemoTask(String usuario, String contrasena){
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    public static IniciaSesionSaucedemoTask conLasCredenciales(String usuario, String contrasena){
        return Tasks.instrumented(IniciaSesionSaucedemoTask.class, usuario, contrasena);
    }
    @Step("{0} inicia sesión:")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Task.where("Ingresa las credenciales e inicia sesión",
                        Enter.keyValues(this.usuario).into(USER_NAME_FIELD),
                        Enter.keyValues(this.contrasena).into(PASSWORD_FIELD)),
                        Click.on(LOGIN_BUTTON)
        );
    }
}
