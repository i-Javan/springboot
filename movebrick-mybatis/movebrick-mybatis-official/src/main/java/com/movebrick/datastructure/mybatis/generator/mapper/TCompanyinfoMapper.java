package com.movebrick.datastructure.mybatis.generator.mapper;

import com.movebrick.datastructure.mybatis.generator.model.TCompanyinfo;
import com.movebrick.datastructure.mybatis.generator.model.TCompanyinfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract class TCompanyinfoMapper {
    public abstract long countByExample(TCompanyinfoExample example);

    public abstract int deleteByExample(TCompanyinfoExample example);

    public abstract int insert(TCompanyinfo record);

    public abstract int insertSelective(TCompanyinfo record);

    public abstract List<TCompanyinfo> selectByExample(TCompanyinfoExample example);

    public abstract int updateByExampleSelective(@Param("record") TCompanyinfo record, @Param("example") TCompanyinfoExample example);

    public abstract int updateByExample(@Param("record") TCompanyinfo record, @Param("example") TCompanyinfoExample example);
}