package com.erp.controller.e;

import com.erp.bean.ProcessMeasureCheck;
import com.erp.service.e.ProcessMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:YueZhenLi
 * @Date:Created in 2018/8/31
 */

@Controller
@RequestMapping
public class ProcessMeasureCheckController {

    @Autowired
    ProcessMeasureCheckService processMeasureCheckService;

    @RequestMapping("/p_measure_check/find")
    public String returnToList(){

        return "p_measure_check_list";
    }

    @RequestMapping("/p_measure_check/list")
    @ResponseBody
    public Map selectPartProcessMeasureChecks(Integer page, Integer rows){

        List<ProcessMeasureCheck> processMeasureChecks =
                        processMeasureCheckService.selectPartProcessMeasureChecks(page, rows);
        Integer total = processMeasureChecks.size();
        HashMap<Object, Object> hashMap = new HashMap<>();

        hashMap.put("total", total);
        hashMap.put("rows", processMeasureChecks);

        return hashMap;
    }

     @RequestMapping("/p_measure_check/search_pMeasureCheck_by_pMeasureCheckId")
    @ResponseBody
    public Map search_pMeasureCheck_by_pMeasureCheckId(String searchValue, Integer page, Integer rows){

        List<ProcessMeasureCheck> processMeasureChecks =
                        processMeasureCheckService.search_pMeasureCheck_by_pMeasureCheckId(searchValue, page, rows);
        Integer total = processMeasureChecks.size();
        HashMap<Object, Object> hashMap = new HashMap<>();

        hashMap.put("total", total);
        hashMap.put("rows", processMeasureChecks);

        return hashMap;
    }


    @RequestMapping("/pMeasureCheck/add_judge")
    @ResponseBody
    public Map add_judge(){
        return new HashMap();
    }

    @RequestMapping("/p_measure_check/add")
    public String add(){
        return "p_measure_check_add";
    }

    @RequestMapping("/p_measure_check/inser")
    public Map insert(ProcessMeasureCheck processMeasureCheck){

        HashMap<Object, Object> hashMap = new HashMap<>();
        Integer insert = processMeasureCheckService.insert(processMeasureCheck);
        if (insert==1){
            hashMap.put("status", "200");
            hashMap.put("msg", "OK");
            hashMap.put("data", null);
        }
        return hashMap;
    }

    @RequestMapping("/pMeasureCheck/edit_judge")
    @ResponseBody
    public Map edit_judge(){
        return new HashMap();
    }



    @RequestMapping("/p_measure_check/edit")
    public String edit(){
        return "p_measure_check_edit";
    }

    @RequestMapping("/p_measure_check/update_all")
    @ResponseBody
    public Map update_all(ProcessMeasureCheck processMeasureCheck){
        Integer update = processMeasureCheckService.update_all(processMeasureCheck);
        HashMap<Object, Object> hashMap = new HashMap<>();
        if (update==1){
            hashMap.put("status", "200");
            hashMap.put("msg", "OK");
            hashMap.put("data", null);
        }
        return hashMap;
    }

    @RequestMapping("/pMeasureCheck/delete_judge")
    @ResponseBody
    public Map delete_judge(){
        return new HashMap();
    }

    @RequestMapping("/p_measure_check/delete_batch")
    @ResponseBody
    public Map delete_batch(String[] ids){
        processMeasureCheckService.delete_batch(ids);
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("status", "200");
        hashMap.put("msg", "OK");
        hashMap.put("data", null);
        return hashMap;
    }



}
