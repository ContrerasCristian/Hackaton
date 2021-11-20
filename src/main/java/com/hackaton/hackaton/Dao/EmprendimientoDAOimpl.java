package com.hackaton.hackaton.Dao;

import com.hackaton.hackaton.Models.EmprendimientoModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EmprendimientoDAOimpl implements EmprendimientoDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<EmprendimientoModel> getEmprendimientos() {
        String sql = "FROM EmprendimientoModel";
        return entityManager.createQuery(sql).getResultList();
    }

    @Override
    public void registrar(EmprendimientoModel emprendimiento) {
        entityManager.merge(emprendimiento);
        System.out.println(emprendimiento);
    }
}
