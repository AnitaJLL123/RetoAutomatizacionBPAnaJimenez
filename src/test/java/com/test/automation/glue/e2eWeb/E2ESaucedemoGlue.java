package com.test.automation.glue.e2eWeb;

import com.test.automation.tasks.e2eWeb.AgregarProductosSauceDemoTask;
import com.test.automation.tasks.e2eWeb.FInalizarCompraSauceDemoTask;
import com.test.automation.tasks.e2eWeb.FormularioSauceDemoTask;
import com.test.automation.tasks.e2eWeb.IniciaSesionSaucedemoTask;
import com.test.automation.userinterface.e2eWeb.PageSauceDemoLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class E2ESaucedemoGlue {

    @Given("el {actor} inicia sesion con usuario {string} y contrasena {string}")
    public void elClienteIniciaSesionConUsuarioYContrasena(Actor actor, String usuario, String contrasena) {
        givenThat(actor).attemptsTo(Open.browserOn().the(PageSauceDemoLogin.class));
        when(theActorInTheSpotlight()).wasAbleTo(
                IniciaSesionSaucedemoTask.conLasCredenciales(usuario, contrasena)
        );
    }

    @When("agrega los productos {string} y {string} al carrito y visualiza el carrito")
    public void agregaLosProductosYAlCarritoYVisualizaElCarrito(String producto1,String producto2) {
        when(theActorInTheSpotlight()).wasAbleTo(
                AgregarProductosSauceDemoTask.conProductos(producto1, producto2)
        );
    }

    @When("completa el formulario de compra con nombre {string}, apellido {string} y codigo postal {string}")
    public void completaElFormularioDeCompraConNombreApellidoYCodigoPostal(String firstName, String lastName, String postalCode) {
        when(theActorInTheSpotlight()).wasAbleTo(
                FormularioSauceDemoTask.conDatosFormulario(firstName, lastName, postalCode)
        );
    }

    @Then("finaliza la compra y visualiza el mensaje de confirmacion {string}")
    public void finalizaLaCompraYVisualizaElMensajeDeConfirmacion(String mensaje) {
        and(theActorInTheSpotlight()).attemptsTo(
                FInalizarCompraSauceDemoTask.coninformacionfinalizar(mensaje)
        );
    }
}
