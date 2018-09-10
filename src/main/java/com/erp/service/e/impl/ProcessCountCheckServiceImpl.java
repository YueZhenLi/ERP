package com.erp.service.e.impl;

import com.erp.bean.Employee;
import com.erp.bean.ProcessCountCheck;
import com.erp.bean.ProcessMeasureCheck;
import com.erp.dao.EmployeeMapper;
import com.erp.dao.ProcessCountCheckMapper;
import com.erp.service.e.ProcessCountCheckService;
import com.erp.utils.PageModelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author:YueZhenLi
 * @Date:Created in 2018/9/3
 */
@Service
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService{
    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public List<ProcessCountCheck> selectPartProcessCountChecks(Integer page, Integer rows) {
        HashMap<Object, Object> hashMap = new HashMap<>();

        //设置分页显示的数据，并把limit,offset 存入map中
        Integer count = processCountCheckMapper.selectCountProcessCountChecks();
        PageModelHelper.ModelHelper(page, rows, count, hashMap);

        List<ProcessCountCheck> processCountChecks = processCountCheckMapper.selectPartProcessCountChecks(hashMap);

        //设置员工名称
        for (ProcessCountCheck pcc: processCountChecks) {
            String empId = pcc.getEmpId();
            Employee employee = employeeMapper.selectByPrimaryKey(empId);
            String empName = employee.getEmpName();
            pcc.setEmpName(empName);
        }
        return processCountChecks;
    }

    @Override
    public List<ProcessCountCheck> search_pCountCheck_by_pCountCheckId(String searchValue, Integer page, Integer rows) {
        HashMap<Object, Object> hashMap = new HashMap<>();

        String likeSearchValue = "%"+ searchValue + "%";
        Integer count = processCountCheckMapper.selectCountProcessCountChecksById(likeSearchValue);
        PageModelHelper.ModelHelper(page, rows, count, hashMap);

        hashMap.put("searchValue", likeSearchValue);

        List<ProcessCountCheck> processCountChecks = processCountCheckMapper.search_pCountCheck_by_pCountCheckId(hashMap);
        for (ProcessCountCheck pcc : processCountChecks) {
            String empId = pcc.getEmpId();
            Employee employee = employeeMapper.selectByPrimaryKey(empId);
            String empName = employee.getEmpName();
            pcc.setEmpName(empName);
        }
        return processCountChecks;
    }

    @Override
    public Integer insert(ProcessCountCheck processCountCheck) {
        int insert = processCountCheckMapper.insert(processCountCheck);
        return insert;
    }

    @Override
    public Integer update_all(ProcessCountCheck processCountCheck) {
        int i = processCountCheckMapper.updateByPrimaryKey(processCountCheck);
        return i ;
    }

    @Override
    public void delete_batch(String[] ids) {
        for (String id : ids){
            processCountCheckMapper.deleteByPrimaryKey(id);
        }
    }
}
