package com.machinecoding.boilerplate.exceptions;

public class EntityDoesNotExists extends Exception{
    public EntityDoesNotExists(String message){
        super(message);
    }
}