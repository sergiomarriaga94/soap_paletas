/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.paletas_service.servicesRest;

import com.udea.paletas_service.dao.usuarioDao;
import com.udea.paletas_service.persistencia.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author sergio.marriaga
 * 
 */
@Stateless
@Path("/Empleado")
public class empleadoRest {
    
    @GET
   @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getEmpleados(){
        usuarioDao dao=new usuarioDao(); 
        return dao.getEmpleados();
    }
}
