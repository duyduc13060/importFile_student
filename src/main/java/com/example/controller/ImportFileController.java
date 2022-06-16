package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.StudentService;

@Controller
@MultipartConfig
@RequestMapping("/ghtk")
public class ImportFileController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	HttpSession session;

	@GetMapping("/display")
	public String index() {
		return "display/student";
	}

	@PostMapping("/import")
	public String importFile(
			HttpServletRequest request) throws IOException, ParseException, ServletException {
	
		String storeFd = request.getServletContext().getRealPath("/upload");
		if (!Files.exists(Path.of(storeFd))) {
			Files.createDirectory(Path.of(storeFd));
		}

		Part document = request.getPart("uploadFile");
		System.out.println(document);
		
		File photoFile = new File(storeFd,document.getSubmittedFileName());
		document.write(photoFile.getAbsolutePath());
		String fileDocument = photoFile.getAbsolutePath();

		session.setAttribute("message", "File import successful");
		
		studentService.writeFile(fileDocument);
		

		return "display/student";
	}

}
