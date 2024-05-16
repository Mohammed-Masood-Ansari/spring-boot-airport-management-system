package com.jspider.airport_management_system.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ApplicationResponse<T> {

	private int statusCode;
	private String message;
	private String description;
	private T data;
}
