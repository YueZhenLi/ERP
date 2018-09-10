package com.erp.service.e;

import com.erp.bean.FinalCountCheck;

import java.util.List;

/**
 * @Author:YueZhenLi
 * @Date:Created in 2018/8/31
 */
public interface FinalCountCheckService {
    List<FinalCountCheck> selectPartFinalCountChecks(Integer page, Integer rows);

    Integer insert(FinalCountCheck finalCountCheck);

    Integer update_all(FinalCountCheck finalCountCheck);

    void delete_batch(String[] ids);

    List<FinalCountCheck> search_fCountCheck_by_fCountCheckId(String searchValue, Integer page, Integer rows);

    List<FinalCountCheck> search_fCountCheck_by_orderId(String searchValue, Integer page, Integer rows);
}
