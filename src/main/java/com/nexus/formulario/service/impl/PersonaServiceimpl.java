package com.nexus.formulario.service.impl;

import com.nexus.formulario.entities.PersonaEntity;
import com.nexus.formulario.repositories.PersonaRepository;
import com.nexus.formulario.service.PersonaService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonaServiceimpl implements PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaServiceimpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<PersonaEntity> obtenerPersona() {
        return personaRepository.findAll();
    }

    @Override
    public PersonaEntity actualizarPersona(PersonaEntity persona) {
        PersonaEntity actualizado = personaRepository.findById(persona.getId()).orElse(null);
        if (actualizado != null) {
            actualizado.setNombre(persona.getNombre());
            actualizado.setDni(persona.getDni());
            actualizado.setEdad(persona.getEdad());
            return personaRepository.save(actualizado);
        }
        return null;
    }

    @Override
    public PersonaEntity crearPersona(PersonaEntity persona) {
        return personaRepository.save(persona);
    }

    @Override
    public PersonaEntity obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public void borrarPersona(Long id) {
         personaRepository.deleteById(id);
    }
}
