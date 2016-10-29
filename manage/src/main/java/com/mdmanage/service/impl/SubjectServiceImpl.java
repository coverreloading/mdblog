package com.mdmanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdmanage.mapper.SubjectMapper;
import com.mdmanage.po.Subject;
import com.mdmanage.service.SubjectService;

/**
 * Created by Vincent on 16/10/29.
 */
@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public void addSubject(Subject subject) {
        subject.setsDel(0);
        subject.setsCreatetime(System.currentTimeMillis());
        subjectMapper.insert(subject);
    }
}
