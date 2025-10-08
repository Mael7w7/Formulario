package com.nexus.formulario.service;

import com.nexus.formulario.entities.PersonaEntity;

import java.util.List;

public interface PersonaService {
    List<PersonaEntity> obtenerPersona();

    PersonaEntity actualizarPersona(PersonaEntity persona);

    PersonaEntity crearPersona(PersonaEntity persona);

    PersonaEntity obtenerPersonaPorId(Long id);

    void borrarPersona(Long id);

}
