package com.machinecoding.boilerplate.service;

import com.machinecoding.boilerplate.dto.Demo.RequestDemoDTO;
import com.machinecoding.boilerplate.dto.Demo.ResponseDemoDTO;
import com.machinecoding.boilerplate.exceptions.EntityDoesNotExists;
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
    public Demo getDemoById(Long id) throws EntityDoesNotExists {
        Optional<Demo> optionalDemo = demoRepository.findById(id);
        if(optionalDemo.isEmpty()){
            throw new EntityDoesNotExists("Entity with id " + id +" does not exists");
        }
        return optionalDemo.get();
    }

    @Override
    public ResponseDemoDTO createDemo(RequestDemoDTO demo) {
        return demoRepository.save(demo);
    }

    @Override
    public ResponseDemoDTO updateDemo(Long id, RequestDemoDTO demo) throws EntityDoesNotExists {
        Optional<Demo> optionalDemo = demoRepository.findById(id);
        if(optionalDemo.isEmpty()){
            throw new EntityDoesNotExists("Entity with id " + id +" does not exists");
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
    public void deleteDemo(long id) throws EntityDoesNotExists {
        Optional<Demo> optionalDemo = demoRepository.findById(id);
        if(optionalDemo.isEmpty()){
            throw new EntityDoesNotExists("Entity with id " + id +" does not exists");
        }
        demoRepository.deleteById(id);
    }
}
