package io.imking.utils.exception;


/**
 * 业务类异常. 比如：参数校验不通过 之类的
 *
 * @author liunan  by 2018/3/22
 */
public class BusinessException extends BaseException{

  public BusinessException(ExceptionEnum businessExceptionEnum, Throwable cause) {
    super(businessExceptionEnum.getCode(), businessExceptionEnum.getDesc(), cause);
  }

  public BusinessException(ExceptionEnum businessExceptionEnum) {
    super(businessExceptionEnum.getCode(), businessExceptionEnum.getDesc());
  }

  public BusinessException(ExceptionEnum businessExceptionEnum, String msgSupplement) {
    super(businessExceptionEnum.getCode(),
        businessExceptionEnum.getDesc() + " " + msgSupplement);
  }

  public BusinessException(ExceptionEnum businessExceptionEnum, String msgSupplement,
      Throwable cause) {
    super( businessExceptionEnum.getCode(),
        businessExceptionEnum.getDesc() + " " + msgSupplement, cause);
  }

}
