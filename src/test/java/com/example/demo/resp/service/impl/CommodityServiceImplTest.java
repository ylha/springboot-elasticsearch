package com.example.demo.resp.service.impl;

import com.example.demo.resp.entity.Commodity;
import com.example.demo.resp.service.CommodityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CommodityServiceImplTest {
    @Autowired
    private CommodityService commodityService;
    /**
     * 单元测试
     */
    @Test
    public void count() {

        System.out.println(commodityService.count());
    }

    @Test
    public void save() {
        Commodity commodity = new Commodity();
        commodity.setSkuId("1501009001");
        commodity.setName("原味切片面包（10片装）");
        commodity.setCategory("101");
        commodity.setPrice(880);
        commodity.setBrand("良品铺子");
        Commodity save1 = commodityService.save(commodity);
        System.out.println(save1.getSkuId()+"==========");

        commodity = new Commodity();
        commodity.setSkuId("1501009002");
        commodity.setName("原味切片面包（6片装）");
        commodity.setCategory("101");
        commodity.setPrice(680);
        commodity.setBrand("良品铺子");
        Commodity save2 =commodityService.save(commodity);
        System.out.println(save2.getSkuId()+"==========");
        commodity = new Commodity();
        commodity.setSkuId("1501009004");
        commodity.setName("元气吐司850g");
        commodity.setCategory("101");
        commodity.setPrice(120);
        commodity.setBrand("百草味");
        Commodity save3 =commodityService.save(commodity);
        System.out.println(save3.getSkuId()+"==========");
    }

    @Test
    public void delete() {

    }

    @Test
    public void getAll() {
    }

    @Test
    public void findByName() {
    }

    @Test
    public void pageQuery() {
    }
}