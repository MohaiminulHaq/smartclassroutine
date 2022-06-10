package com.my.class_routine.controller;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommonResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean status;

    private String message;

    private String messageBn;

    private Object data;




}
