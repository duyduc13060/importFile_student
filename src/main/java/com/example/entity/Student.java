package com.example.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "students")
public class Student implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String truong;

	private String quanHuyen;

	private String mahs;

	private String lop;

	private String hoTen;

	private Date ngaySinh;
	
	private String gioiTinh;

	private String noiSinh;

	private String danToc;

	private String hoKhau;

	private String dienThoai;

	private Integer diem1;
	
	private Integer diem2;
	
	private Integer diem3;
	
	private Integer diem4;
	
	private Integer diem5;
	
	private Double tongDiem;
	
	private Double diemUuTien;
	
	private Double tongDiemSoTuyen;
	
	private String ghiChu;

}
