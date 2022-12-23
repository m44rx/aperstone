package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Persona;
import com.example.demo.service.PersonaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> personaPorId(@PathVariable Integer id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }
  
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> actualizarPersona(@PathVariable(name = "id",required = true) Integer id, @RequestBody Persona persona) {
        return new ResponseEntity<>(service.actualizar(id, persona), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> todosPersonas() {
        return new ResponseEntity<>(service.personas(), HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarPersona(@RequestBody Persona persona){
        return new ResponseEntity<>(service.guardar(persona), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable(name = "id", required = true) int id){
        return new ResponseEntity<>(service.eliminarPorId(id),HttpStatus.OK);
    }


}
