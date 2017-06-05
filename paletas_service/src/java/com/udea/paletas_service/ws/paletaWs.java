/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.paletas_service.ws;

import com.udea.paletas_service.dao.paletaDao;
import com.udea.paletas_service.dao.usuarioDao;
import com.udea.paletas_service.persistencia.Paleta;
import com.udea.paletas_service.persistencia.Usuario;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author sergio.marriaga
 */
@WebService(serviceName = "paletaWs")
public class paletaWs {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     * @param nombre
     * @param tipo_paleta
     * @param precio
     * @return 
     */
    @WebMethod(operationName = "agregarPaleta")
    public String agregarPaleta(@WebParam(name = "nombre") String nombre, @WebParam(name = "tipo_paleta") int tipo_paleta, @WebParam(name = "precio") double precio) {
        
        Paleta p=new Paleta(nombre, tipo_paleta, precio);
        paletaDao dao= new paletaDao();
        dao.nuevaPaleta(p);
        //TODO write your implementation code here:
        
        return "La paleta ha sido guardada";
    }


    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "verPaletas")
    public List<Paleta> verPaletas() {
        paletaDao dao= new paletaDao();
        List<Paleta> list=dao.verPaletas();
        //TODO write your implementation code here:
        
        return list;
    }

    /**
     * Web service operation
     * @param nombre
     * @param cedula
     * @param password
     * @param telefono
     * @param sede
     * @param celular
     * @return 
     */
    @WebMethod(operationName = "agregarEmpleado")
    public String agregarEmpleado(@WebParam(name = "nombre") String nombre, @WebParam(name = "cedula") String cedula, @WebParam(name = "password") String password, @WebParam(name = "telefono") String telefono, @WebParam(name = "celular") String celular, @WebParam(name = "sede") int sede) {
        Usuario usuario=new  Usuario(nombre, cedula, password, telefono, celular, sede);
        usuarioDao dao=new usuarioDao();
        dao.nuevaUsuario(usuario);
        //TODO write your implementation code here:
        return "El empleado ha sido guardado con exito";
    }
}
