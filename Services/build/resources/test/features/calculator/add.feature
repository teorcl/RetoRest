Feature: Buscar moneda con CodigoISO
  Como usuario de una applicacion
  necesito buscar Con el codigoISO
  para poder traer el tipo de moneda con ese codigoISO



  Scenario: Buscar usuarios con codigo valido
    Given que el usuario de la aplicacion se encuentre en home page
    When el usuario de la aplicacion ejecuta la busqueda con el codigo 2
    Then el usuario deberia obtener el resultado valido
  Scenario: Buscar usuarios con codigo invalido
    Given que el usuario de la aplicacion esta en pagina principal
    When el usuario de la aplicacion busca con el codigo 23
    Then el usuario deberia obtener el resultado fallido

