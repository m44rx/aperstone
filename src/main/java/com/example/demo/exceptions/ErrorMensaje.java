package com.example.demo.exceptions;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class ErrorMensaje {
    
    private String msg;
    private LocalDate hora;
}
