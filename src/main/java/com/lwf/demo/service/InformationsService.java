package com.lwf.demo.service;

import com.lwf.demo.pojo.Informations;
import org.apache.ibatis.annotations.Param;


import java.util.Date;
import java.util.List;
public interface InformationsService {
    //查询全部
    public List<Informations> findInformation();

    //根据id查询咨询
    public  Informations findInformationsById(@Param("id") Long id);

    //根据id修改查看次数
    public int updateInfoViewCount(@Param("id") Long id);

    //修改回复次数
    public int updateinforeplyCount(@Param("id") Long id, @Param("lastPostTime") Date lastPostTime);
}
