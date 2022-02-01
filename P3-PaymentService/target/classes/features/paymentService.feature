Feature: Procesar una petición de pago
  A la página le llega la información de un pago y esta tiene que devolver un código y un mensaje sobre el resultado
  de la transacción

  Scenario Outline: Transacciones
    Given Una información de pago
    When Se envía la información con <code>
    Then Se obtiene un código <paymentCode>
    And Se obtiene un mensaje <paymentMsg>
    
    Examples:
		| code| paymentCode | message |
		| 0 | 0 | "Todo correcto" |
		| 1 | 1 | "Tarjeta caducada" |
		| 2 | 2 | "Saldo insuficiente" |
		| 3 | 3 | "Saldo diario superado" |
