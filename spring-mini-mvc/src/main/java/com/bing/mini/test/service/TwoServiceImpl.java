package com.bing.mini.test.service;

import com.bing.mini.beans.factory.annotation.Autowired;
import com.bing.mini.test.service.ThreeService;
import com.bing.mini.test.service.TwoService;

public class TwoServiceImpl implements TwoService {

    @Autowired
    private ThreeService threeService;

    public TwoServiceImpl() {
    }

    @Override
    public void sayHello() {
        System.out.println("TwoServiceImpl says hello");

    }

    public void init() {
        System.out.print("TwoServiceImpl init method.");
    }
}
