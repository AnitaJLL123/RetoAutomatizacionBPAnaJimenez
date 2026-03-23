package com.test.automation.userinterface.e2eWeb;

import net.serenitybdd.screenplay.targets.Target;

public class PageSauceDemoProducts {
    //Carrito
    public static final Target AGREGAR_PRODUCTO = Target.the("Agregar producto")
            .locatedBy("//div[text()='%s']");
    public static final Target BOTON_AÑADIR_CARRITO = Target.the("Añadir al Carrito")
            .locatedBy("//button[text()='Add to cart']");

    public static final Target BOTON_REGRESAR_A_PRODUCTOS = Target.the("Regresar a Productos")
            .locatedBy("//button[@id='back-to-products']");

    public static final Target BOTON_VER_CARRITO = Target.the("Ver Carrito")
            .locatedBy("//*[contains(@class, 'shopping_cart_link')]");

    public static final Target BOTON_CHECKOUT = Target.the("boton checkout")
            .locatedBy("//*[@id='checkout']");
    //formulario
    public static final Target FIRST_NAME = Target.the("nombre")
            .locatedBy("//*[@id='first-name']");
    public static final Target LAST_NAME = Target.the("apellido")
            .locatedBy("//*[@id='last-name']");
    public static final Target POSTAL_CODE = Target.the("codigo postal")
            .locatedBy("//*[@id='postal-code']");
    public static final Target BOTON_CONTINUAR = Target.the("Boton continuar")
            .locatedBy("//*[@id='continue']");
    //finalizar compra
    public static final Target BOTON_FINALIZAR_COMPRA = Target.the("Boton finalizar compra")
            .locatedBy("//*[@id='finish']");
    public static final Target VALIDA_MENSAJE = Target.the("Mensaje Thank you for your order!")
            .locatedBy("//h2[normalize-space()='Thank you for your order!']");
    public static final Target BOTON_REGRESAR_HOME = Target.the("Boton regresarhome")
            .locatedBy("//*[@id='back-to-products']");
    public static final Target VALIDA_INFORMACION = Target.the("Valida Informacion")
            .locatedBy("//span[text()='Products']");

    public static final Target PRODUCT_TITLE = Target.the("Titulo de lista de Productos")
            .locatedBy("//span[contains(text(), 'Products')]");

}