package com.wkk.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.GrowRecord;
import com.wkk.pojo.DO.GrowRecordDO;
import com.wkk.service.GrowRecordService;
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
public class AdminGrowRecordController {
    @Resource
    GrowRecordService growRecordService;

    @RequestMapping("/grow/list")
    public String listAllGrowRecord(Model model) {
        PageInfo<GrowRecord> pageInfo = growRecordService.pageGrowRecord(1, 5);
        List<GrowRecord> growList = pageInfo.getList();
        pageInfo.setPageNum(1);
        model.addAttribute("growList", growList);
        model.addAttribute("page", pageInfo);
        return "admin/grow/grow-list";
    }

    @RequestMapping("/grow/edit/{name}")
    public String editGrowRecord(@PathVariable("name") String produceName, Model model){
        GrowRecord growRecord = growRecordService.findByProduceName(produceName);
        model.addAttribute("grow", growRecord);
        return "admin/grow/grow-edit";
    }

    @RequestMapping("/grow/update")
    public String updateGrowRecord(GrowRecordDO growRecord){
        GrowRecordDO growRecordDO = new GrowRecordDO();
        growRecordDO.setId(growRecord.getId());
        growRecordDO.setProduceName(growRecord.getProduceName());
        growRecordDO.setSeedQuality(growRecord.getSeedQuality());
        growRecordDO.setGrowLand(growRecord.getGrowLand());
        growRecordDO.setGrowTime(growRecord.getGrowTime());
        growRecordDO.setReapTime(growRecord.getReapTime());
        growRecordDO.setCreatedAt(growRecord.getCreatedAt());
        growRecordDO.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        growRecordService.update(growRecordDO);
        return "forward:/admin/grow/list";
    }

    @RequestMapping("/grow/add")
    public String addGrowRecord(GrowRecordDO processRecord){
        processRecord.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        processRecord.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        growRecordService.insert(processRecord);
        return "forward:/admin/process/list";
    }
    @RequestMapping("/grow/delete/{produceName}")
    public String deleteGrowRecord(@PathVariable("produceName") String produceName){
        growRecordService.deleteByProduceName(produceName);
        return "forward:/admin/grow/list";
    }

    @RequestMapping("/grow/page/{pagenum}")
    public String pageGrow(@PathVariable("pagenum")Integer pageNum, Model model){
        if(pageNum <= 0){
            return "forward:/admin/grow/list";
        }
        PageInfo<GrowRecord> pageInfo = growRecordService.pageGrowRecord(pageNum,5);
        List<GrowRecord> produceList = pageInfo.getList();
        pageInfo.setPageNum(pageNum);
        if(produceList == null || produceList.size() == 0){
            pageInfo = growRecordService.pageGrowRecord(pageNum-1,5);
            pageInfo.setPageNum(pageNum-1);
            produceList = pageInfo.getList();
        }
        model.addAttribute("growList", produceList);
        model.addAttribute("page", pageInfo);
        return "admin/grow/grow-list";
    }

    @RequestMapping("/grow/insert")
    public String toInsertPage(){
        return "admin/grow/grow-add";
    }

}
