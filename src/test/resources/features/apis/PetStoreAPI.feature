@PetStore @karate
Feature: Gestionar Mascotas en la pagina de petStore reto

  Background:
    * header Accept = 'application/json'
    * header Content-Type = 'application/json'
    * configure ssl = true

  @id:1 @AdicionarMascota @PostPet
  Scenario Outline: T-API - Adicionar una mascota
    Given url 'https://petstore.swagger.io/v2/'
    And path 'pet'
    And def datos = read('classpath:data/apiPetStore/Pet.json')
    And set datos
      | path   | value       |
      | id     | <Id>        |
      | name   | '<NombreMascota>'  |
    And print datos
    And request datos
    When method post
    Then status 200
    And print response
    And match response.id == <Id>
    And match response.name == '<NombreMascota>'
    * def id = response.id

    Examples:
      | read('classpath:data/apiPetStore/DatosMascota.csv') |

  @id:2 @ConsultarMascotaRegistrada @GetPet
  Scenario Outline: T-API - Consultar la mascota adicionada
    * def id = call read('PetStoreAPI.feature@AdicionarMascota')
    * def id_Masc = id.response.id
    Given url 'https://petstore.swagger.io/v2/pet/'
    And path id_Masc
    When method get
    Then status 200
    And print response
    And match response.id == <Id>
    And match response.name contains '<NombreMascota>'

    Examples:
      | read('classpath:data/apiPetStore/DatosMascota.csv') |

  @id:3 @ModificarNombreMascota @PutPet
  Scenario Outline: T-API - Modificar el nombre de la mascota adicionada y estatus
    Given url 'https://petstore.swagger.io/v2/pet/'
    And def datos = read('classpath:data/apiPetStore/Pet.json')
    And set datos
      | path   | value                      |
      | id     | <Id>                       |
      | name   | '<ModificarNombreMascota>' |
      | status | '<Status>'                 |
    And print datos
    And request datos
    When method put
    Then status 200
    And print response
    And match response.id == <Id>
    And match response.name == '<ModificarNombreMascota>'
    And match response.status == '<Status>'

    Examples:
      | read('classpath:data/apiPetStore/DatosMascota.csv') |

  @id:4 @ConsultarMascotaPorEstatus @GetPetByStatus
  Scenario Outline: T-API - Consultar la mascota modificada por estatus
    * call read('PetStoreAPI.feature@ModificarNombreMascota')

    Given url 'https://petstore.swagger.io/v2'
    And path 'pet', 'findByStatus'
    And param status = '<Status>'
    When method get
    Then status 200
    And print response
    And match response == '#[]'
    And match each response[*].status == '<Status>'
    * def mascota = karate.filter(response, function(x){ return x.name == '<ModificarNombreMascota>' })
    * if (mascota.length > 0) karate.match(mascota[0].name, '<ModificarNombreMascota>')

    Examples:
      | read('classpath:data/apiPetStore/DatosMascota.csv') |

