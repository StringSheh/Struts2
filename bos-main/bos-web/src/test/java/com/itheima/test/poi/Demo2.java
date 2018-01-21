package com.itheima.test.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

/**
 * 演示POI写出Excel
 * @author lenovo
 *
 */
public class Demo2 {

	/**
	 * xls低版本 - HSSF
	 * @throws Exception 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void test1() throws FileNotFoundException, Exception{
		//1）操作工作簿（Workbook）
		HSSFWorkbook wb = new HSSFWorkbook();
		
		//2）创建工作单
		HSSFSheet sheet = wb.createSheet("area");
		
		//3)操作行
		HSSFRow row = sheet.createRow(0);
		
		//4)创建列
		row.createCell(0).setCellValue("客户姓名");
		row.createCell(1).setCellValue("客户来源");
		row.createCell(2).setCellValue("客户级别");
		row.createCell(3).setCellValue("客户电话");
		
		//5）指定写出的位置
		wb.write(new FileOutputStream("e:/customer.xls"));
	}
	
	/**
	 * xlsx高版本 - XSSF
	 * @throws Exception 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void test2() throws FileNotFoundException, Exception{
		//1）操作工作簿（Workbook）
		XSSFWorkbook wb = new XSSFWorkbook();
		
		//2）创建工作单
		XSSFSheet sheet = wb.createSheet("area");
		
		//3)操作行
		XSSFRow row = sheet.createRow(0);
		
		//4)创建列
		row.createCell(0).setCellValue("客户姓名");
		row.createCell(1).setCellValue("客户来源");
		row.createCell(2).setCellValue("客户级别");
		row.createCell(3).setCellValue("客户电话");
		
		//5）指定写出的位置
		wb.write(new FileOutputStream("e:/customer.xlsx"));
	}
	
}
