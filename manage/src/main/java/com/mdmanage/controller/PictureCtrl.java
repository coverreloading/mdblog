package com.mdmanage.controller;

import com.mdmanage.service.PictureService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Vincent on 16/10/27.
 */
@Controller
@RequestMapping("/pic")
public class PictureCtrl {

    @Autowired
    private PictureService pictureService;

    // mdeditor上传图片
    @RequestMapping(value = "/subjectPic")
    @ResponseBody
    public Map uploadArticlePic(MultipartFile uploadFile) {
        Map result = pictureService.uploadPicture(uploadFile);
        return result;
    }
}
