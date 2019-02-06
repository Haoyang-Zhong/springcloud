package com.example.testserver;

import lombok.Data;

@Data
class Result {

	private int code;
	private String message;
	private Object content;
	private String serviceName;
	private String host;
}
