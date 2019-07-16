package com.example.demo.resp.service;

import com.example.demo.resp.entity.Commodity;
import org.springframework.data.domain.Page;
import java.util.List;

public interface CommodityService {
    long count();

    Commodity save(Commodity commodity);

    void delete(Commodity commodity);

    Iterable<Commodity> getAll();

    List<Commodity> findByName(String name);

    Page<Commodity> pageQuery(Integer pageNo, Integer pageSize, String kw);
}
