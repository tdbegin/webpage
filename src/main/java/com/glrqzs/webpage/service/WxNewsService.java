package com.glrqzs.webpage.service;

import com.glrqzs.webpage.domain.News;
import com.glrqzs.webpage.domain.WxNews;

import java.util.List;

public interface WxNewsService {
    List<WxNews> findAll();

    void deleteById(Integer id);

    void add(WxNews news);

    void update(WxNews news);

    WxNews findById(Integer id);
}
