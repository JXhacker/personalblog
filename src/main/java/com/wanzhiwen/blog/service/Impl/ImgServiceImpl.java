package com.wanzhiwen.blog.service.Impl;

import com.wanzhiwen.blog.commons.Response;
import com.wanzhiwen.blog.dao.ImgDao;
import com.wanzhiwen.blog.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author wanzhiwen
 * @time 2018/11/15
 */

@Service
public class ImgServiceImpl implements ImgService {

    @Value("${web.upload-path}")
    String imgPath;

    @Autowired
    ImgDao imgDao;

    public Response addImg(MultipartFile file, HttpServletRequest request) {
        String imgName,ownerName;
        HttpSession session=request.getSession();
        if (session.getAttribute("username")==null||session.getAttribute("portrait")==null){
            return new Response(1,"未登录");
        }
        ownerName=(String) session.getAttribute("username");
        File pathFile = new File(imgPath);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        if (!file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename();
                String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                imgName = UUID.randomUUID() + "." + suffix;
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(imgPath + "/" + imgName)));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                return new Response(1, "文件创建失败");
            }
        } else {
            return new Response(1, "文件路径不存在");
        }
        try {
            imgDao.addImg(imgName,ownerName);
            return new Response(0, "上传成功", imgName);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(1, "数据库错误");
        }
    }
}
