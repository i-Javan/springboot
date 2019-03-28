package com.movebrick.utils.module.Export;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;

/**
 * 导出工具类
 * 
 * @author JohnDeng
 * @datatime 2018年7月9日下午3:40:36
 */
public class ExportUtils {

	/**
	 * 导出Excel
	 * 
	 * @author JohnDeng
	 * @datatime 2018年7月9日下午4:17:48
	 * @param list           数据集合
	 * @param title          表格标题
	 * @param sheetName      纸张名称
	 * @param pojoClass      导出对象
	 * @param fileName       文件名称
	 * @param isCreateHeader 否创建表头
	 * @param response       响应对象
	 */
	public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName,
			boolean isCreateHeader, HttpServletResponse response) {
		ExportParams exportParams = new ExportParams(title, sheetName);
		exportParams.setCreateHeadRows(isCreateHeader);
		defaultExport(list, pojoClass, fileName, response, exportParams);
	}

	/**
	 * 导出Excel
	 * 
	 * @author JohnDeng
	 * @datatime 2018年7月9日下午4:23:38
	 * @param list      数据集合
	 * @param title     表格标题
	 * @param sheetName 纸张名称
	 * @param pojoClass 导出对象
	 * @param fileName  文件名称
	 * @param response  响应对象
	 */
	public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName,
			HttpServletResponse response) {
		defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName));
	}

	/**
	 * 导出Excel
	 * 
	 * @author JohnDeng
	 * @datatime 2018年7月9日下午4:24:38
	 * @param list     数据集合
	 * @param fileName 文件名称
	 * @param response 响应对象
	 */
	public static void exportExcel(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
		defaultExport(list, fileName, response);
	}

	/**
	 * 默认导出
	 * 
	 * @author JohnDeng
	 * @datatime 2018年7月9日下午4:28:50
	 * @param list         数据集合
	 * @param pojoClass    导出对象
	 * @param fileName     文件名称
	 * @param response     响应对象
	 * @param exportParams
	 */
	private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response,
			ExportParams exportParams) {
		Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
		if (workbook != null) {
			downLoadExcel(fileName, response, workbook);
		}
	}
	
	/**
	 * 下载Excel文件
	 * 
	 * @author JohnDeng
	 * @datatime 2018年7月9日下午4:29:28
	 * @param list     数据集合
	 * @param fileName 文件名称带后缀
	 * @param response
	 */
	private static void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
		Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
		if (workbook != null) {
			downLoadExcel(fileName, response, workbook);
		}
	}
	/**
	 * 下载Excel文件格式
	 * 
	 * @author JohnDeng
	 * @datatime 2018年7月9日下午4:15:44
	 * @param fileName 文件名称带后缀
	 * @param response 响应对象
	 * @param workbook 工作书对象
	 */
	public static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setHeader("content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
			workbook.write(response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

}
