package com.mdblog.controller;

import com.mdblog.po.ResponResult;
import com.mdblog.service.ShowArticleService;
import org.apache.ibatis.reflection.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Vincent on 16/10/31.
 */
@Controller
@RequestMapping(value = "/a")
public class ShowArticleCtrl {

    @Autowired
    private ShowArticleService showArticleService;

    @RequestMapping(value = "/{RaId}")
    @ResponseBody
    public ResponResult showArticle(@PathVariable(value = "RaId")Long RaId){
        try {
            ResponResult responResult = showArticleService.getRaByRaId(RaId);
            return responResult;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponResult.build(500, com.mdblog.utils.ExceptionUtil.getStackTrace(e));
        }
    }
}
