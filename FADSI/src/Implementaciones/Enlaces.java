/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementaciones;

/**
 *
 * @author MICHAEL
 */
public class Enlaces {
    public String codigo;
    public LinkedList enlaces;
    public LinkedList pesos;
    
    public Enlaces(String Codigo,LinkedList Enlace,LinkedList Peso){
        this.codigo=Codigo;
        this.enlaces=Enlace;
        this.pesos=Peso;
    }
    public String getCodigo(){
        return this.codigo;
    }
    public LinkedList getEnlace(){
        return this.enlaces;
    }
    public LinkedList getPesos(){
        return this.pesos;
    }
}
