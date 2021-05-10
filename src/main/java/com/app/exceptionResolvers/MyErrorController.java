package com.app.exceptionResolvers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

public class MyErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		return null;
	}

	@RequestMapping("/error")
	public String handleError() {
		// do something like logging
		return "error";
	}
}
