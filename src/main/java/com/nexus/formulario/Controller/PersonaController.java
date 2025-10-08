package com.nexus.formulario.Controller;

import com.nexus.formulario.entities.PersonaEntity;
import com.nexus.formulario.service.PersonaService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaService personaService;
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }


    @GetMapping
    public String listarPersonas(Model model) {
        List<PersonaEntity> personas = personaService.obtenerPersona();
        model.addAttribute("personaLista",personas);
        return "listar";
    }

    @GetMapping("/nueva")
    public String nuevaPersonaFormulario(Model model) {
        model.addAttribute("persona", new PersonaEntity());
        model.addAttribute("accion", "/personas/nueva");
        return "formulario";
    }
    @PostMapping("/nueva")
    public String guardarPersona(@ModelAttribute PersonaEntity persona) {
        personaService.crearPersona(persona);
        return "redirect:/personas";
    }

    @GetMapping("/editar/{id}")
    public String MostrareditarPersona(@PathVariable Long id,@ModelAttribute PersonaEntity persona,Model model) {
        model.addAttribute("persona", persona);
        model.addAttribute("accion", "/personas/editar/"+id);
        return "formulario";
    }
    @PostMapping("/editar/{id}")
    public String ModificarPersona(@PathVariable Long id,@ModelAttribute PersonaEntity persona) {
        personaService.actualizarPersona(persona);
        return "redirect:/personas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id) {
        personaService.borrarPersona(id);
        return "redirect:/personas";
    }




}
