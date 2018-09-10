package com.erp.dao;

import com.erp.bean.ProcessCountCheck;

import java.util.HashMap;
import java.util.List;

public interface ProcessCountCheckMapper {
    int deleteByPrimaryKey(String pCountCheckId);

    int insert(ProcessCountCheck record);

    int insertSelective(ProcessCountCheck record);

    ProcessCountCheck selectByPrimaryKey(String pCountCheckId);

    int updateByPrimaryKeySelective(ProcessCountCheck record);

    int updateByPrimaryKey(ProcessCountCheck record);

    Integer selectCountProcessCountChecks();

    List<ProcessCountCheck> selectPartProcessCountChecks(HashMap<Object, Object> hashMap);

    Integer selectCountProcessCountChecksById(String searchValue);

    List<ProcessCountCheck> search_pCountCheck_by_pCountCheckId(HashMap<Object, Object> hashMap);
}