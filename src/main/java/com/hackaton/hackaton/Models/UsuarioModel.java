package com.hackaton.hackaton.Models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@ToString @EqualsAndHashCode
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;
    @Getter @Setter @Column(name = "nombre")
    private String Nombre;
    @Getter @Setter @Column(name = "apellido")
    private String Apellido;
    @Getter @Setter @Column(name = "correo")
    private String Correo;
    @Getter @Setter @Column(name = "telefono")
    private String Telefono;
    @Getter @Setter @Column(name = "contraseña")
    private String contrasena;
    @Getter @Setter @Column(name = "tipouser")
    private String tipoUser;

}
