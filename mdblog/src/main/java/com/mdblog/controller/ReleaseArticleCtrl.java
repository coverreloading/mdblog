package com.mdblog.controller;

import com.mdblog.po.ResponResult;
import com.mdblog.po.ReleaseArticle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Vincent on 16/10/27.
 */
@Controller
@RequestMapping(value = "/RA")
public class ReleaseArticleCtrl {



    @RequestMapping(value = "/new",method = RequestMethod.POST)
    @ResponseBody
    public ResponResult releaseNew(String token,ReleaseArticle article){

        return null;
    }
}
