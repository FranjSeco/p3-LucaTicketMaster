Feature: Procesar una petición de pago
  A la página le llega la información de un pago y esta tiene que devolver un código y un mensaje sobre el resultado
  de la transacción

  Scenario: Transacción correcta
    Given Una información de pago
    When Se procesa la información
    Then Se obtiene un código del 0 al 6
    And Se obtiene un mensaje "Todo correcto"
	Scenario: Tarjeta caducada
    Given Una información de pago
    When Se procesa la información
    Then Se obtiene el código 7
    And Se obtiene un mensaje "Tarjeta caducada"

  Scenario: Saldo insuficiente
    Given Una información de pago
    When Se procesa la información
    Then Se obtiene el código 8
    And Se obtiene un mensaje "Saldo insuficiente"

  Scenario: Superado gasto diario
    Given Una información de pago
    When Se procesa la información
    Then Se obtiene el código 9
    And Se obtiene un mensaje "Gasto diario superado" 
  
  