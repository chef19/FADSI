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
public class Nodo <T> {
    public T Nodo;
    public Nodo Next;
    
    public Nodo(){
        this.Next=null;
        this.Nodo=null;
    }
    
    public Nodo(T nodo){
        this.Nodo=nodo;
    }
    public Nodo(T nodo,Nodo next){
        this.Next=next;
        this.Nodo=nodo;
    }
    public T getNodo(){
        return this.Nodo;
    }
    public Nodo getNext(){
        return this.Next;
    }
    public void setNext(Nodo next){
        this.Next=next;
    }
}

