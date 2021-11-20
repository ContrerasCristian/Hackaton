package com.hackaton.hackaton.Models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "emprendimientos")
@ToString @EqualsAndHashCode
public class EmprendimientoModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Getter @Setter @Column(name = "id")
        private Long id;
        @Getter @Setter @Column(name = "nombre")
        private String nombre;
        @Getter @Setter @Column(name = "tiempo")
        private String tiempo;
        @Getter @Setter @Column(name = "descripcion" , columnDefinition="text")
        private String descripcion;
        @Getter @Setter @Column(name = "correo")
        private String Correo;
        @Getter @Setter @Column(name = "telefono")
        private String Telefono;

}
