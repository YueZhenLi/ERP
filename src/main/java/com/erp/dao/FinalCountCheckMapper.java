package com.erp.dao;

import com.erp.bean.FinalCountCheck;

import java.util.HashMap;
import java.util.List;

public interface FinalCountCheckMapper {
    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);

    Integer selectCountFinalCountChecks();

    List<FinalCountCheck> selectPartFinalCountChecks(HashMap<Object, Object> hashMap);

    Integer selectCountFinalCountChecksByCondition(FinalCountCheck finalCountCheck);

    List<FinalCountCheck> selectFinalCountChecksByCondition(HashMap<Object, Object> hashMap);
}