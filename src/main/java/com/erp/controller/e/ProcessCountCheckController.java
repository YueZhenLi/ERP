package com.erp.controller.e;

import com.erp.bean.ProcessCountCheck;
import com.erp.service.e.ProcessCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:YueZhenLi
 * @Date:Created in 2018/9/3
 */

@Controller
public class ProcessCountCheckController {

    @Autowired
    ProcessCountCheckService processCountCheckService;

    @RequestMapping("/p_count_check/find")
    public String returnToList(){

        return "p_count_check_list";
    }

    @RequestMapping("/p_count_check/list")
    @ResponseBody
    public Map selectPartProcessCountChecks(Integer page, Integer rows){

        List<ProcessCountCheck> processCountChecks =
                processCountCheckService.selectPartProcessCountChecks(page, rows);
        Integer total = processCountChecks.size();
        HashMap<Object, Object> hashMap = new HashMap<>();

        hashMap.put("total", total);
        hashMap.put("rows", processCountChecks);

        return hashMap;
    }

    @RequestMapping("/p_count_check/search_pCountCheck_by_pCountCheckId")
    @ResponseBody
    public Map search_pCountCheck_by_pCountCheckId(String searchValue, Integer page, Integer rows){

        List<ProcessCountCheck> processCountChecks =
                processCountCheckService.search_pCountCheck_by_pCountCheckId(searchValue, page, rows);
        Integer total = processCountChecks.size();
        HashMap<Object, Object> hashMap = new HashMap<>();

        hashMap.put("total", total);
        hashMap.put("rows", processCountChecks);

        return hashMap;
    }

    @RequestMapping("/pCountCheck/add_judge")
    @ResponseBody
    public Map add_judge(){
        return new HashMap();
    }

    @RequestMapping("/p_count_check/add")
    public String add(){
        return "p_count_check_add";
    }

    @RequestMapping("/p_count_check/inser")
    public Map insert(ProcessCountCheck processCountCheck){

        HashMap<Object, Object> hashMap = new HashMap<>();
        Integer insert = processCountCheckService.insert(processCountCheck);
        if (insert==1){
            hashMap.put("status", "200");
            hashMap.put("msg", "OK");
            hashMap.put("data", null);
        }
        return hashMap;
    }

    @RequestMapping("/pCountCheck/edit_judge")
    @ResponseBody
    public Map edit_judge(){
        return new HashMap();
    }



    @RequestMapping("/p_count_check/edit")
    public String edit(){
        return "p_measure_check_edit";
    }

    @RequestMapping("/p_count_check/update_all")
    @ResponseBody
    public Map update_all(ProcessCountCheck processCountCheck){
        Integer update = processCountCheckService.update_all(processCountCheck);
        HashMap<Object, Object> hashMap = new HashMap<>();
        if (update==1){
            hashMap.put("status", "200");
            hashMap.put("msg", "OK");
            hashMap.put("data", null);
        }
        return hashMap;
    }

    @RequestMapping("/pCountCheck/delete_judge")
    @ResponseBody
    public Map delete_judge(){
        return new HashMap();
    }

    @RequestMapping("/p_count_check/delete_batch")
    @ResponseBody
    public Map delete_batch(String[] ids){
        processCountCheckService.delete_batch(ids);
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("status", "200");
        hashMap.put("msg", "OK");
        hashMap.put("data", null);
        return hashMap;
    }
}
