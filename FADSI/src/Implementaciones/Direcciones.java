/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementaciones;

/**
 *
 * @author ANDRES MS
 */
public class Direcciones {
    public String codigo;
    public String dirreccion;
    
    public Direcciones(String Codigo,String Direccion){
        this.codigo=Codigo;
        this.dirreccion=Direccion;
    }
    public String getCodigo(){
        return this.codigo;
    }        
    public String getDireccion(){
        return this.dirreccion;
    }
}
