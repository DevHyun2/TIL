package com.shinhan.firstzone.controller2;

import java.util.Map;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AppErrorController  extends AbstractErrorController  {

	public AppErrorController(ErrorAttributes errorAttributes) {
		super(errorAttributes);
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model,Exception ex) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String page="error/error500";
        if(status != null){
            int statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
            	model.addAttribute("msg", "해당 페이지를 찾을 수 없습니다!!!");
            	page = "error/error404";
            } else {
            	model.addAttribute("msg", "처리중 에러 발생!!!");
            	ErrorAttributeOptions options = ErrorAttributeOptions
            		    .defaults().including(ErrorAttributeOptions.Include.MESSAGE);
            	Map<String, Object> body = getErrorAttributes(request, options );
            	System.out.println(body);
            	model.addAttribute("errInfo", body);       
            }
        }
        return page;
    }
	
}
