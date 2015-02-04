package com.blog.web.interceptor;


public class AjaxException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Integer code;

	public AjaxException() {
        super();
    }

    public AjaxException(String message) {
        super(message);
    }

    public AjaxException(String message, Throwable cause) {
        super(message, cause);
    }

    public AjaxException(Integer code) {
    	super(code + "");
    	this.code = code;
    }

	public Integer getCode() {
		return code;
	}
}
