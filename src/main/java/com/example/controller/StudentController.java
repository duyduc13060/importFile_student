package com.example.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Student;
import com.example.service.StudentService;

@Controller
@RequestMapping("/ghtk")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/index")
	public String display(Model modelMap

	) {
		List<Student> lStudents = studentService.findAll();
		modelMap.addAttribute("listStudent", lStudents);

		return "display/form";
	}

	@GetMapping("/search")
	public String search(
			Model modelMap, 
			@RequestParam(name = "hoTen", required = false) String hoten,
			@RequestParam(name = "mahs", required = false) String masinhvien
	) {

		List<Student> lStudents = null;
		if (!StringUtils.hasText(hoten) && !StringUtils.hasText(masinhvien)) {
			lStudents = studentService.findAll();
			modelMap.addAttribute("listStudent", lStudents);
		} else if (StringUtils.hasText(hoten) && !StringUtils.hasText(masinhvien)) {
			lStudents = studentService.findByHoTenLike("%" + hoten + "%");
			modelMap.addAttribute("listStudent", lStudents);
			System.out.println(hoten);
		} else {
			lStudents = studentService.findByMahsLike("%" + masinhvien + "%");
			modelMap.addAttribute("listStudent", lStudents);
			System.out.println(masinhvien);
		}

		return "display/form";

	}

}
