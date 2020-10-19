package co.edu.eam.sistema_mensajeria_consumidor.exceptions;

public class NotFoundException extends BusinessException {

  public NotFoundException(String message, String errorCode) {
    super(message, errorCode);
  }

  public NotFoundException(String message) {
    super(message);
    setErrorCode("entity_not_found");
  }
}
