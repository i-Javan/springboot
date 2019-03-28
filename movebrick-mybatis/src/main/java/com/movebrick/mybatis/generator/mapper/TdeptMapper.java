package com.movebrick.mybatis.generator.mapper;

import com.movebrick.mybatis.generator.model.Tdept;
import com.movebrick.mybatis.generator.model.TdeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author Javan By 20190322
 *
 */
public interface TdeptMapper {
    long countByExample(TdeptExample example);

    int deleteByExample(TdeptExample example);

    int insert(Tdept record);

    int insertSelective(Tdept record);

    List<Tdept> selectByExample(TdeptExample example);

    int updateByExampleSelective(@Param("record") Tdept record, @Param("example") TdeptExample example);

    int updateByExample(@Param("record") Tdept record, @Param("example") TdeptExample example);
}