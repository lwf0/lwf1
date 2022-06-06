package com.lwf.demo.service;

import com.lwf.demo.dao.RepliesMapper;
import com.lwf.demo.pojo.Replies;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RepliesMapperServiceImpl implements RepliesMapperService {

    @Resource
    private RepliesMapper repliesMapper;

    @Override
    public List<Replies> finReplisByInfoId(Long infoId) {
        return repliesMapper.finReplisByInfoId(infoId);
    }

    @Override
    public int insertReplies(Replies replies) {
        return repliesMapper.insertReplies(replies);
    }
}
