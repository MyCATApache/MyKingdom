package io.imking.core.controller;

import io.imking.utils.Result;
import io.imking.utils.ResultEnum;
import io.imking.utils.exception.BaseException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desc: 全局异常处理类
 *
 * @date: 09/11/2017
 * @author: gaul
 */
@RestController
@ControllerAdvice
public class ExceptionHandlerController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);


  @ExceptionHandler(BaseException.class)
  public Result<String> baseExceptionExceptionHandler(HttpServletRequest request, BaseException e) {
    LOGGER.error("[GlobalExceptionHandler] [error to handle uri: {}", request.getRequestURI(), e);
    return new Result(e.getCode(), e.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public Result<String> defaultExceptionHandler(HttpServletRequest request, Exception e)
      throws Exception {
    LOGGER.error("[GlobalExceptionHandler] [error to handle uri: {}", request.getRequestURI(), e);
    return new Result<>(ResultEnum.SERVER_ERROR, e.getMessage());
  }
}
