package com.machinecoding.boilerplate.interfaces;

import com.machinecoding.boilerplate.dto.Demo.RequestDemoDTO;
import com.machinecoding.boilerplate.dto.Demo.ResponseDemoDTO;
import com.machinecoding.boilerplate.exceptions.EntityDoesNotExists;
import com.machinecoding.boilerplate.model.Demo;

import java.util.List;

public interface DemoInterface {
    List<Demo> getAllDemos();
    Demo getDemoById(Long id) throws EntityDoesNotExists;
    ResponseDemoDTO createDemo(RequestDemoDTO demo);
    ResponseDemoDTO updateDemo(Long id, RequestDemoDTO demo) throws EntityDoesNotExists;
    void deleteDemo(long id) throws EntityDoesNotExists;
}
