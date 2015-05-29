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
public class Dirreciones {
    public int codigo;
    public String provincia;
    public String dirreccion;
    
    public Dirreciones(int Codigo,String Provincia,String Direccion){
        this.codigo=Codigo;
        this.provincia=Provincia;
        this.dirreccion=Direccion;
    }
    public int getCodigo(){
        return this.codigo;
    }        
    public String getProvincia(){
        return this.provincia;
    }
    public String getDireccion(){
        return this.dirreccion;
    }
}
