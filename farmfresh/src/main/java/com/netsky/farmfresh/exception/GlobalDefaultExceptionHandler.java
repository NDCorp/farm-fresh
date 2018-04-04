package com.netsky.farmfresh.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","The Page is not constructed");
		
		mv.addObject("errorDescription","The page you are looking for now is not available.");
		
		mv.addObject("title", "404 Error Page");
		
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","The Page is not constructed");
		
		mv.addObject("errorDescription","The product you are looking for is not available right now.");
		
		mv.addObject("title", "Product Unavailable");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception exception) {
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","Contact your Administrator");
		
		mv.addObject("errorDescription","Something went wrong. Please try that again. Exception: " + exception.toString());
		
		mv.addObject("title", "Error");
		
		return mv;
	}
}
