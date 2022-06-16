package com.example.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.reponsitory.StudentReponsitory;
import com.example.service.StudentService;

@Service
public class ImplStudentService implements StudentService {

	@Autowired
	StudentReponsitory studentReponsitory;

//	public static final int COLUMN_INDEX_ID = 0;
	public static final int COLUMN_INDEX_SCHOOL = 1;
	public static final int COLUMN_INDEX_DISTRICT = 2;
	public static final int COLUMN_INDEX_STUDENTID = 3;
	public static final int COLUMN_INDEX_CLASSROOM = 4;
	public static final int COLUMN_INDEX_FULLNAME = 5;

	public static final int COLUMN_INDEX_DAY = 6;
	public static final int COLUMN_INDEX_MONTH = 7;
	public static final int COLUMN_INDEX_YEAR = 8;
	
	
	public static final int COLUMN_INDEX_GENDER = 9;
	public static final int COLUMN_INDEX_PLACE_OF_BIRTH = 10;
	public static final int COLUMN_INDEX_ETHNIC = 11;
	public static final int COLUMN_INDEX_RESIDENCE = 12;
	public static final int COLUMN_INDEX_PHONE = 13;
	
	public static final int COLUMN_INDEX_POINT1 = 14;
	public static final int COLUMN_INDEX_POINT2 = 15;
	public static final int COLUMN_INDEX_POINT3 = 16;
	public static final int COLUMN_INDEX_POINT4 = 17;
	public static final int COLUMN_INDEX_POINT5 = 18;
	
	
	public static final int COLUMN_INDEX_TOTAL5 = 19;
	public static final int COLUMN_INDEX_PRIORTIZED = 20;
	public static final int COLUMN_INDEX_TOTAL_RECRUITMENT_SCORE = 21;
	public static final int COLUMN_INDEX_NOTE = 22;
	
	
	

//	public static final int COLUMN_INDEX_POINT = 21;
//	public static final int COLUMN_INDEX_NOTE = 22;


	@Override
	public void writeFile(String document)throws IOException, ParseException {
//		final String excelFilePath = "C:/demo/sample.xlsx";
		final String excelFilePath = document;
		
		final List<Student> lStudents = readExcelFile(excelFilePath);
		for (Student student : lStudents) {
			studentReponsitory.save(student);
		}
	}


	public static List<Student> readExcelFile(String excelFilePath) throws IOException, ParseException {
		List<Student> lStudents = new ArrayList<>();

		// Get file
		InputStream inputStream = new FileInputStream(new File(excelFilePath));

		// Get workbook
		Workbook workbook = getWorkbook(inputStream, excelFilePath);

		Sheet sheet = workbook.getSheetAt(0);

		// Get all rows
		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			Row nextRow = (Row) iterator.next();

			if (nextRow.getRowNum() > 4) {
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				Student student = new Student();
				while (cellIterator.hasNext()) {
					// Read cell
					Cell cell = (Cell) cellIterator.next();
					Object cellValue = getCellValue(cell);
					if (cellValue == null || cellValue.toString().isEmpty()) {
						continue;
					}
					// Set value for book object
					int columnIndex = cell.getColumnIndex();
					switch (columnIndex) {
						case COLUMN_INDEX_SCHOOL:
							student.setTruong((String) getCellValue(cell));
							break;
						case COLUMN_INDEX_DISTRICT:
							student.setQuanHuyen((String) getCellValue(cell));
							break;
						case COLUMN_INDEX_STUDENTID:
							student.setMahs((String) getCellValue(cell));
							break;
						case COLUMN_INDEX_CLASSROOM:
							student.setLop((String) getCellValue(cell));
							break;
						case COLUMN_INDEX_FULLNAME:
							student.setHoTen((String) getCellValue(cell));
							break;	
						case COLUMN_INDEX_GENDER:
							student.setGioiTinh((String) getCellValue(cell));
							break;
						case COLUMN_INDEX_PLACE_OF_BIRTH:
							student.setNoiSinh((String) getCellValue(cell));
							break;
						case COLUMN_INDEX_ETHNIC:
							student.setDanToc((String) getCellValue(cell));
							break;
						case COLUMN_INDEX_RESIDENCE:
							student.setHoKhau((String) getCellValue(cell));
							break;
						case COLUMN_INDEX_PHONE:
							student.setDienThoai((String) getCellValue(cell));
							break;
						case COLUMN_INDEX_POINT1:
							student.setDiem1(new BigDecimal((double) cellValue).intValue());
							break;
						case COLUMN_INDEX_POINT2:
							student.setDiem2(new BigDecimal((double) cellValue).intValue());
							break;
						case COLUMN_INDEX_POINT3:
							student.setDiem3(new BigDecimal((double) cellValue).intValue());
							break;
						case COLUMN_INDEX_POINT4:
							student.setDiem4(new BigDecimal((double) cellValue).intValue());
							break;
						case COLUMN_INDEX_POINT5:
							student.setDiem5(new BigDecimal((double) cellValue).intValue());
							break;
						case COLUMN_INDEX_TOTAL5:
							student.setTongDiem((Double)getCellValue(cell));
							break;
						case COLUMN_INDEX_PRIORTIZED:
							student.setDiemUuTien((Double)getCellValue(cell));
							break;
						case COLUMN_INDEX_TOTAL_RECRUITMENT_SCORE:
							student.setTongDiemSoTuyen((Double)getCellValue(cell));
							break;
						case COLUMN_INDEX_NOTE:
							student.setGhiChu((String) getCellValue(cell));
							break;
						default:
							break;
					}
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					Date ngaySinh = dateFormat.parse(COLUMN_INDEX_DAY+"/"+COLUMN_INDEX_MONTH+"/"+COLUMN_INDEX_YEAR);
				
					student.setNgaySinh(ngaySinh);
				}
				lStudents.add(student);
			}	
		}
		workbook.close();
		inputStream.close();

		return lStudents;
	}

	@Override
	public List<Student> findByHoTenLike(String hoTen) {
		return studentReponsitory.findByHoTenLike(hoTen);
	}


	@Override
	public List<Student> findAll() {
		return studentReponsitory.findAll();
	}


	@Override
	public List<Student> findByMahsLike(String mahs) {
		return studentReponsitory.findByMahsLike(mahs);
	}


	// get Workbook
	public static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
		Workbook workbook = null;
		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else {
			throw new IllegalArgumentException();
		}
		return workbook;
	}

	// get cell value
	public static Object getCellValue(Cell cell) {
		CellType cellType = cell.getCellTypeEnum();
		Object cellValue = null;
		switch (cellType) {
			case BOOLEAN:
				cellValue = cell.getBooleanCellValue();
				break;
			case FORMULA:
				Workbook workbook = cell.getSheet().getWorkbook();
				FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
				cellValue = evaluator.evaluate(cell).getNumberValue();
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					cellValue = cell.getDateCellValue();
				} else {
					cellValue = cell.getNumericCellValue();
				}
				break;
			case STRING:
				cellValue = cell.getStringCellValue();
				break;
			case _NONE:
			case BLANK:
			case ERROR:
				break;
			default:
				break;
		}

		return cellValue;
	}

}
