package com.shinhan.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

//global exception처리
@ControllerAdvice
public class ExceptionHandlerController {

	Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

	@ExceptionHandler(Exception.class)
	public String errorProcess500(Exception ex) {
		logger.warn("===500오류입니다.======");
		logger.warn(ex.getClass().getPackageName());
		logger.warn(ex.getClass().getSimpleName());
		logger.warn(ex.getMessage());
		ex.printStackTrace();
		return "error/error500";
	}
	
	//요청주소가 잘못, 문제:static 자원과 충돌\
	//*.do 요청 => DispatcherServlet 받아서 handler가 없는 주소이면 오류를 일으킨다
	//			 static자원과 충돌안하고 잘 수행한다
	// /* -> 문제:static 자원과 충돌
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerError404(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("errorMessage", "404오류");
		mv.addObject("url", request.getRequestURL());
		mv.setViewName("error/error404");
		return mv;
	}

}

/*
 * 
 * @ExceptionHandler(Exception.class) public String aa(Exception ex) {
 * System.out.println("=500=============="); System.out.println(ex.getClass());
 * System.out.println(ex.getMessage()); return "error/errorPage500"; }
 * 
 * @ExceptionHandler(NoHandlerFoundException.class)
 * //@ResponseStatus(HttpStatus.NOT_FOUND) public ModelAndView
 * handlerError404(HttpServletRequest request) {
 * System.out.println("=404=============="); ModelAndView mv = new
 * ModelAndView(); mv.addObject("errorMessage", "404오류"); mv.addObject("url",
 * request.getRequestURL()); mv.setViewName("error/errorPage404"); return mv; }
 * 
 */
