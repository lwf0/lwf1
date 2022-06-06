package com.lwf.demo.controller;

import com.lwf.demo.pojo.Informations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

@RequestMapping("/redis")
public class InformationsRedisController {

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    StringRedisTemplate stringRedisTemplate;

     @RequestMapping(value = "/test1")
    public String test1(Map<String,Object> map){
         ValueOperations<String,String> opsl=stringRedisTemplate.opsForValue();
         opsl.set("name","三国演义");
         String name=opsl.get("name");
         System.out.println(name);

         ValueOperations opsl2=stringRedisTemplate.opsForValue();
         Informations info=new Informations();
         info.setId(1001l);
         info.setTitle("红楼梦");
         info.setContent("红楼梦的作者是曹雪芹");
         opsl2.set("info",info);
         Informations info2=(Informations)opsl2.get("info");
         System.out.println(info2.getTitle());
         return  "index";

     }
}
