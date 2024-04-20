package com.machinecoding.boilerplate.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Demo extends BaseModel{
    private String name;
    private Integer maxMarks;
}
