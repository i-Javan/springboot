package com.movebrick.utils.module.Export.entity;

import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	
	private String id;
	
	@Excel(name = "学生姓名", height = 50, width = 30, isImportField = "true_st")
	private String name;
	
	@Excel(name = "学生性别", replace = { "男_1", "女_2" }, suffix = "生", isImportField = "true_st")
	private int sex;

	@Excel(name = "出生日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd", isImportField = "true_st", width = 20)
	private Date birthday;

	@Excel(name = "进校日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd", width = 20)
	private Date registrationDate;
	
}
