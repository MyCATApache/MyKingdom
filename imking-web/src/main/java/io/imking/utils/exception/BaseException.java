package io.imking.utils.exception;


/**
 * 基础异常类.
 *
 * @author liunan  by 2018/5/27
 */
public class BaseException extends RuntimeException {

  private int code;
  private String desc;



  public BaseException(ExceptionEnum exceptionEnum, Throwable cause) {
    this(exceptionEnum.getCode(), exceptionEnum.getDesc(), cause);
  }

  public BaseException(ExceptionEnum exceptionEnum) {
    this( exceptionEnum.getCode(), exceptionEnum.getDesc());
  }

  public BaseException(ExceptionEnum exceptionEnum, String msgSupplement) {
    this(exceptionEnum.getCode(),
        exceptionEnum.getDesc() + " " + msgSupplement);
  }

  public BaseException(ExceptionEnum exceptionEnum, String msgSupplement,
      Throwable cause) {
    this(exceptionEnum.getCode(),
        exceptionEnum.getDesc() + " " + msgSupplement, cause);
  }


  BaseException( int errorCode, String message, Throwable cause) {
    super(message, cause);
    this.desc = message;
    this.code = errorCode;
  }

  BaseException(int errorCode, String message) {
    super(message);
    this.desc = message;
    this.code = errorCode;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }


}
