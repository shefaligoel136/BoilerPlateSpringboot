package com.machinecoding.boilerplate.interfaces;

import com.machinecoding.boilerplate.dto.Demo.RequestDemoDTO;
import com.machinecoding.boilerplate.dto.Demo.ResponseDemoDTO;
import com.machinecoding.boilerplate.model.Demo;

import java.util.List;

public interface DemoInterface {
    List<Demo> getAllDemos();
    Demo getDemoById(long id);
    ResponseDemoDTO createDemo(RequestDemoDTO demo);
    ResponseDemoDTO updateDemo(Long id, RequestDemoDTO demo);
    void deleteDemo(long id);
}
