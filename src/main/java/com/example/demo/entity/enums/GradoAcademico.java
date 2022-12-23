package com.example.demo.entity.enums;

public enum GradoAcademico {
    
    PROFESIONAL("PROFESIONAL"),
    TECNICO("TECNICO"),
    SECUNDARIA("SECUNDARIA"),
    INCONCLUSO("INCONCLUSO");

    
    private GradoAcademico(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
