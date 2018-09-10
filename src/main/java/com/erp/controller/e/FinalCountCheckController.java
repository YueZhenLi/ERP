package com.erp.controller.e;

import com.erp.bean.FinalCountCheck;
import com.erp.service.e.FinalCountCheckService;
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
public class FinalCountCheckController {

    @Autowired
    FinalCountCheckService finalCountCheckService;

    @RequestMapping("/f_count_check/find")
    public String returnToList(){
        return "f_count_check_list";
    }

    @RequestMapping("/f_count_check/list")
    @ResponseBody
    public Map selectPartFinalCountChecks(Integer page, Integer rows){

        List<FinalCountCheck> finalCountChecks = finalCountCheckService.selectPartFinalCountChecks(page, rows);
        Integer total = finalCountChecks.size();
        HashMap<Object, Object> hashMap = new HashMap<>();

        hashMap.put("total", total);
        hashMap.put("rows", finalCountChecks);

        return hashMap;
    }


    @RequestMapping("/fCountCheck/add_judge")
    @ResponseBody
    public Map add_judge(){
        return new HashMap();
    }

    @RequestMapping("/f_count_check/add")
    public String add(){
        return "f_count_check_add";
    }

    @RequestMapping("/f_count_check/inser")
    public Map insert(FinalCountCheck finalCountCheck){

        HashMap<Object, Object> hashMap = new HashMap<>();
        Integer insert = finalCountCheckService.insert(finalCountCheck);
        if (insert==1){
            hashMap.put("status", "200");
            hashMap.put("msg", "OK");
            hashMap.put("data", null);
        }
        return hashMap;
    }



    @RequestMapping("/fCountCheck/edit_judge")
    @ResponseBody
    public Map edit_judge(){
        return new HashMap();
    }

    @RequestMapping("/f_count_check/edit")
    public String edit(){
        return "measurement_edit";
    }

    @RequestMapping("/f_count_check/update_all")
    @ResponseBody
    public Map update_all(FinalCountCheck finalCountCheck) {
        Integer update = finalCountCheckService.update_all(finalCountCheck);
        HashMap<Object, Object> hashMap = new HashMap<>();
        if (update == 1) {
            hashMap.put("status", "200");
            hashMap.put("msg", "OK");
            hashMap.put("data", null);
        }
        return hashMap;
    }

    @RequestMapping("/fCountCheck/delete_judge")
    @ResponseBody
    public Map delete_judge(){
        return new HashMap();
    }


    @RequestMapping("/f_count_check/delete_batch")
    @ResponseBody
    public Map delete_batch(String[] ids){
        finalCountCheckService.delete_batch(ids);
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("status", "200");
        hashMap.put("msg", "OK");
        hashMap.put("data", null);
        return hashMap;
    }

    @RequestMapping("/f_count_check/search_fCountCheck_by_fCountCheckId")
    @ResponseBody
    public Map search_fCountCheck_by_fCountCheckId(String searchValue, Integer page, Integer rows) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        List<FinalCountCheck> finalCountChecks = finalCountCheckService.search_fCountCheck_by_fCountCheckId(searchValue, page, rows);
        Integer total = finalCountChecks.size();
        hashMap.put("total", total);
        hashMap.put("rows", finalCountChecks);
        return hashMap;
    }

    @RequestMapping("f_count_check/search_fCountCheck_by_orderId")
    @ResponseBody
    public Map search_fCountCheck_by_orderId(String searchValue, Integer page, Integer rows){
        HashMap<Object, Object> hashMap = new HashMap<>();
        List<FinalCountCheck> finalCountChecks =
                finalCountCheckService.search_fCountCheck_by_orderId(searchValue, page, rows);
        Integer total = finalCountChecks.size();
        hashMap.put("total", total);
        hashMap.put("rows", finalCountChecks);
        return hashMap;
    }
}
