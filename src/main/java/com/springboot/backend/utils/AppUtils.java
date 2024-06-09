package com.springboot.backend.utils;

import com.springboot.backend.exception.AnyException;
import org.springframework.http.HttpStatus;

public class AppUtils {
	public static void validatePageNumberAndSize(int page, int size) {
		if (page < 1) {
			throw new AnyException(HttpStatus.BAD_REQUEST, "Page number cannot be less than one.");
		}

		if (size < 1) {
			throw new AnyException(HttpStatus.BAD_REQUEST, "Size number cannot be less than one.");
		}

		if (size > AppConstants.MAX_PAGE_SIZE) {
			throw new AnyException(HttpStatus.BAD_REQUEST, "Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
		}
	}
}
