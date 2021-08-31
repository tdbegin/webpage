package com.glrqzs.webpage.service.impl;

import com.glrqzs.webpage.dao.WxNewsDao;
import com.glrqzs.webpage.domain.News;
import com.glrqzs.webpage.domain.WxNews;
import com.glrqzs.webpage.service.WxNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Service
public class WxNewsServiceImpl implements WxNewsService {

    @Autowired
    private WxNewsDao wxnewsDao;
    @Override
    public List<WxNews> findAll() {
        return wxnewsDao.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        wxnewsDao.deleteById(id);
    }

    @Override
    public void add(WxNews news) {
        if (StringUtils.isEmpty(news.getWxnewImagePath())==false){
            StringBuffer imagePath=new StringBuffer(news.getWxnewImagePath());
            imagePath.insert(24,"/wxnewsimg" );
            String s = imagePath.toString();
            news.setWxnewImagePath(s);
        }
        wxnewsDao.add(news);
}

    @Override
    public void update(WxNews news) {
        wxnewsDao.update(news);
    }

    @Override
    public WxNews findById(Integer id) {

        return wxnewsDao.findById(id);
    }
}
