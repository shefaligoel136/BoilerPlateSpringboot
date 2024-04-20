package com.machinecoding.boilerplate.controller;

import com.machinecoding.boilerplate.dto.Demo.DemoDTO;
import com.machinecoding.boilerplate.dto.Demo.RequestDemoDTO;
import com.machinecoding.boilerplate.dto.Demo.ResponseDemoDTO;
import com.machinecoding.boilerplate.model.Demo;
import com.machinecoding.boilerplate.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    DemoController(DemoService demoService){
        this.demoService = demoService;
    }

    @GetMapping("/")
    public List<Demo> getAllDemos(){
        return demoService.getAllDemos();
    }

    @GetMapping("/{id}")
    public Demo getAllDemos(@PathVariable("id") Long id){
        return demoService.getDemoById(id);
    }

    @PostMapping("/")
    public ResponseDemoDTO addDemo(@RequestBody RequestDemoDTO requestDemoDTO){
        return demoService.createDemo(requestDemoDTO);
    }

    @PatchMapping("/{id}")
    public ResponseDemoDTO updateDemo(@PathVariable("id") Long id, @RequestBody RequestDemoDTO requestDemoDTO){
        return demoService.updateDemo(id, requestDemoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDemo(@PathVariable("id") Long id){
        demoService.deleteDemo(id);
    }
}
