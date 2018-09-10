package com.erp.service.e.impl;

import com.erp.bean.Employee;
import com.erp.bean.FinalCountCheck;
import com.erp.bean.FinalMeasuretCheck;
import com.erp.dao.EmployeeMapper;
import com.erp.dao.FinalCountCheckMapper;
import com.erp.service.e.FinalCountCheckService;
import com.erp.utils.PageModelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author:YueZhenLi
 * @Date:Created in 2018/8/31
 */

@Service
public class FinalCountCheckServiceImpl implements FinalCountCheckService {

    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<FinalCountCheck> selectPartFinalCountChecks(Integer page, Integer rows) {

        HashMap<Object, Object> hashMap = new HashMap<>();

        //设置分页显示的数据，并把limit,offset 存入map中
        Integer count = finalCountCheckMapper.selectCountFinalCountChecks();
        PageModelHelper.ModelHelper(page, rows, count, hashMap);

        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectPartFinalCountChecks(hashMap);

        //设置员工名称
        for (FinalCountCheck finalCountCheck : finalCountChecks) {
            String empId = finalCountCheck.getEmpId();
            Employee employee = employeeMapper.selectByPrimaryKey(empId);
            String empName = employee.getEmpName();
            finalCountCheck.setEmpName(empName);
        }
        return finalCountChecks;
    }

    @Override
    public Integer insert(FinalCountCheck finalCountCheck) {
        int insert = finalCountCheckMapper.insert(finalCountCheck);
        return null;
    }

    @Override
    public Integer update_all(FinalCountCheck finalCountCheck) {
        int i = finalCountCheckMapper.updateByPrimaryKey(finalCountCheck);
        return i;
    }

    @Override
    public void delete_batch(String[] ids) {
        for (String id : ids) {
            finalCountCheckMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<FinalCountCheck> search_fCountCheck_by_fCountCheckId(String searchValue, Integer page, Integer rows) {
        HashMap<Object, Object> hashMap = new HashMap<>();

        //模糊查询参数
        String likeSearchValue = "%"+ searchValue + "%";

        FinalCountCheck  finalCountCheck  = new FinalCountCheck ();
        finalCountCheck.setfCountCheckId(likeSearchValue);
        hashMap.put("finalCountCheck",finalCountCheck);
        //查找出符合条件数据的总数，封装进分页工具中
        Integer count = finalCountCheckMapper.selectCountFinalCountChecksByCondition(finalCountCheck);
        PageModelHelper.ModelHelper(page, rows, count, hashMap);


        //查找出符合查找条件并符合分页要求的数据
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectFinalCountChecksByCondition(hashMap);

        //设置员工名称
        for (FinalCountCheck fcc : finalCountChecks) {
            String empId = fcc.getEmpId();
            Employee employee = employeeMapper.selectByPrimaryKey(empId);
            String empName = employee.getEmpName();
            fcc.setEmpName(empName);
        }
        return finalCountChecks;
    }

    @Override
    public List<FinalCountCheck> search_fCountCheck_by_orderId(String searchValue, Integer page, Integer rows) {
        HashMap<Object, Object> hashMap = new HashMap<>();

        //模糊查询参数
        String likeSearchValue = "%"+ searchValue + "%";

        FinalCountCheck  finalCountCheck  = new FinalCountCheck ();
        finalCountCheck.setOrderId(likeSearchValue);
        hashMap.put("finalCountCheck",finalCountCheck);
        //查找出符合条件数据的总数，封装进分页工具中
        Integer count = finalCountCheckMapper.selectCountFinalCountChecksByCondition(finalCountCheck);
        PageModelHelper.ModelHelper(page, rows, count, hashMap);


        //查找出符合查找条件并符合分页要求的数据
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectFinalCountChecksByCondition(hashMap);

        //设置员工名称
        for (FinalCountCheck fcc : finalCountChecks) {
            String empId = fcc.getEmpId();
            Employee employee = employeeMapper.selectByPrimaryKey(empId);
            String empName = employee.getEmpName();
            fcc.setEmpName(empName);
        }
        return finalCountChecks;
    }
}
