package com.efunds.pms.riskmanage.dao;

import com.efunds.pms.riskmanage.model.PmsRemindConf;
import com.efunds.pms.riskmanage.model.PmsRemindConfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsRemindConfMapper {
    long countByExample(PmsRemindConfExample example);

    int deleteByExample(PmsRemindConfExample example);

    int deleteByPrimaryKey(String sRemindId);

    int insert(PmsRemindConf record);

    int insertSelective(PmsRemindConf record);

    List<PmsRemindConf> selectByExample(PmsRemindConfExample example);

    PmsRemindConf selectByPrimaryKey(String sRemindId);

    int updateByExampleSelective(@Param("record") PmsRemindConf record, @Param("example") PmsRemindConfExample example);

    int updateByExample(@Param("record") PmsRemindConf record, @Param("example") PmsRemindConfExample example);

    int updateByPrimaryKeySelective(PmsRemindConf record);

    int updateByPrimaryKey(PmsRemindConf record);
}