package com.wkk.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.ProcessRecord;
import com.wkk.pojo.BO.ProduceInfo;
import com.wkk.pojo.DO.ProcessRecordDO;
import com.wkk.pojo.DO.ProduceInfoDO;
import com.wkk.service.ProcessRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author wkk
 * @date 2021/4/1 14:19
 */
@Controller
@RequestMapping("/admin")
public class AdminProcessRecordController {
    @Resource
    ProcessRecordService processRecordService;

    @RequestMapping("/process/list")
    public String listAllProcessRecord(Model model) {
        PageInfo<ProcessRecord> pageInfo = processRecordService.pageProcessRecord(1, 5);
        List<ProcessRecord> processList = pageInfo.getList();
        pageInfo.setPageNum(1);
        model.addAttribute("processList", processList);
        model.addAttribute("page", pageInfo);
        return "admin/process/process-list";
    }

    @RequestMapping("/process/edit/{name}")
    public String editProcessRecord(@PathVariable("name") String produceName, Model model){
        ProcessRecord processRecord = processRecordService.findByProduceName(produceName);
        model.addAttribute("process", processRecord);
        return "admin/process/process-edit";
    }

    @RequestMapping("/process/update")
    public String updateProcessRecord(ProcessRecordDO processRecord){
        ProcessRecordDO processRecordDO = new ProcessRecordDO();
        processRecordDO.setId(processRecord.getId());
        processRecordDO.setProduceName(processRecord.getProduceName());
        processRecordDO.setProcessLand(processRecord.getProcessLand());
        processRecordDO.setProcessName(processRecord.getProcessName());
        processRecordDO.setProcessTime(processRecord.getProcessTime());
        processRecordDO.setCreatedAt(processRecord.getCreatedAt());
        processRecordDO.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        processRecordService.update(processRecordDO);
        return "forward:/admin/process/list";
    }

    @RequestMapping("/process/add")
    public String addProcessRecord(ProcessRecordDO processRecord){
        processRecord.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        processRecord.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        processRecordService.insert(processRecord);
        return "forward:/admin/process/list";
    }
    @RequestMapping("/process/delete/{produceName}")
    public String deleteProcessRecord(@PathVariable("produceName") String produceName){
        processRecordService.deleteByProduceName(produceName);
        return "forward:/admin/process/list";
    }

    @RequestMapping("/process/page/{pagenum}")
    public String pageProduce(@PathVariable("pagenum")Integer pageNum, Model model){
        if(pageNum <= 0){
            return "forward:/admin/process/list";
        }
        PageInfo<ProcessRecord> pageInfo = processRecordService.pageProcessRecord(pageNum,5);
        List<ProcessRecord> produceList = pageInfo.getList();
        pageInfo.setPageNum(pageNum);
        if(produceList == null || produceList.size() == 0){
            pageInfo = processRecordService.pageProcessRecord(pageNum-1,5);
            pageInfo.setPageNum(pageNum-1);
            produceList = pageInfo.getList();
        }
        model.addAttribute("processList", produceList);
        model.addAttribute("page", pageInfo);
        return "admin/process/process-list";
    }

    @RequestMapping("/process/insert")
    public String toInsertPage(){
        return "admin/process/process-add";
    }

}
