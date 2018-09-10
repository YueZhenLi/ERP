package com.erp.service.e;

import com.erp.bean.ProcessCountCheck;

import java.util.List;

/**
 * @Author:YueZhenLi
 * @Date:Created in 2018/9/3
 */
public interface ProcessCountCheckService {
    List<ProcessCountCheck> selectPartProcessCountChecks(Integer page, Integer rows);

    List<ProcessCountCheck> search_pCountCheck_by_pCountCheckId(String searchValue, Integer page, Integer rows);

    Integer insert(ProcessCountCheck processCountCheck);

    Integer update_all(ProcessCountCheck processCountCheck);

    void delete_batch(String[] ids);

}
