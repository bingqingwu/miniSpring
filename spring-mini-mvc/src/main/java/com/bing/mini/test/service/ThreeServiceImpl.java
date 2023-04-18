package com.bing.mini.test.service;

import com.bing.mini.beans.factory.annotation.Autowired;
import com.bing.mini.test.service.OneService;
import com.bing.mini.test.service.ThreeService;

public class ThreeServiceImpl implements ThreeService {

    @Autowired
    private OneService oneService;


    @Override
    public void sayHello() {
        System.out.print("ThreeServiceImpl says hello");
        oneService.sayHello();
    }


}
