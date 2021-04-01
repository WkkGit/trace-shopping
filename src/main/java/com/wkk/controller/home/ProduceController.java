package com.wkk.controller.home;

import com.wkk.pojo.BO.*;
import com.wkk.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wkk
 * @date 2021/3/30 15:06
 */
@Controller
public class ProduceController {
    @Resource
    ProduceService produceService;


    @RequestMapping("/toGallery")
    public String findAllProduce(Model model){
        List<ProduceInfo> produceList = produceService.list();
        model.addAttribute("produceList", produceList);
        return "shop/gallery";
    }

    @RequestMapping("/showDetail/{name}")
    public String showDetail(@PathVariable("name")String name, Model model){
        ProduceInfo produceInfo = produceService.findByName(name);
        model.addAttribute("produceInfo", produceInfo);
        return "shop/shop-detail";
    }
    @RequestMapping("/listFruits")
    public String listFruits(Model model){
        List<ProduceInfo> list = produceService.list();
        List<ProduceInfo> produceList = new ArrayList<>();
        for(ProduceInfo produceInfo : list){
            if(produceInfo.getProduceType().getCode().equals(2)){
                produceList.add(produceInfo);
            }
        }
        model.addAttribute("produceList", produceList);
        return "shop/gallery";
    }

    @RequestMapping("/listVegetables")
    public String listVegetables(Model model){
        List<ProduceInfo> list = produceService.list();
        List<ProduceInfo> produceList = new ArrayList<>();
        for(ProduceInfo produceInfo : list){
            if(produceInfo.getProduceType().getCode().equals(1)){
                produceList.add(produceInfo);
            }
        }
        model.addAttribute("produceList", produceList);
        return "shop/gallery";
    }

    @RequestMapping("/listGrains")
    public String listGrains(Model model){
        List<ProduceInfo> list = produceService.list();
        List<ProduceInfo> produceList = new ArrayList<>();
        for(ProduceInfo produceInfo : list){
            if(produceInfo.getProduceType().getCode().equals(4)){
                produceList.add(produceInfo);
            }
        }
        model.addAttribute("produceList", produceList);
        return "shop/gallery";
    }

    @RequestMapping("/produce/find")
    public String produceFind(String produceName, Model model){
        ProduceInfo produceInfo;
        try{
            produceInfo = produceService.findByName(produceName);
        }catch(NullPointerException e){
            return "shop/shop-error";
        }
        List<ProduceInfo> res = new ArrayList<>();
        res.add(produceInfo);
        model.addAttribute("produceList", res);
        return "shop/gallery";
    }
}
