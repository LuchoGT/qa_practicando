Feature: Automatización de una Prueba de Login

  @example
  Scenario: Probando probando 1 2 1 2
    Given Abrir el navegador y navegar a la página de inicio de sesión
    When Introducir un "luchozgonzales" y "TeamLef2025" válidos
    And hago click en el botón de inicio de sesion
#    And verificar login exitoso
    And hago click en el boton de notificaciones
    And hago scrolling vertical
    And selecciono una notificacion aleatoria
    And ingreso a la notificacion aleatoria