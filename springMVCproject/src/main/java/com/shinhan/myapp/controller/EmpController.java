package com.shinhan.myapp.controller;

import java.util.List;

import org.firstzone.myapp.dept.DeptService;
import org.firstzone.myapp.emp.EmpDTO;
import org.firstzone.myapp.emp.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	//@Autowired = type�� ������ �ڵ����� Injection
	@Autowired
	EmpService eService;
	
	@Autowired
	DeptService dService;
	
	@RequestMapping("/empAll.do")
	public String empAll(Model model) {
		
		List<EmpDTO> emplist = eService.selectAll();
		model.addAttribute("empList", emplist);
		
		//view�̸��� return�ȴ�.
		//ViewResolver : ���λ� + view�̸� + ���̻�
		//view�� forward ��(�ּ� �ȹٲ�)
		return "emp/emplist";
	}
	
	@GetMapping("/empDetail.do")
	public void empDetail(Model model,
						@RequestParam("empid") int empid2) {
		model.addAttribute("emp",eService.selectById(empid2));
		model.addAttribute("deptlist",dService.selectAll());
		model.addAttribute("mlist",eService.selectAllManager());
		model.addAttribute("joblist",eService.selectAllJob());
	}
	
	@GetMapping("/empInsert.do")
	public void empInsert(Model model) {
		model.addAttribute("deptlist",dService.selectAll());
		model.addAttribute("mlist",eService.selectAllManager());
		model.addAttribute("joblist",eService.selectAllJob());
	}
	
	//DB���Է�
	@PostMapping("/empInsert.do")
	public String insertDB(EmpDTO emp) {
		System.out.println("insertȮ��(JavaBean):" + emp);
		eService.empInsert(emp);
		return "redirect:empAll.do";
	}
	
	@GetMapping("/empIdCheck.do")
	@ResponseBody //response.getWriter().append("1")
	public String test(Integer empid) {
		EmpDTO emp = eService.selectById(empid);
		if(emp==null) return "0";
		return "1";
	}
}
