package io.imking.utils;

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
	private int status;
	private String desc;
	private T data;

	public Result(ResultEnum resultEnum) {
		this.status = resultEnum.getCode();
		this.desc = resultEnum.getDesc();
	}

	public Result(ResultEnum resultEnum, T data) {
		this.status = resultEnum.getCode();
		this.desc = resultEnum.getDesc();
		this.data = data;
	}

	public Result(int status, String desc) {
		this.status = status;
		this.desc = desc;
	}

	public Result<T> ok(T data) {
		this.data = data;
		this.status = ResultEnum.SUCCESS.getCode();
		this.desc = ResultEnum.SUCCESS.getDesc();
		return this;
	}
	
	public Result<T> error(T data) {
		this.data = data;
		this.status = ResultEnum.SERVER_ERROR.getCode();
		this.desc = ResultEnum.SERVER_ERROR.getDesc();
		return this;
	}
}
