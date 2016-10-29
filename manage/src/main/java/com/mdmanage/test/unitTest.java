package com.mdmanage.test;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
import com.mdmanage.mapper.SubjectMapper;
import com.mdmanage.mapper.UserMapper;
import com.mdmanage.po.Subject;
import com.mdmanage.po.SubjectExample;
import com.mdmanage.po.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Vincent on 16/10/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring/applicationContext-dao.xml"})
public class unitTest {

    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private UserMapper usermapper;
/*
    @Test
    public void testPageHelper() {

        //执行查询，并分页
        SubjectExample example = new SubjectExample();
        //分页处理
        PageHelper.startPage(1, 10);
        List<Subject> list = subjectMapper.selectByExample(example);
        //取商品列表

        Iterator iter = list.iterator();
        while(iter.hasNext()) {
            Subject subject = (Subject) iter.next();
            System.out.println(subject.getsId());
            System.out.println(subject.getsDesc());
            System.out.println(subject.getsPic());
        }

        //取分页信息
        PageInfo<Subject> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        System.out.println("共有商品：" + total);
    }*/
    @Test
    public void testSubjectInsert(){
        Subject subject = new Subject();
        subject.setsDesc("123");
        subject.setsTitle("123123");
        subject.setsPic("123");
        subject.setsDel(0);
        //subject.setsCreatetime((long) 123123123);
        //subjectMapper.insert(subject);
    }
    @Test
    public void testUserInsert(){
        User user =new User();
        user.setuEmail("123");
        user.setuPassword("123");
        user.setuPhone("123");
        usermapper.insert(user);
    }
}

