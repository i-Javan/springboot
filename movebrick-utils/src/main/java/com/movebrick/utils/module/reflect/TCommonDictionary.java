package com.movebrick.utils.module.reflect;

import java.util.List;
import lombok.Data;

/**
 * 字典
 * @author Javan
 * @datatime 2019-03-08 14:44:14
 */
@Data
public class TCommonDictionary{
	
	private Integer Id;
    private String sPARENTID;
    private String sITEMCODE;
    private String sSORTNO;
    private String sITEMKEY;
    private String sITEMVALUE;
    private String sEXTVALUE1;
    private String sEXTVALUE2;
    private String sEXTVALUE3;
    private String sEXTVALUE4;
    private String sEXTVALUE5;
    private String sREMARK;
    private String sITEMDEC;
    private List<TCommonDictionary> dictionaryList;

}
