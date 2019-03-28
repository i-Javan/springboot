package com.movebrick.utils.module.Export.entity;

import java.util.List;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ExcelTarget("courseEntity")
public class CourseEntity implements java.io.Serializable {
	/**
	 * @author Aaron 2019年3月27日 下午4:59:10
	 */
	private static final long serialVersionUID = 1L;
	/** 主键 */
	private String id;
	/** 课程名称 */
	@Excel(name = "课程名称", orderNum = "1", width = 25)
	private String name;
	/** 老师主键 */
	@ExcelEntity(id = "absent")
	private TeacherEntity mathTeacher;

	@ExcelCollection(name = "学生", orderNum = "4")
	private List<StudentEntity> students;
}
