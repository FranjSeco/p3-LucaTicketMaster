Feature: Procesar una petición de pago
  A la página le llega la información de un pago y esta tiene que devolver un código y un mensaje sobre el resultado
  de la transacción

  Scenario Outline: Transacciones
    Given Una información de pago
    When Se envía la información con <code>
    Then Se obtiene un código <paymentCode>
    Then Se obtiene un mensaje <paymentMsg>
    
    Examples:
		| code| paymentCode | paymentMsg |
		| 0 | 0 | "Todo correcto" |
		| 7 | 1 | "Tarjeta rechazada" |
		| 8 | 2 | "Saldo insuficiente en la cuenta" |
		| 9 | 3 | "Superado el saldo diario" |
