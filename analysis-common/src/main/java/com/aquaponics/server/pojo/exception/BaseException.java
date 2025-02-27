package com.aquaponics.server.pojo.exception;

/**
 *  业务异常
 * @author qht
 */
public class BaseException extends RuntimeException{
	public BaseException(String message) {
		super(message);
	}
}
