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
public class Pedidos {
    public int tiempo;
    public String nombre;
    public String recoje;
    public String entrega;
    
    public Pedidos(){ 
    }
    
    public Pedidos(String nombre,String Recoje,String Entrega){
        this.nombre=nombre;
        this.recoje=recoje;
        this.entrega=Entrega;
    }
    public String getCliente(){
        return this.nombre;
    }
    public int getTiempo(){
        return this.tiempo;
    }
    public String getRecoje(){
        return this.recoje;
    }
    public String getEntrega(){
        return this.entrega;
    }
    public void setTiempo(int tiempo){
        this.tiempo=tiempo;
    }
}
