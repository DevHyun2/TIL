package com.shinhan.myapp.controller;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.firstzone.myapp.dept.DeptService;
import org.firstzone.myapp.emp.EmpDTO;
import org.firstzone.myapp.emp.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinhan.myapp.util.DateUtil;

@Controller
@RequestMapping("/emp")
public class EmpController {
	// @Autowired�� Ÿ���� ������ �ڵ����� Injection
	@Autowired
	EmpService eService;
	
	@Autowired
	DeptService dService;
	
	@RequestMapping("/empAll2.do")
	public String empAll2(Model model, HttpSession session ,Integer deptSelect, String jobSelect, Date hdate, Integer salary) {
		//������ ������ session�� �����ϱ�
		session.setAttribute("deptSelect", deptSelect);
		session.setAttribute("jobSelect", jobSelect);
		session.setAttribute("hdate", hdate);
		session.setAttribute("salary", salary);
		
		if(salary == null) salary = 0;
		//Date startDate = DateUtil.getSQLDate(hdate);
		List<EmpDTO> emplist2 = eService.selectByCondition(deptSelect, jobSelect, hdate, salary);
		
		model.addAttribute("emplist",emplist2);
		model.addAttribute("deptlist",dService.selectAll());
		model.addAttribute("joblist",eService.selectAllJob());
		
		return "emp/emplist";
	}
	@RequestMapping("/empAll.do")
	public String empAll(Model model, Integer deptid, String jobid) {
		List<EmpDTO> emplist2 = null;
		// �μ������ΰ��
		// ��å�����ΰ��
		// ������ȸ�ΰ��
//		if(deptid== null && jobid == null) {
//			emplist = eService.selectAll();
//		}else {
//			// �μ���ȸ�ϱ�
//			if(deptid!= null && jobid == null) {
//				if(deptid == 0) {
//					emplist = eService.selectAll();
//				}else {
//					emplist = eService.selectBydept(deptid);
//				}
//			}else {
//				// ��å��ȸ�ϱ�
//				if(jobid.equals("all")) {
//					emplist = eService.selectAll();
//				}else {
//					emplist = eService.selectByJob(jobid);
//				}
//			}	
//		}
		if(deptid==null) deptid = 0;
		emplist2 = eService.selectByCondition(deptid, jobid, null, 0);
		
		model.addAttribute("emplist",emplist2);
		model.addAttribute("deptlist",dService.selectAll());
		model.addAttribute("joblist",eService.selectAllJob());
		// view�̸��� return �ȴ�. 
		// ViewResolver�� ���λ� + view�̸� + ���̻�
		// view�� forward�ȴ�. (�ּҴ� �ٲ��� ����)
		return "emp/emplist";
	}
	
	@GetMapping("/empDetail.do")
	public void detail(Model model, 
			@RequestParam("empid") Integer empid2) {
		model.addAttribute("empInfo",eService.selectById(empid2));
		model.addAttribute("deptlist",dService.selectAll());
		model.addAttribute("mlist",eService.selectAllManager());
		model.addAttribute("joblist",eService.selectAllJob());
	}
	// �Է�â�����ֱ�
	@GetMapping("/empInsert.do")
	public void insertDisplay(Model model) {
		model.addAttribute("deptlist",dService.selectAll());
		model.addAttribute("mlist",eService.selectAllManager());
		model.addAttribute("joblist",eService.selectAllJob());
	}
	// DB�� �Է��ϱ�
	@PostMapping("/empInsert.do")
	public String insertDB(EmpDTO emp) {
		System.out.println("insertȮ��(JavaBean):" + emp);
		eService.empInsert(emp);
		return "redirect:empAll.do";
	}
	
	// DB�� �����ϱ�
	@PostMapping("/empDetail.do")
	public String updateDB(EmpDTO emp) {
		System.out.println("upadateȮ��(JavaBean):" + emp);
		eService.empUpdate(emp);
		return "redirect:empAll.do";
	}
	
	// DB�� �����ϱ�
	@GetMapping("/empDelete.do")
	public String deleteDB(int empid) {
		System.out.println("deleteȮ��(JavaBean):" + empid);
		eService.empDelete(empid);
		return "redirect:empAll.do";
	}
	
	
	@GetMapping("/empIdCheck.do")
	@ResponseBody
	public String test(Integer empid) {
		EmpDTO emp = eService.selectById(empid);
		if(emp == null) return "0";
		return "1";
	}
}
/*
 * @ResponseBody response.getWriter().append("1")
 */




