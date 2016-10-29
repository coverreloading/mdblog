package com.mdmanage.mapper;

import com.mdmanage.po.ReleaseArticle;
import com.mdmanage.po.ReleaseArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReleaseArticleMapper {
    int countByExample(ReleaseArticleExample example);

    int deleteByExample(ReleaseArticleExample example);

    int deleteByPrimaryKey(Long raId);

    int insert(ReleaseArticle record);

    int insertSelective(ReleaseArticle record);

    List<ReleaseArticle> selectByExampleWithBLOBs(ReleaseArticleExample example);

    List<ReleaseArticle> selectByExample(ReleaseArticleExample example);

    ReleaseArticle selectByPrimaryKey(Long raId);

    int updateByExampleSelective(@Param("record") ReleaseArticle record, @Param("example") ReleaseArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") ReleaseArticle record, @Param("example") ReleaseArticleExample example);

    int updateByExample(@Param("record") ReleaseArticle record, @Param("example") ReleaseArticleExample example);

    int updateByPrimaryKeySelective(ReleaseArticle record);

    int updateByPrimaryKeyWithBLOBs(ReleaseArticle record);

    int updateByPrimaryKey(ReleaseArticle record);
}