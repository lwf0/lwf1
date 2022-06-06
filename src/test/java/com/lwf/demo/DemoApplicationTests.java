package com.lwf.demo;

import com.lwf.demo.pojo.Abc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private  Abc abc;

    @Test
    void contextLoads() {
       System.out.println(abc);
    }


}
