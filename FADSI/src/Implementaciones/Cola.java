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
public class Cola<T> {

    public int size;
    public Nodo<T> primero;

    public Cola() {
        this.primero = new Nodo();
        this.size=0;

    }
    public void Queue(Nodo elemento){
        if(primero==null){
            this.primero=elemento;
            this.size++;
        }
        else{
            primero.setNext(elemento);
            size++;
        }
    }
    public Nodo Dequeue(){
        Nodo temp = this.primero;
        this.primero=this.primero.getNext();
        size--;
        return temp;
    }
    public void Clear(){
        this.primero=null;
        this.size=0;
    }
    
}
