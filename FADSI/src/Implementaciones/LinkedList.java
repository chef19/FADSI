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
public class LinkedList <T> {
    public Nodo head;
    public Nodo current;
    public Nodo tail;
    
    public int size;
    
    public LinkedList(){
        head = new Nodo();
        current=head;
        tail= current;
        size=0;
    }
    public void Add(Nodo elemento){
        head.setNext(elemento);
        size++;
    }
    public void Clear(){
        head = new Nodo();
        current=head;
        tail= current;
        size=0;
    }
    public void RemoveIndex(int i){
        int j=0;
        Nodo temp=this.head;
        Nodo temp1=this.head.getNext();
        while(j<i){
            if(j+1==i){
                temp.setNext(temp1.getNext());
            }
            temp.getNext();
            temp1.getNext();
            j++;
        }
        
    
    }
    
}
