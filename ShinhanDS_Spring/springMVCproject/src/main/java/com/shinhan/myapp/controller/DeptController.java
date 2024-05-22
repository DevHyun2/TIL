package com.shinhan.myapp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.firstzone.myapp.dept.DeptDTO;
import org.firstzone.myapp.dept.DeptService;
import org.firstzone.myapp.emp.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	DeptService dService;
	
	@Autowired
	EmpService eService;
	
	@GetMapping("/deptList.do")
	public void retrieve(Model model, HttpServletRequest request) {
		model.addAttribute("deptlist", dService.selectAll());
		String result="";
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap != null) {
			result = (String)flashMap.get("deptResult");
			
		}
		model.addAttribute("deptResult", result);
		
		//return이 void인 경우 다음과 같다. ==> return "dept/deptList";
		//forward 된다.
	}
	
	@GetMapping("/deptInsert.do")
	public ModelAndView insert(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mlist", eService.selectAllManager());
		mv.setViewName("dept/deptInsert");
		return mv;
	}
	
	@PostMapping("/deptInsert.do")
	public String insertDB(DeptDTO dept, 
			Integer deptid2, 
			Integer department_id,
			RedirectAttributes redirectAttr) {
		
		int result =dService.deptInsert(dept);
		String message;
		if(result > 0) {
			message = "insert success";
		} else {
			message = "insert fail";
		}
		redirectAttr.addFlashAttribute("deptResult", message);
		//redirect: 이 없다면 default로 forward이다. 즉 요청의 주소는 그대로이고 보여지는 page는 jsp이다.
		// request.getRequestDipatcher("페이지이름").forward(request, response)
		//redirect: 이 있다면 재요청을 의미한다. 새로운 요청이므로 주소가 바뀐다. 이 때 request는 전달되지 않는다.
		//response.redirect("요청주소")
		return "redirect:deptList.do";
	}
	
	@GetMapping("/deptUpdate.do")
	public String detail(Model model , 
			@RequestParam("deptid") Integer id,
			HttpServletRequest request,
			HttpSession session) {
		
		
		model.addAttribute("dept", dService.selectById(id));
		return "dept/deptUpdate";
	}
	
	@PostMapping("/deptDetail.do")
	public String deptInfoView(Model model,@ModelAttribute("dept") DeptDTO dept) {
		model.addAttribute("mlist", eService.selectAllManager());
		return "dept/deptUpdate_DB";
	}

	
	@PostMapping("/deptDBUpdate.do")
	public String deptDBUpdate(DeptDTO dept, RedirectAttributes redirectAttr) {
		int result = dService.deptUpdate(dept);
		String message;
		if(result > 0) {
			message = "update success";
		} else {
			message = "update fail";
		}
		redirectAttr.addFlashAttribute("deptResult", message);
		return "redirect:deptList.do";
	}
	
	@GetMapping("/deptDelete.do") 
	public String deptDelete(@RequestParam("deptid") Integer department_id,
			HttpServletRequest request, RedirectAttributes redirectAttr) {
		String deptid = request.getParameter("department_id");
		System.out.println("Spring 이 전달 : " + deptid);
		System.out.println("Servlet API 이용 : " + department_id);
		int result = dService.deptDelete(department_id);
		String message;
		if(result > 0) {
			message = "delete success";
		} else {
			message = "delete fail";
		}
		redirectAttr.addFlashAttribute("deptResult", message);
		return "redirect:deptList.do";
	}
	
}