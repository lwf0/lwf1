package com.lwf.demo.service;

import com.lwf.demo.dao.InformationsMapper;
import com.lwf.demo.pojo.Informations;
import com.lwf.demo.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class InformationsServiceImpl implements InformationsService {

    @Resource
    private RedisUtil redisUtil;
    @Resource
    private InformationsMapper informationsMapper;


    public List<Informations> findInformation() {
        return informationsMapper.findInformation();
    }

//    @Cacheable(value = "mykey")
    public Informations findInformationsById(Long id) {
        Informations info=null;
        if (redisUtil.get("info:"+id)!=null){
            System.out.println("从缓存获取数据");
            info=(Informations)redisUtil.get("info:"+id);
        }else {
            System.out.println("从数据库获取数据");
           info= informationsMapper.findInformationsById(id);
            redisUtil.set("info:"+id,info);
        }
        return info;
    }


    public int updateInfoViewCount(Long id) {
        return informationsMapper.updateInfoViewCount(id);
    }


    public int updateinforeplyCount(Long id, Date lastPostTime) {
        return informationsMapper.updateinforeplyCount(id,lastPostTime);
    }
}
