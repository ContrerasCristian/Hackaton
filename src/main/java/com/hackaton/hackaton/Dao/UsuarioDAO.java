package com.hackaton.hackaton.Dao;

import com.hackaton.hackaton.Models.UsuarioModel;

import java.util.List;

public interface UsuarioDAO {

    List<UsuarioModel> getUsuarios();

    void eliminar(Long id);

    void registrar(UsuarioModel usuario);

    UsuarioModel obtenerUsuario(UsuarioModel usuario);
}
