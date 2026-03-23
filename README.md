EJERCICIO E2E - SerenityBDD
1. Estrategia de pruebas según la HU descrita
2. Todos los Test corren correctamente
3. Genera los Task, user interface, model etc correctamente
4. Genera Readme con las instrucciones del test
   URL: https://www.saucedemo.com/

5. CONFIGURACIONES
1. TENER INSTALADO LAS SIGUIENTES HERRAMIENTAS
   1.1 IntelliJ IDEA 2024.3.7 (Community Edition) 
   1.2 GRADLE
   1.3 plugins Cucumber y Gherkin
   1.4 JDK 21.0.3
   1.5 Configurada las variables de Entorno

2. Ejecutar Ejercicio
Una vez instalado, hay que realizar las modificaciones en las siguientes librerias, para poder ejecutar.
En el Serenity Properties, comentar lo siguiente
#====>CONFIG DRIVER
#webdriver.driver=appium  (Comentar)
webdriver.driver=chrome (Quitar Comentario)
Posterior en la carpeta src/test/java/com/test/automation/runners/WebRunnerTest
cambiar el tag por el siguiente: @saucedemo
Una Vez modificado, dar click derecho y RUN, con esto se ejeutara la automatizacion E2ESaucedemo
Adicional en la carpeta de ReportesAutomatizaciones, se coloco el target de la ejecuciones, en las cuales pueden ir al index y visualizar la ejecución de las automatizaciones.

EJERCICIO API - Karate
Nota: se evidencia intermitencia en algunos sevicios.
1. Test corren correctamente (todos los métodos)
2. Genera los informes
3. Genera los features optimizados y utilización de variables
4. Genera escenarios outline con consumo csv o json
   Consulta en la siguiente URL del swagger el contrato de la api para gestionar
   Mascotas:
   URL Swagger: https://petstore.swagger.io/#/
   API: https://petstore.swagger.io/v2/
Ejecutar Ejercicio
5. En la carpeta src/test/java/com/test/automation/runners/ApiRunnerTest, dar clik derecho y ejecutar RUN
Se ejecutara el ejercicio, el reporte del mismo se encuentra en la carperta ReportesAutomatizaciones