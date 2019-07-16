package com.example.demo.controller;

import com.example.demo.resp.entity.Commodity;
import com.example.demo.resp.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class ElasticSearchController {
    @Autowired
    private CommodityService commodityService;

    @RequestMapping("/commodity/{name}")
    @ResponseBody
    public List<Commodity> getCommodityByName(@PathVariable String name) {
        List<Commodity> list = commodityService.findByName(name);
        System.out.println(list);
        return list;
    }

    @RequestMapping("/save")
    @ResponseBody
    public void Save() {
        Commodity commodity = new Commodity();
        commodity.setSkuId("1501009001");
        commodity.setName("原味切片面包（10片装）");
        commodity.setCategory("101");
        commodity.setPrice(880);
        commodity.setBrand("良品铺子");
        Commodity save1 = commodityService.save(commodity);
        System.out.println(save1.getSkuId() + "==========");

        commodity = new Commodity();
        commodity.setSkuId("1501009002");
        commodity.setName("原味切片面包（6片装）");
        commodity.setCategory("101");
        commodity.setPrice(680);
        commodity.setBrand("良品铺子");
        Commodity save2 = commodityService.save(commodity);
        System.out.println(save2.getSkuId() + "==========");
        commodity = new Commodity();
        commodity.setSkuId("1501009004");
        commodity.setName("元气吐司850g");
        commodity.setCategory("101");
        commodity.setPrice(120);
        commodity.setBrand("百草味");
        Commodity save3 = commodityService.save(commodity);
        System.out.println(save3.getSkuId() + "==========");
    }

    /**
     * 分页查询
     */
    @RequestMapping("/pagequery")
    @ResponseBody
    public Page<Commodity> pageQuery() {
        Page<Commodity> pageResult = commodityService.pageQuery(0, 10, "切片");
        return pageResult;
    }

}
