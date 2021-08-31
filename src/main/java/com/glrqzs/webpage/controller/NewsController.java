package com.glrqzs.webpage.controller;

import com.glrqzs.webpage.domain.News;
import com.glrqzs.webpage.domain.Result;
import com.glrqzs.webpage.domain.User;
import com.glrqzs.webpage.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.List;
import java.util.UUID;


@RequestMapping("/news")
@RestController
@CrossOrigin
public class NewsController {
@Autowired
private NewsService newsService;

    @RequestMapping("/findAll")
    public Result findAll(){
        List<News> news = newsService.findAll();
        Result result = new Result(true, "success", news);
        return result;
    }
    @RequestMapping("/deleteById")
    public Result deleteById(int newId){
        newsService.deleteById(newId);
        return new Result(true,"删除成功" );
    }

    @RequestMapping("/findById")
    public Result findById(Integer newId){
     News news = newsService.findById(newId);
        return new Result(true,"查询成功" ,news);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody News news){
        newsService.add(news);
        return new Result(true,"增加成功" );
    }

    @RequestMapping("/update")
    public Result update(@RequestBody News news){
        newsService.update(news);
        return new Result(true,"修改成功" );
    }

    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;

    @RequestMapping("/upload")
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

    @RequestMapping("/login")
    public Result login(@RequestBody User user)  {
        if (user.getUsername() !="rqzs2020" && user.getPassword() !="rqzs2020"){
            return new Result(false, "账号或密码错误");
        }else {
            return new Result(true,"登陆成功" );
        }
    }
}
