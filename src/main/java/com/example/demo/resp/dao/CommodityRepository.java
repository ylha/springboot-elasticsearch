package com.example.demo.resp.dao;

import com.example.demo.resp.entity.Commodity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommodityRepository extends ElasticsearchRepository<Commodity, String> {
    //springdata 帮你实现 对应的query
    // List<Commodity> findByName(String name);
}
