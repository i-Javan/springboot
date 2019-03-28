package com.movebrick.utils.module.Export.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ExcelTarget("teacherEntity")
public class TeacherEntity implements java.io.Serializable {
    /**
	 * @author Javan 
	 * 2019年3月27日 下午4:59:40
	 */
	private static final long serialVersionUID = 1L;
	private String id;
    /** name */
    @Excel(name = "主讲老师_major,代课老师_absent", orderNum = "1", isImportField = "true_major,true_absent")
    private String name;
}
