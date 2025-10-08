package com.nexus.formulario.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_Persona")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column (length = 50)
    private String nombre;
    @Column (length = 9)
    private String dni;
    private Integer edad ;

}
