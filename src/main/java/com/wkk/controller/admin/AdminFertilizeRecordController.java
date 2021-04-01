package com.wkk.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.FertilizeRecord;
import com.wkk.pojo.BO.FertilizeRecord;
import com.wkk.pojo.DO.FertilizeRecordDO;
import com.wkk.service.FertilizeRecordService;
import com.wkk.service.FertilizeRecordService;
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
public class AdminFertilizeRecordController {
    @Resource
    FertilizeRecordService fertilizeRecordService;

    @RequestMapping("/fertilize/list")
    public String listAllFertilizeRecord(Model model) {
        PageInfo<FertilizeRecord> pageInfo = fertilizeRecordService.pageFertilizeRecord(1, 5);
        List<FertilizeRecord> fertilizeRecordList = pageInfo.getList();
        pageInfo.setPageNum(1);
        model.addAttribute("fertilizeList", fertilizeRecordList);
        model.addAttribute("page", pageInfo);
        return "admin/fertilize/fertilize-list";
    }

    @RequestMapping("/fertilize/edit/{name}")
    public String editFertilizeRecord(@PathVariable("name") String produceName, Model model){
        FertilizeRecord fertilizeRecord = fertilizeRecordService.findByProduceName(produceName);
        model.addAttribute("fertilize", fertilizeRecord);
        return "admin/fertilize/fertilize-edit";
    }

    @RequestMapping("/fertilize/update")
    public String updateFertilizeRecord(FertilizeRecordDO fertilizeRecord){
        FertilizeRecordDO fertilizeRecordDO = new FertilizeRecordDO();
        fertilizeRecordDO.setId(fertilizeRecord.getId());
        fertilizeRecordDO.setProduceName(fertilizeRecord.getProduceName());
        fertilizeRecordDO.setFertilizer(fertilizeRecord.getFertilizer());
        fertilizeRecordDO.setFirstTime(fertilizeRecord.getFirstTime());
        fertilizeRecordDO.setLastTime(fertilizeRecord.getLastTime());
        fertilizeRecordDO.setTimeInterval(fertilizeRecord.getTimeInterval());
        fertilizeRecordDO.setTotal(fertilizeRecord.getTotal());
        fertilizeRecordDO.setCreatedAt(fertilizeRecord.getCreatedAt());
        fertilizeRecordDO.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        fertilizeRecordService.update(fertilizeRecordDO);
        return "forward:/admin/fertilize/list";
    }

    @RequestMapping("/fertilize/add")
    public String addFertilizeRecord(FertilizeRecordDO processRecord){
        processRecord.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        processRecord.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        fertilizeRecordService.insert(processRecord);
        return "forward:/admin/process/list";
    }
    @RequestMapping("/fertilize/delete/{produceName}")
    public String deleteFertilizeRecord(@PathVariable("produceName") String produceName){
        fertilizeRecordService.deleteByProduceName(produceName);
        return "forward:/admin/fertilize/list";
    }

    @RequestMapping("/fertilize/page/{pagenum}")
    public String pageGrow(@PathVariable("pagenum")Integer pageNum, Model model){
        if(pageNum <= 0){
            return "forward:/admin/fertilize/list";
        }
        PageInfo<FertilizeRecord> pageInfo = fertilizeRecordService.pageFertilizeRecord(pageNum,5);
        List<FertilizeRecord> produceList = pageInfo.getList();
        pageInfo.setPageNum(pageNum);
        if(produceList == null || produceList.size() == 0){
            pageInfo = fertilizeRecordService.pageFertilizeRecord(pageNum-1,5);
            pageInfo.setPageNum(pageNum-1);
            produceList = pageInfo.getList();
        }
        model.addAttribute("fertilizeList", produceList);
        model.addAttribute("page", pageInfo);
        return "admin/fertilize/fertilize-list";
    }

    @RequestMapping("/fertilize/insert")
    public String toInsertPage(){
        return "admin/fertilize/fertilize-add";
    }

}
