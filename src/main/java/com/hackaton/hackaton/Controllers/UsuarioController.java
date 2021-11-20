package com.hackaton.hackaton.Controllers;

import com.hackaton.hackaton.Dao.UsuarioDAO;
import com.hackaton.hackaton.Models.UsuarioModel;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import com.hackaton.hackaton.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<UsuarioModel> getUsuarios(@RequestHeader(value = "Authorization")String token){

        if(!validarToken(token)){return null;}
       return usuarioDAO.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody UsuarioModel usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getContrasena());
        usuario.setContrasena(hash);

        usuarioDAO.registrar(usuario);
    }

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody UsuarioModel usuario){
        UsuarioModel getUser = usuarioDAO.obtenerUsuario(usuario);
        if(getUser != null){
            String token = jwtUtil.create(String.valueOf(getUser.getId()), getUser.getCorreo());
            return token;
        }
        return "Fail";
    }


    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value = "Authorization")String token, @PathVariable Long id){
        if(!validarToken(token)){return;}
        usuarioDAO.eliminar(id);
    }


    private boolean validarToken(String token){
        String usuarioID = jwtUtil.getKey(token);
        return usuarioID != null;
    }
}
