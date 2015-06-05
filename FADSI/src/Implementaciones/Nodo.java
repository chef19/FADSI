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
public class Nodo<T> {
    public T element;
    public Nodo next;
    
    public Nodo(){
        this.element=null;
        this.next=null;
    }
    public Nodo(T element){
        this.element=element;
        this.next=null;
    }
    public Nodo(T element,Nodo next){
        this.element=element;
        this.next=next;
    }
    public Nodo getNext(){
        return next;
    }
    public T getElemento(){
        return element;
    }
    public void setElemento(T element){
        this.element=element;
    }
    public void setNext(Nodo next){
        this.next=next;
    }
}

