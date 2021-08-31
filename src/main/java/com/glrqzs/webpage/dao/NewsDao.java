package com.glrqzs.webpage.dao;

import com.glrqzs.webpage.domain.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsDao {
    List<News> findAll();

    void deleteById(Integer id);

    void add(News news);

    void update(News news);

    News findById(Integer id);
}
