package com.hackaton.hackaton.Dao;

import com.hackaton.hackaton.Models.UsuarioModel;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDAOimpl implements UsuarioDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<UsuarioModel> getUsuarios() {
        String sql = "FROM UsuarioModel";
        return entityManager.createQuery(sql).getResultList();
    }

    @Override
    public void registrar(UsuarioModel usuario) {
        entityManager.merge(usuario);
        System.out.println(usuario);
    }

    @Override
    public void eliminar(Long id) {
        UsuarioModel usuario = entityManager.find(UsuarioModel.class, id);
        entityManager.remove(usuario);
    }
    @Override
    public UsuarioModel obtenerUsuario(UsuarioModel usuario){
        String sql = "FROM UsuarioModel WHERE correo = :correo";
        List<UsuarioModel> lista = entityManager.createQuery(sql)
                .setParameter("correo", usuario.getCorreo())
                .getResultList();

        if(lista.isEmpty()){return null;}
        String pass = lista.get(0).getContrasena();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        boolean same = argon2.verify(pass, usuario.getContrasena());
        if(same){
            return lista.get(0);
        }
        return null;
    }
}
