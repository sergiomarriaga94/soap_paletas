/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.paletas_service.dao;

import com.udea.paletas_service.persistencia.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author sergio.marriaga
 */
public class usuarioDao {
    public void nuevaUsuario(Usuario usuario ){
    SessionFactory sessionFactory=null;
    Session session=null;
    Transaction transaction=null;
    try{
        sessionFactory=HibernateUtil.getSessionFactory();
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        session.save(usuario);
        transaction.commit();
        session.close();
    }catch(HibernateException e){
        transaction.rollback();
        throw new RuntimeException("No se pudo agregar el usuario a la base de datos");
    }
    }
    public List<Usuario> getEmpleados() {
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session s=factory.openSession();
        Query q=s.createQuery("from Usuario");
        List<Usuario> empleados=q.list();
        return empleados;
    }
}
