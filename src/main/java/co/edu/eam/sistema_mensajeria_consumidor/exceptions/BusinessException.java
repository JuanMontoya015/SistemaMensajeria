package co.edu.eam.sistema_mensajeria_consumidor.exceptions;

public class BusinessException extends  RuntimeException {

  private String errorCode;

  public BusinessException(String message) {
    super(message);
  }

  public BusinessException(String message, String errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }
}
