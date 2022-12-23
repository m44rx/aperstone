package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Persona;
import com.example.demo.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository repository;

    @Override
    public Persona guardar(Persona t) {
        return repository.save(t);
    }

    @Override
    public boolean eliminarPorId(int id) {
        var exist = existePersona(id);
        if (exist) {
            repository.deleteById(id);
        }
        return exist;
    }

    @Override
    public Persona actualizar(int id, Persona t) {
        var exist = existePersona(id);
        var persona = new Persona();
        if (exist) {
            persona = repository.findById(id).get();
            persona.setEmail(t.getEmail());
            persona.setNombre(t.getNombre());
            persona.setPersonaRespuesta(t.getPersonaRespuesta());
            repository.save(persona);
        }
        return persona;
    }

    @Override
    public Persona buscarPorId(int id) {
        var exist = existePersona(id);
        var persona = new Persona();
        if (exist) {
            persona = repository.findById(id).get();
        }
        return persona;
    }

    @Override
    public List<Persona> personas() {
        return repository.findAll();
    }

    private boolean existePersona(int id) {
        var exist = repository.existsById(id);
        return exist;
    }

}
