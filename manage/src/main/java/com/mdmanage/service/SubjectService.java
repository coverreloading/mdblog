package com.mdmanage.service;

import com.mdmanage.po.ResponResult;
import com.mdmanage.po.Subject;

import java.util.List;

/**
 * Created by Vincent on 16/10/29.
 */
public interface SubjectService {
    void addSubject(Subject subject);
    ResponResult setSubjectRedis();
    List getTable(Integer limit, Integer offset);
}
