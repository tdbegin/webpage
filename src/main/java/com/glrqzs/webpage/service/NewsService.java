package com.glrqzs.webpage.service;

import com.glrqzs.webpage.domain.News;

import java.util.List;

public interface NewsService {
    List<News> findAll();

    void deleteById(Integer id);

    void add(News news);

    void update(News news);

    News findById(Integer id);
}
