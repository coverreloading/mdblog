package com.mdmanage.controller;

import com.mdmanage.po.Subject;
import com.mdmanage.service.SubjectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.mdmanage.po.ResponResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Vincent on 16/10/29.
 */
@Controller
@RequestMapping(value = "/subject")
public class SubjectCtrl {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/add")
    public String addSubject(Subject subject) {
        System.out.println("title "+subject.getsTitle());
        System.out.println("Desc "+subject.getsDesc());
        System.out.println("pic "+subject.getsPic());
        if (StringUtils.isNotBlank(subject.getsTitle()) &&
                StringUtils.isNotBlank(subject.getsDesc()) &&
                StringUtils.isNotBlank(subject.getsPic())) {

            subjectService.addSubject(subject);
        }
        return "manage";
    }

    @RequestMapping(value = "/get/{page}/{row}")

    public ResponResult getSubject(@PathVariable(value = "page") Integer page, @PathVariable(value = "row") Integer row) {
        if (page != null && row != null) {

            return null;
        } return null;
    }
}
