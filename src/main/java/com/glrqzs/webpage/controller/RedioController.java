package com.glrqzs.webpage.controller;

//import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "redio")
@Controller
public class RedioController {
    /**
     * video 视频流一
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getVido", method = RequestMethod.GET)
    @ResponseBody
    public void getVido(HttpServletRequest request, HttpServletResponse response) {
        String file = "recordesave0011.mp4";
        try {
            FileInputStream inputStream = new FileInputStream(file);
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            String diskfilename = "final.mp4";
            response.setContentType("video/mp4");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + diskfilename + "\"");
            System.out.println("data.length " + data.length);
            response.setContentLength(data.length);
            response.setHeader("Content-Range", "" + Integer.valueOf(data.length - 1));
            response.setHeader("Accept-Ranges", "bytes");
            response.setHeader("Etag", "W/\"9767057-1323779115364\"");
            OutputStream os = response.getOutputStream();

            os.write(data);
            //先声明的流后关掉！
            os.flush();
            os.close();
            inputStream.close();

        } catch (Exception e) {

        }
    }
    /**
     * video 视频流二
     *
     * IOUtils is available in Apache commons io
     */
    @RequestMapping(value = "/preview2", method = RequestMethod.GET)
    @ResponseBody
    public void getPreview2( HttpServletResponse response) {
        try {

            File file = new File("recordesave0011.mp4");
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.setHeader("Content-Disposition", "attachment; filename="+file.getName().replace(" ", "_"));
            InputStream iStream = new FileInputStream(file);
            IOUtils.copy(iStream, response.getOutputStream());
            response.flushBuffer();
        } catch (java.nio.file.NoSuchFileException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
    //跳转html
    @RequestMapping(value ="/hello")
    public String index() {
        return "hello";
    }
}
