package com.nagarro.postalservice.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.postalservice.constant.Constant;


//@Component
//public class FileHelper {
//
//	public static boolean hasExcelFormat(MultipartFile file) {
//
//		if(!Constant.FILE_TYPE.equals(file.getContentType())) {
//			return false;
//		}
//		return true;
//	}
//
//	public static Set<com.nagarro.postalservice.entity.PostalRecord> excelToEmployeeList(InputStream is) {
//		
//		try {
//			Workbook workbook = new XSSFWorkbook(is);
//
//			Sheet sheet = workbook.getSheet(Constant.SHEET);
//			Iterator<Row> rows = sheet.iterator();
//
//			Set<com.nagarro.postalservice.entity.PostalRecord> postalRecordList = new HashSet<com.nagarro.postalservice.entity.PostalRecord>();
//
//			int rowNumber = 0;
//			while (rows.hasNext()) {
//				Row currentRow = rows.next();
//				// skip header
//				if (rowNumber == 0) {
//					rowNumber++;
//					continue;
//				}
//
//				Iterator<Cell> cellsInRow = currentRow.iterator();
//				com.nagarro.postalservice.entity.PostalRecord postalRecord=new com.nagarro.postalservice.entity.PostalRecord();
//				int cellIdx = 0;
//				while (cellsInRow.hasNext()) {
//					Cell currentCell = cellsInRow.next();
//
//					switch (cellIdx) {
//					case 0:
//						postalRecord.setPinCode((long)currentCell.getNumericCellValue());
//						break;
//
//					case 1:
//						postalRecord.setDistrict(currentCell.getStringCellValue());
//						break;
//
//					case 2:
//						postalRecord.setState(currentCell.getStringCellValue());
//						break;
//						
//					default:
//						break;
//					}
//
//					cellIdx++;
//				}
//
////				postalRecord.setBlackListed(true);
//				postalRecordList.add(postalRecord);
//			}
//
//			workbook.close();
//
//			return postalRecordList;
//		} catch (IOException e) {
//			throw new RuntimeException("Parsing Failed : "+ e.getMessage());
//		}
//	}
//
//}