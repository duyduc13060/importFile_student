package com.example.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.example.entity.Student;


public interface StudentService {

	void writeFile(String document) throws IOException, ParseException;

	List<Student> findByHoTenLike(String hoTen);

	List<Student> findAll();

	List<Student> findByMahsLike(String mahs);


}
