Feature: Buscar un usuario desconocido
  Como usuario de una applicacion
  necesito conocer informacion de un usuario desconocido

  Background:
    Given que el usuario de la aplicacion se encuentre en home page

  Scenario: Buscar un usuario por su id
    When el usuario de la aplicacion ejecuta la busqueda con el codigo 2
    Then el usuario deberia obtener el resultado valido

  Scenario: Buscar usuarios con codigo invalido
    When el usuario de la aplicacion busca con el codigo 3
    Then el usuario deberia obtener el resultado fallido

