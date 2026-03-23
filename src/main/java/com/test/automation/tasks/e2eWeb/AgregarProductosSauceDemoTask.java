package com.test.automation.tasks.e2eWeb;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.test.automation.userinterface.e2eWeb.PageSauceDemoProducts.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarProductosSauceDemoTask implements Task {

    private final String producto1;
    private final String producto2;

    public AgregarProductosSauceDemoTask (String producto1, String producto2) {
        this.producto1 = producto1;
        this.producto2 = producto2;
    }
    public static AgregarProductosSauceDemoTask conProductos(String producto1, String producto2){
        return Tasks.instrumented(AgregarProductosSauceDemoTask.class, producto1, producto2);
    }
    @Step("{0} inicia sesión:")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Task.where("Ingresa Productos",
                        Click.on(String.format(AGREGAR_PRODUCTO.getCssOrXPathSelector(),this.producto1)),
                        Click.on(BOTON_AÑADIR_CARRITO),
                        WaitUntil.the(BOTON_REGRESAR_A_PRODUCTOS, isVisible()),
                        Click.on(BOTON_REGRESAR_A_PRODUCTOS),
                        Click.on(String.format(AGREGAR_PRODUCTO.getCssOrXPathSelector(),this.producto2)),
                        Click.on(BOTON_AÑADIR_CARRITO),
                        WaitUntil.the(BOTON_REGRESAR_A_PRODUCTOS, isVisible()),
                        Click.on(BOTON_REGRESAR_A_PRODUCTOS),
                        Click.on(BOTON_VER_CARRITO),
                        Click.on(BOTON_CHECKOUT)

                )
        );
    }
}
