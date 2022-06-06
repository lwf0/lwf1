package com.lwf.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
@ControllerAdvice(basePackages="com.lwf.controller")
public class ErrorException {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String,Object> ex(Exception e){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("errorCode","101");
        map.put("errorMsg","系统错误"+e.getMessage());
        return  map;
    }
}
