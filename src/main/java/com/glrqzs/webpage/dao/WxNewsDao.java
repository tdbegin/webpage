package com.glrqzs.webpage.dao;

import com.glrqzs.webpage.domain.WxNews;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WxNewsDao {
    List<WxNews> findAll();

    void deleteById(Integer id);

    void add(WxNews news);

    void update(WxNews news);

    WxNews findById(Integer id);
}
