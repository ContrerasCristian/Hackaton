package com.hackaton.hackaton.Dao;

import com.hackaton.hackaton.Models.EmprendimientoModel;


import java.util.List;

public interface EmprendimientoDAO {

    List<EmprendimientoModel> getEmprendimientos();

    void registrar(EmprendimientoModel emprendimiento);
}
