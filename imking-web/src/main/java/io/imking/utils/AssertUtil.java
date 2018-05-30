package io.imking.utils;

import io.imking.utils.exception.BaseException;
import io.imking.utils.exception.ExceptionEnum;

/**
 * 断言处理类.
 *
 * @author liunan  by 2018/5/27
 */
public final class AssertUtil {

  private AssertUtil() {
  }

  /**
   * 当flag为false时,会抛出businessExeceptionEnum异常.
   * @param  expression  异常标记
   * @param exceptionEnum 异常枚举类
   */
  public static void isTure(boolean expression, ExceptionEnum exceptionEnum) {
    if (!expression) {
      throw new BaseException(exceptionEnum);
    }
  }

  /**
   * 当flag为false时,会抛出businessExeceptionEnum异常.
   * @param expression 异常标记
   * @param exceptionEnum 异常枚举类
   * @param msgSupplement 异常补充说明
   */
  public static void isTure(boolean expression, ExceptionEnum exceptionEnum, String msgSupplement) {
    if (!expression) {
      throw new BaseException(exceptionEnum, msgSupplement);
    }
  }

  public static void isTure(boolean expression, ExceptionEnum exceptionEnum, String msgSupplement,
      Throwable cause) {
    if (!expression) {
      throw new BaseException(exceptionEnum, msgSupplement, cause);
    }
  }

  public static void isTure(boolean expression, ExceptionEnum exceptionEnum,
      Throwable cause) {
    if (!expression) {
      throw new BaseException(exceptionEnum, cause);
    }
  }
}
