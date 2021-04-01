package com.wkk.controller.home;

import com.wkk.pojo.BO.FertilizeRecord;
import com.wkk.pojo.BO.GrowRecord;
import com.wkk.pojo.BO.ProcessRecord;
import com.wkk.service.FertilizeRecordService;
import com.wkk.service.GrowRecordService;
import com.wkk.service.ProcessRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author wkk
 * @date 2021/4/1 17:40
 */
@Controller
public class TraceConrtoller {
    @Resource
    GrowRecordService growRecordService;
    @Resource
    ProcessRecordService processRecordService;
    @Resource
    FertilizeRecordService fertilizeRecordService;

    @RequestMapping("/trace/search")
    public String serchTrace(String produceName, Model model){
        GrowRecord growRecord;
        FertilizeRecord fertilizeRecord;
        ProcessRecord processRecord;
        try{
            growRecord = growRecordService.findByProduceName(produceName);
            fertilizeRecord = fertilizeRecordService.findByProduceName(produceName);
            processRecord = processRecordService.findByProduceName(produceName);
        }catch(NullPointerException e){
            return "shop/shop-error";
        }
        model.addAttribute("grow", growRecord);
        model.addAttribute("fertilize", fertilizeRecord);
        model.addAttribute("process", processRecord);
        return "shop/trace-info";
    }

    @RequestMapping("/traceInfo/{name}")
    public String traceInfo(@PathVariable("name") String produceName, Model model){
        GrowRecord growRecord = growRecordService.findByProduceName(produceName);
        FertilizeRecord fertilizeRecord = fertilizeRecordService.findByProduceName(produceName);
        ProcessRecord processRecord = processRecordService.findByProduceName(produceName);
        model.addAttribute("grow", growRecord);
        model.addAttribute("fertilize", fertilizeRecord);
        model.addAttribute("process", processRecord);
        return "shop/trace-info";
    }

}
