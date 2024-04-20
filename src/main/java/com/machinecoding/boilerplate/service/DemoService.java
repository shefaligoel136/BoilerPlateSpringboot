package com.machinecoding.boilerplate.service;

import com.machinecoding.boilerplate.dto.Demo.RequestDemoDTO;
import com.machinecoding.boilerplate.dto.Demo.ResponseDemoDTO;
import com.machinecoding.boilerplate.interfaces.DemoInterface;
import com.machinecoding.boilerplate.model.Demo;
import com.machinecoding.boilerplate.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemoService implements DemoInterface {

    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    public DemoService(DemoRepository demoRepository){
        this.demoRepository = demoRepository;
    }


    @Override
    public List<Demo> getAllDemos() {
        return demoRepository.findAll();
    }

    @Override
    public Demo getDemoById(long id) {
        Optional<Demo> optionalDemo = demoRepository.findById(id);
        if(optionalDemo.isEmpty()){
//            TODO: Exception
            System.out.println("No demo found");
        }
        return optionalDemo.get();
    }

    @Override
    public ResponseDemoDTO createDemo(RequestDemoDTO demo) {
        return demoRepository.save(demo);
    }

    @Override
    public ResponseDemoDTO updateDemo(Long id, RequestDemoDTO demo) {
        Optional<Demo> optionalDemo = demoRepository.findById(id);
        if(optionalDemo.isEmpty()){
//            TODO: Exception
            System.out.println("No demo found");
        }

        Demo originalDemo = optionalDemo.get();

        if(demo.getName() != null){
            originalDemo.setName(demo.getName());
        }

        if(demo.getMaxMarks() != null){
            originalDemo.setMaxMarks(demo.getMaxMarks());
        }

        return demoRepository.save(demo);
    }

    @Override
    public void deleteDemo(long id) {
        Optional<Demo> optionalDemo = demoRepository.findById(id);
        if(optionalDemo.isEmpty()){
//            TODO: Exception
            System.out.println("No demo found");
        }
        demoRepository.deleteById(id);
    }
}
