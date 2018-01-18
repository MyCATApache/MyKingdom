package io.imking.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Desc:
 *
 * @date: 09/11/2017
 * @author: gaul
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Result<T> {
	private int code;
	private String desc;
	private T data;

	public Result(ResultEnum resultEnum) {
		this.code = resultEnum.getCode();
		this.desc = resultEnum.getDesc();
	}

	public Result(ResultEnum resultEnum, T data) {
		this.code = resultEnum.getCode();
		this.desc = resultEnum.getDesc();
		this.data = data;
	}

	public Result<T> ok(T data) {
		this.data = data;
		this.code = ResultEnum.SUCCESS.getCode();
		this.desc = ResultEnum.SUCCESS.getDesc();
		return this;
	}
	
	public Result<T> error(T data) {
		this.data = data;
		this.code = ResultEnum.SERVER_ERROR.getCode();
		this.desc = ResultEnum.SERVER_ERROR.getDesc();
		return this;
	}
}
