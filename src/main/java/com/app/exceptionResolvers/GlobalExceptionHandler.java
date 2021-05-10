package com.app.exceptionResolvers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.exceptions.AdminControllerException;
import com.app.exceptions.CatchAllException;
import com.app.exceptions.CustomerException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(CatchAllException.class)
	public String handleError(Model model) {
		return "redirect:/";
	}

	
	@ExceptionHandler(AdminControllerException.class)
	public String handleAdminError(HttpServletRequest request, Exception e, Model model, HttpSession hs) {
		System.out.println(model.getAttribute("message"));
		
		return "redirect:/admin/admin_dashboard";
	}
	
	@ExceptionHandler(CustomerException.class)
	public String handleCustomerError(HttpServletRequest request, Exception e, Model model) {
		System.out.println(model.getAttribute("message"));
		return "redirect:/";
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handleAllError(HttpServletRequest request, Exception e, Model model) {
		System.out.println(model.getAttribute("message"));
		return "redirect:/";
	}
	
	
}
