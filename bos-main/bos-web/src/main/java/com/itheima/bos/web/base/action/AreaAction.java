package com.itheima.bos.web.base.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;

import com.itheima.bos.action.BaseAction;
import com.itheima.bos.domain.base.Area;
import com.itheima.bos.service.base.AreaService;
import com.itheima.bos.utils.PinYin4jUtils;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/area")
public class AreaAction extends BaseAction<Area> {

	private AreaService areaService;

	@Resource
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
		// 给BaseAction的baseService赋值
		super.setBaseService(areaService);
	}

	@Override
	protected Specification<Area> buildSpecification() {
		final Area model = this.getModel();
		// 创建Specification对象
		Specification<Area> spec = new Specification<Area>() {

			@Override
			public Predicate toPredicate(Root<Area> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> preList = new ArrayList<Predicate>();

				
				if(model.getProvince()!=null && !model.getProvince().trim().equals("")){
					preList.add( cb.like(root.get("province").as(String.class), "%"+model.getProvince()+"%") );
				}
				
				if(model.getCity()!=null && !model.getCity().trim().equals("")){
					preList.add( cb.like(root.get("city").as(String.class), "%"+model.getCity()+"%") );
				}
				
				if(model.getDistrict()!=null && !model.getDistrict().trim().equals("")){
					preList.add( cb.like(root.get("district").as(String.class), "%"+model.getDistrict()+"%") );
				}
				
				
				Predicate[] preArray = new Predicate[preList.size()];
				return cb.and(preList.toArray(preArray));
			}
		};
		return spec;
	}

	//接收文件内容
	private File upload;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	//接收文件名称
	private String uploadFileName;
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	//接收文件类型名称
	private String uploadContentType;
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * Excel文件导入
	 * @throws Exception 
	 * @throws FileNotFoundException 
	 */
	@Action("excelImport")
	public void excelImport() throws Exception{
		try {
			System.out.println(upload);
			System.out.println(uploadFileName);
			System.out.println(uploadContentType);
			
			//使用POI解析excel文件
			
			//判断文件的后缀名
			String extName = uploadFileName.substring(uploadFileName.lastIndexOf("."));
			
			//1.读取WorkBook
			Workbook wb = null;
			if(extName.equals(".xls")){
				//低版本
				wb = new HSSFWorkbook(new FileInputStream(upload));
			}else{
				//高版本
				wb = new XSSFWorkbook(new FileInputStream(upload));
			}
			
			//2.读取工作单Sheet
			Sheet sheet = wb.getSheet("area");
			
			List<Area> areaList = new ArrayList<Area>();
			//3.遍历行
			for(Row row:sheet){
				String areaCode = row.getCell(0).getStringCellValue();
				String province = row.getCell(1).getStringCellValue();
				String city = row.getCell(2).getStringCellValue();
				String district = row.getCell(3).getStringCellValue();
				String postCode = row.getCell(4).getStringCellValue();
				
				//System.out.println(areaCode+"\t"+province+"\t"+city+"\t"+district+"\t"+postCode);
				
				Area area = new Area();
				area.setAreacode(areaCode);
				area.setProvince(province);
				area.setCity(city);
				area.setDistrict(district);
				area.setPostcode(postCode);
				
				
				//使用Pinyin4j来生成区域简码和城市编码
				
				//生成区域简码
				province = province.substring(0, province.length()-1);
				city = city.substring(0, city.length()-1);
				district = district.substring(0, district.length()-1);
				
				//province+city+district
				String[] headByString = PinYin4jUtils.getHeadByString(province+city+district);
				String shortcode = PinYin4jUtils.stringArrayToString(headByString);
				area.setShortcode(shortcode.toLowerCase());
				
				//生成城市编码
				String citycode = PinYin4jUtils.hanziToPinyin(city,"");
				area.setCitycode(citycode);
				
				areaList.add(area);
			}
			
			areaService.save(areaList);

			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		writeJson(result);
	}
	
	/**
	 * Excel导出
	 * @throws Exception 
	 */
	@Action("excelExport")
	public void excelExport() throws Exception{
		
		//1.根据条件查询区域数据
		Specification<Area> spec = buildSpecification();
		List<Area> areaList = areaService.findAll(spec);
		
		//2.根据区域数据写出excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("area");
		
		//创建表头
		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("编号");
		header.createCell(1).setCellValue("省份");
		header.createCell(2).setCellValue("城市");
		header.createCell(3).setCellValue("区（县)");
		header.createCell(4).setCellValue("邮编");
		header.createCell(5).setCellValue("区域简码");
		header.createCell(6).setCellValue("城市编码");
		
		for(int i=0;i<areaList.size();i++){
			Area area = areaList.get(i);
			
			HSSFRow row = sheet.createRow(i+1);
			row.createCell(0).setCellValue(area.getAreacode());
			row.createCell(1).setCellValue(area.getProvince());
			row.createCell(2).setCellValue(area.getCity());
			row.createCell(3).setCellValue(area.getDistrict());
			row.createCell(4).setCellValue(area.getPostcode());
			row.createCell(5).setCellValue(area.getShortcode());
			row.createCell(6).setCellValue(area.getCitycode());
			
		}
		
		//3.把excel文件写出给用户（浏览器，响应，等用于文件下载）
		HttpServletResponse response = ServletActionContext.getResponse();
		
		//设置弹出框（content-disposition)
		response.setHeader("content-disposition", "attachment;filename=area.xls");
		
		wb.write(response.getOutputStream());
	}
}
