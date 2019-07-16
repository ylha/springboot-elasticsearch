package com.example.demo.resp.service.impl;

import com.example.demo.resp.dao.CommodityRepository;
import com.example.demo.resp.entity.Commodity;
import com.example.demo.resp.service.CommodityService;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    private CommodityRepository commodityRepository;

    @Override
    public long count() {
        return commodityRepository.count();
    }

    /**
     * 插入向es商品 ，场景可以监听binlog 通过三方框架，或者mq，及时更新新增商品
     *
     * @param commodity
     * @return
     */
    @Override
    public Commodity save(Commodity commodity) {
        return commodityRepository.save(commodity);
    }

    /**
     * 删除
     *
     * @param commodity
     */
    @Override
    public void delete(Commodity commodity) {
        commodityRepository.delete(commodity);
    }

    /**
     * 查询所有商品
     *
     * @return
     */
    @Override
    public Iterable<Commodity> getAll() {
        return commodityRepository.findAll();
    }

    /**
     * @param name
     * @return
     * @Query("{"bool" : {"must" : {"field" : {"name" : "?0"}}}}")  es中查询方式 为json格式数据
     */
    @Override
    public List<Commodity> findByName(String name) {
        List<Commodity> list = new ArrayList<>();
        /**
         * 匹配查询条件  后面如果写的文章的话 会具体写查询条件
         *
         */
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("name", name);
        Iterable<Commodity> iterable = commodityRepository.search(matchQueryBuilder);
        iterable.forEach(e -> list.add(e));
        return list;
    }

    /**
     * @param pageNo
     * @param pageSize
     * @param kw
     * @return
     */
    @Override
    public Page<Commodity> pageQuery(Integer pageNo, Integer pageSize, String kw) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchPhraseQuery("name", kw))
                .withPageable(PageRequest.of(pageNo, pageSize))
                .build();
        return commodityRepository.search(searchQuery);
    }
}
