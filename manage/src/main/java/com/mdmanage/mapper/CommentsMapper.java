package com.mdmanage.mapper;

import com.mdmanage.po.Comments;
import com.mdmanage.po.CommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentsMapper {
    int countByExample(CommentsExample example);

    int deleteByExample(CommentsExample example);

    int deleteByPrimaryKey(Long cId);

    int insert(Comments record);

    int insertSelective(Comments record);

    List<Comments> selectByExample(CommentsExample example);

    Comments selectByPrimaryKey(Long cId);

    int updateByExampleSelective(@Param("record") Comments record, @Param("example") CommentsExample example);

    int updateByExample(@Param("record") Comments record, @Param("example") CommentsExample example);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);
}