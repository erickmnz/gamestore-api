package com.lz.gamestore.resources.exceptions;

public class DefaultError {
	
	private long time;
	private Integer status;
	private String msg;
	
	public DefaultError() {
		
	}
	
	public DefaultError(long time, Integer status, String msg) {
		super();
		this.time = time;
		this.status = status;
		this.msg = msg;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
	
}
