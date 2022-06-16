package com.example.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Student;

public interface StudentReponsitory extends JpaRepository<Student, Long> {

	List<Student> findByHoTenLike(String hoTen);
	
	List<Student> findByMahsLike(String mahs);
}
