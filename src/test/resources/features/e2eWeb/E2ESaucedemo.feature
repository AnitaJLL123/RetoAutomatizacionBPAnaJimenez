@Saucedemo @RetoE2E
Feature: Compra exitosa en SauceDemo
  Como cliente autenticado
  Quiero realizar una compra de productos
  Para validar el flujo E2E hasta la confirmación fi

@id:1 @PruebaE2E
Scenario Outline: T-E2E-Compra exitosa en SauceDemo
Given el cliente inicia sesion con usuario "<username>" y contrasena "<password>"
When agrega los productos "<producto1>" y "<producto2>" al carrito y visualiza el carrito
And completa el formulario de compra con nombre "<firstName>", apellido "<lastName>" y codigo postal "<postalCode>"
Then finaliza la compra y visualiza el mensaje de confirmacion "Thank you for your order!"

Examples:
  | @externaldata@e2eWeb/DatosSauceDemo.csv |