package com.movebrick.utils.module.Export.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movebrick.utils.module.Export.ExportUtils;
import com.movebrick.utils.module.Export.entity.CompanyHasImgModel;
import com.movebrick.utils.module.Export.entity.CourseEntity;
import com.movebrick.utils.module.Export.entity.StudentEntity;
import com.movebrick.utils.module.Export.entity.TeacherEntity;
import com.movebrick.utils.module.Export.entity.User;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;

@RestController
@RequestMapping("/pc/expor")
public class UtilsController {

	@GetMapping("get")
	public void get(HttpServletResponse response) {
		String title = "标题";
		String fileName = "Excel导出.xls";
		List<User> list = new ArrayList<User>();
		list.add(new User("1", "小王", 1, new Date(), new Date()));
		list.add(new User("1", "小王", 1, new Date(), new Date()));
		list.add(new User("1", "小王", 1, new Date(), new Date()));
		/**
		 * 1.简单导出
		 */
		ExportUtils.exportExcel(list, title, fileName, User.class, fileName, response);
		/**
		 * 2.是否创建表头
		 */
		// ExportUtils.exportExcel(list, title, fileName, User.class, fileName, false,
		// response);

		/**
		 * 3.Map导出
		 */
//		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
//		Map<String, Object> map = new HashMap<>();
//		ExportParams ep = new ExportParams();
//		ep.setTitle("标题");
//		map.put("title", ep);
//		map.put("entity", User.class);
//		map.put("data",Arrays.asList(
//				new String[] { 
//						"a","b"
//				}
//		));
//		Map<String, Object> map2 = new HashMap<>();
//		map2.put("title", ep);
//		map2.put("entity", User.class);
//		map2.put("data",Arrays.asList(
//				new String[] { 
//						"1","2"
//				}
//		));
//		listMap.add(map);
//		listMap.add(map2);
//		ExportUtils.exportExcel(listMap, fileName, response);
	}

	@GetMapping("tree")
	public void tree(HttpServletResponse response) {
		List<CourseEntity> list = new ArrayList<>(
				Arrays.asList(
						new CourseEntity[] {
								new CourseEntity("1", "数学课", new TeacherEntity("2", "王Teacher"),
										new ArrayList<>(Arrays.asList(new StudentEntity[] {
												new StudentEntity("3", "小王", 1, new Date(), new Date()),
												new StudentEntity("4", "小绿", 2, new Date(), new Date()) }))),
								new CourseEntity("2", "语文学课", new TeacherEntity("3", "李Teacher"),
										new ArrayList<>(Arrays.asList(new StudentEntity[] {
												new StudentEntity("3", "小黑", 1, new Date(), new Date()),
												new StudentEntity("4", "小白", 2, new Date(), new Date()) }))) }));
		Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("大标题", "说明备注！", "表格标题"), CourseEntity.class,
				list);
		ExportUtils.downLoadExcel("Excel文件.xls", response, workbook);

		// ExportUtils.exportExcel(list, "表格标题", "纸张名称", CourseEntity.class,
		// "Excel文件.xls", response);
	}

	@GetMapping("images")
	public void images(HttpServletResponse response) {
		List<CompanyHasImgModel> list = new ArrayList<CompanyHasImgModel>();
		list.add(new CompanyHasImgModel("百度", "images/img.jpg", "北京市海淀区西北旺东路10号院百度科技园1号楼"));
		list.add(new CompanyHasImgModel("阿里巴巴", "images/img.jpg", "北京市海淀区西北旺东路10号院百度科技园1号楼"));
		list.add(new CompanyHasImgModel("Lemur", "images/img.jpg", "亚马逊热带雨林"));
		list.add(new CompanyHasImgModel("一众", "images/img.jpg", "山东济宁俺家"));
		ExportUtils.exportExcel(list, "表格标题", "纸张名称", CompanyHasImgModel.class,
				 "Excel文件.xls", response);
	}
}
