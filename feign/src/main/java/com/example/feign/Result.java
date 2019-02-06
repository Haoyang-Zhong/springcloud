package com.example.feign;


import lombok.Data;

@Data
public class Result {
	private int code;

	private String message;

	private Object content;

	private String serviceName;

	private String host;

}
