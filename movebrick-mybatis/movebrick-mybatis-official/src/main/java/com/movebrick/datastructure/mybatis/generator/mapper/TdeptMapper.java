package com.movebrick.datastructure.mybatis.generator.mapper;

import com.movebrick.datastructure.mybatis.generator.model.Tdept;
import com.movebrick.datastructure.mybatis.generator.model.TdeptExample;
import org.jboss.logging.Param;

import java.util.List;

/**
 * @author Javan By 20190322
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