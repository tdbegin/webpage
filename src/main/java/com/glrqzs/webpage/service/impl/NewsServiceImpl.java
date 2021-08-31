package com.glrqzs.webpage.service.impl;

import com.glrqzs.webpage.dao.NewsDao;
import com.glrqzs.webpage.domain.News;
import com.glrqzs.webpage.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;
    @Override
    public List<News> findAll() {
        return newsDao.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        newsDao.deleteById(id);
    }

    @Override
    public void add(News news) {
        if (StringUtils.isEmpty(news.getNewImagePath())==false){
            StringBuffer imagePath=new StringBuffer(news.getNewImagePath());
            imagePath.insert(24,"/newsimg" );
            String s = imagePath.toString();
            news.setNewImagePath(s);
        }
        newsDao.add(news);
}

    @Override
    public void update(News news) {
        newsDao.update(news);
    }

    @Override
    public News findById(Integer id) {

        return newsDao.findById(id);
    }
}
