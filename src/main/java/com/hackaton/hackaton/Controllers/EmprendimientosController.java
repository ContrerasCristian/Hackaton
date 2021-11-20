package com.hackaton.hackaton.Controllers;



import com.hackaton.hackaton.Dao.EmprendimientoDAO;

import com.hackaton.hackaton.Models.EmprendimientoModel;
import com.hackaton.hackaton.Models.UsuarioModel;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmprendimientosController {

    @Autowired
    private EmprendimientoDAO emprendimientoDAO;


    @RequestMapping(value = "api/emprendimientos", method = RequestMethod.GET)
    public List<EmprendimientoModel> getUsuarios(){
        return emprendimientoDAO.getEmprendimientos();
    }

    @RequestMapping(value = "api/registrar", method = RequestMethod.POST)
    public void registrarEmprendimiento(@RequestBody EmprendimientoModel emprendimiento){
        emprendimientoDAO.registrar(emprendimiento);
    }

}
