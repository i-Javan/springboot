package com.movebrick.utils.module.Export.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyHasImgModel {
	@Excel(name = "公司名称")
	private String name;
	@Excel(name = "公司LOGO", type = 2 ,width = 40 , height = 100,imageType = 1)
	 private String companyLogo;
	@Excel(name = "公司地址")
	private String site;
}
