package com.itheima.test.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

/**
 * 演示POI读取Excel
 * @author lenovo
 *
 */
public class Demo1 {

	/**
	 * xls低版本 - HSSF
	 * @throws Exception 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void test1() throws FileNotFoundException, Exception{
		//1）操作工作簿（Workbook）
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream("e:/区域测试数据.xls"));
		
		//2）操作工作单（Sheet）
		HSSFSheet sheet = wb.getSheet("area");
		//HSSFSheet sheet = wb.getSheetAt(0);
		
		//3）操作行（Row）
		HSSFRow row = sheet.getRow(0);
		
		//4）操作列（Cell）
		System.out.println(row.getCell(0).getStringCellValue());
		System.out.println(row.getCell(1).getStringCellValue());
		System.out.println(row.getCell(2).getStringCellValue());
		System.out.println(row.getCell(3).getStringCellValue());
		System.out.println(row.getCell(4).getStringCellValue());
	}
	
	/**
	 * xls低版本 - HSSF (遍历行)
	 * @throws Exception 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void test2() throws FileNotFoundException, Exception{
		//1）操作工作簿（Workbook）
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream("e:/区域测试数据.xls"));
		
		//2）操作工作单（Sheet）
		HSSFSheet sheet = wb.getSheet("area");
		//HSSFSheet sheet = wb.getSheetAt(0);
		
		//3.遍历行 ;Row是HSSFRow的父类
		for(Row row :sheet){
			//跳过第一行
			
			//获取当前行号，跳过第一行
			if(row.getRowNum()==0){
				continue;
			}
			
			System.out.print(row.getCell(0).getStringCellValue()+"\t");
			System.out.print(row.getCell(1).getStringCellValue()+"\t");
			System.out.print(row.getCell(2).getStringCellValue()+"\t");
			System.out.print(row.getCell(3).getStringCellValue()+"\t");
			System.out.print(row.getCell(4).getStringCellValue()+"\t");
			
			System.out.println();
		}
	}
	
	/**
	 * xlsx高版本 - XSSF 
	 * @throws Exception 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void test3() throws FileNotFoundException, Exception{
		//1）操作工作簿（Workbook）
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("e:/区域测试数据.xls"));
		
		//2）操作工作单（Sheet）
		XSSFSheet sheet = wb.getSheet("area");
		//HSSFSheet sheet = wb.getSheetAt(0);
		
		//3.遍历行 ;Row是HSSFRow的父类
		for(Row row :sheet){
			//跳过第一行
			
			//获取当前行号，跳过第一行
			if(row.getRowNum()==0){
				continue;
			}
			
			System.out.print(row.getCell(0).getStringCellValue()+"\t");
			System.out.print(row.getCell(1).getStringCellValue()+"\t");
			System.out.print(row.getCell(2).getStringCellValue()+"\t");
			System.out.print(row.getCell(3).getStringCellValue()+"\t");
			System.out.print(row.getCell(4).getStringCellValue()+"\t");
			
			System.out.println();
		}
	}
}
