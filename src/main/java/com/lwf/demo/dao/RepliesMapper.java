package com.lwf.demo.dao;

import com.lwf.demo.pojo.Replies;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepliesMapper {
    /**
     *  根据资讯id查询回复
     * @param infoId
     * @return
     */
    public List<Replies> finReplisByInfoId(@Param("infoId") Long infoId);

    /**
     * 添加回复
     * @param replies
     * @return
     */
    public int insertReplies(Replies replies);
}
