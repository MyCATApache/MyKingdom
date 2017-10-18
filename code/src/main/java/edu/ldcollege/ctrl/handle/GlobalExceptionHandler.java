package edu.ldcollege.ctrl.handle;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.ldcollege.exception.RestRespErrorException;
import edu.ldcollege.util.RestResult;
import edu.ldcollege.util.RestStatus;

/**
 * 
 * 全局异常处理
 * @author Raindrops on 20171018
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * rest 业务错误处理
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(RestRespErrorException.class)
	@ResponseBody
	public RestResult handleRestRespErrorException(HttpServletRequest request, Exception ex) {
		RestRespErrorException exception = null;
		if (ex instanceof RestRespErrorException) {
			exception = (RestRespErrorException) ex;
		}
		if (logger.isInfoEnabled()) {
			logger.info("do handleRestRespErrorException ==> [code={},error={}]",exception.getStatus(),exception.getMsg());
		}
		if (exception == null) {
			return new RestResult(RestStatus.ERROR_SERVER, null);
		}
		RestStatus status = exception.getRestStatus();
		return new RestResult(status, null);
	}
	
	/**
	 * 未知BUG处理
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public RestResult handleException(HttpServletRequest request, Exception ex) {
		logger.error("do handleException ==> [error={}]",ex.getMessage());
		return new RestResult(RestStatus.ERROR_SERVER, null);
	}
	
}
