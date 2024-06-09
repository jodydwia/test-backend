package com.springboot.backend.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonPropertyOrder({
		"success",
		"message"
})
public class ApiResponse implements Serializable {

	@JsonIgnore
	private static final long serialVersionUID = 7702134516418120340L;

	@JsonProperty("success")
	private Boolean success;

	@JsonProperty("message")
	private String message;

	public ApiResponse() {

	}

	public ApiResponse(Boolean success, String message) {
		this.success = success;
		this.message = message;
	}
}
