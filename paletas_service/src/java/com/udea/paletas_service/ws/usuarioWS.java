/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.paletas_service.ws;

import com.udea.paletas_service.dao.usuarioDao;
import com.udea.paletas_service.persistencia.Usuario;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author sergio.marriaga
 */
@WebService(serviceName = "usuarioWS")
public class usuarioWS {

    /**
     * Web service operation
     * @param nombre
     * @param cedula
     * @param sede
     * @param telefono
     * @param celular
     * @return 
     */
    @WebMethod(operationName = "agregarEmpleado")
    public String agregarEmpleado(@WebParam(name = "nombre") String nombre, @WebParam(name = "cedula") String cedula, @WebParam(name = "telefono") String telefono, @WebParam(name = "celular") String celular, @WebParam(name = "sede") int sede) {
        
        Usuario u=new Usuario(nombre, cedula, celular, telefono, celular, sede);
        usuarioDao dao=new usuarioDao();
        dao.nuevaUsuario(u);
        //TODO write your implementation code here:
        return null;
    }
}
