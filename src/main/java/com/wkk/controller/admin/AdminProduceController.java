package com.wkk.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.ProduceInfo;
import com.wkk.pojo.DO.ProduceInfoDO;
import com.wkk.service.ProduceService;
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
 * @date 2021/4/1 12:00
 */
@Controller
@RequestMapping("/admin")
public class AdminProduceController {
    @Resource
    ProduceService produceService;

    @RequestMapping("/produce/list")
    public String listAllProduce(Model model){
        PageInfo<ProduceInfo> pageInfo = produceService.pageUser(1, 5);
        List<ProduceInfo> produceList = pageInfo.getList();
        pageInfo.setPageNum(1);
        model.addAttribute("produceList", produceList);
        model.addAttribute("page", pageInfo);
        return "admin/produce/produce-list";
    }

    @RequestMapping("/produce/edit/{name}")
    public String editProduce(@PathVariable("name") String produceName, Model model){
        ProduceInfo produceInfo = produceService.findByName(produceName);
        model.addAttribute("produce", produceInfo);
        return "admin/produce/produce-edit";
    }

    @RequestMapping("/produce/update")
    public String updateProduce(ProduceInfoDO produce){
        ProduceInfoDO produceDO = new ProduceInfoDO();
        produceDO.setId(produce.getId());
        produceDO.setProduceName(produce.getProduceName());
        produceDO.setProducePrice(produce.getProducePrice());
        produceDO.setProduceType(produce.getProduceType());
        produceDO.setIntroduction(produce.getIntroduction());
        produceDO.setProduceUrl(produce.getProduceUrl());
        produceDO.setCreatedAt(produce.getCreatedAt());
        produceDO.setProductDate(produce.getProductDate());
        produceDO.setStock(produce.getStock());
        produceDO.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        produceService.update(produceDO);
        return "forward:/admin/produce/list";
    }

    @RequestMapping("/produce/add")
    public String addProduce(ProduceInfoDO produceInfo){
        produceService.insert(produceInfo);
        return "forward:/admin/produce/list";
    }
    @RequestMapping("/produce/delete/{produceName}")
    public String deleteUser(@PathVariable("produceName") String produceName){
        produceService.deleteByName(produceName);
        return "forward:/admin/produce/list";
    }

    @RequestMapping("/produce/page/{pagenum}")
    public String pageProduce(@PathVariable("pagenum")Integer pageNum, Model model){
        if(pageNum <= 0){
            return "forward:/admin/produce/list";
        }
        PageInfo<ProduceInfo> pageInfo = produceService.pageUser(pageNum,5);
        List<ProduceInfo> produceList = pageInfo.getList();
        pageInfo.setPageNum(pageNum);
        if(produceList == null || produceList.size() == 0){
            pageInfo = produceService.pageUser(pageNum-1,5);
            pageInfo.setPageNum(pageNum-1);
            produceList = pageInfo.getList();
        }
        model.addAttribute("produceList", produceList);
        model.addAttribute("page", pageInfo);
        return "admin/produce/produce-list";
    }

    @RequestMapping("/produce/insert")
    public String toInsertPage(){
        return "admin/produce/produce-add";
    }
}
