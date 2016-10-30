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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if (StringUtils.isNotBlank(subject.getsTitle()) &&
                StringUtils.isNotBlank(subject.getsDesc()) &&
                StringUtils.isNotBlank(subject.getsPic())) {

            subjectService.addSubject(subject);
        }
        return "manage";
    }

    @RequestMapping(value = "/setRedis")
    @ResponseBody
    public ResponResult setRedis() {
        return subjectService.setSubjectRedis();
    }

    @RequestMapping(value = "/get")
    @ResponseBody
    public List<Subject> getSubject(Integer limit, Integer offset) {
        Map hashMap = new HashMap();
        Integer page=0;
        Integer rows=0;
        Integer total = 88;
        if (limit != null && offset != null) {

            page = offset/limit+1;
            rows=limit;

            //
            //hashMap.put("total",total);
            //hashMap.put("rows", 10);
            return subjectService.getTable(page,rows);
        }
        return null;
    }
}
