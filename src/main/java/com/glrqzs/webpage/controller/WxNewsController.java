package com.glrqzs.webpage.controller;

import com.glrqzs.webpage.domain.News;
import com.glrqzs.webpage.domain.Result;
import com.glrqzs.webpage.domain.User;
import com.glrqzs.webpage.domain.WxNews;
import com.glrqzs.webpage.service.WxNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@RequestMapping("/wxnews")
@RestController
@CrossOrigin
public class WxNewsController {
    @Autowired
    private WxNewsService wxnewsService;

    @RequestMapping("/wxfindAll")
    public Result findAll(){
        List<WxNews> news = wxnewsService.findAll();
        Result result = new Result(true, "success", news);
        return result;
    }
    @RequestMapping("/wxdeleteById")
    public Result deleteById(int newId){
        wxnewsService.deleteById(newId);
        return new Result(true,"删除成功" );
    }

    @RequestMapping("/wxfindById")
    public Result findById(Integer newId){
        WxNews news = wxnewsService.findById(newId);
        return new Result(true,"查询成功" ,news);
    }

    @RequestMapping("/wxadd")
    public Result add(@RequestBody WxNews news){
        wxnewsService.add(news);
        return new Result(true,"增加成功" );
    }

    @RequestMapping("/wxupdate")
    public Result update(@RequestBody WxNews news){
        wxnewsService.update(news);
        return new Result(true,"修改成功" );
    }

    @Value("${prop.upload-wxfolder}")
    private String UPLOAD_FOLDER;

    @RequestMapping("/wxupload")
    public Result upload(@RequestParam(name = "file", required = false) MultipartFile file) {
        if (file == null) {
            return new Result(false,"请选择要上传的图片" );
        }
        if (file.getSize() > 1024 * 1024 * 50) {
            return new Result(false,"文件大小不能大于50M" );
        }
        //获取文件后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1, file.getOriginalFilename().length());
        if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
            return new Result(false,"请选择jpg,jpeg,gif,png格式的图片" );
        }
        String savePath = UPLOAD_FOLDER;
        File savePathFile = new File(savePath);
        if (!savePathFile.exists()) {
            //若不存在该目录，则创建目录
            savePathFile.mkdir();
        }
        //通过UUID生成唯一文件名
        String filename = UUID.randomUUID().toString().replaceAll("-","") + "." + suffix;
        try {
            //将文件保存指定目录
            file.transferTo(new File(savePath + filename));
        } catch (Exception e) {
            e.printStackTrace();
            return new  Result(false,"保存文件异常");
        }
        //返回文件名称
        return new  Result(true,"成功",filename);
    }
}


