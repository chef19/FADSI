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

    public Nodo front;
    public Nodo rear;
    public int size;

    public Cola() {
        front = null;
        rear = front;
        size = 0;
    }
    
    public void Devolverse(Nodo Mamon){
        Mamon.setNext(front);
        front=Mamon;
        size++;
    }

    public void enqueue(T element) {
        if (size == 0) {
            Nodo newN = new Nodo(element);
            front = newN;
            rear = front;
            size++;
        } else {
            Nodo newN = new Nodo(element);
            rear.setNext(newN);
            rear = rear.getNext();
            size++;
        }
    }

    public T dequeue() {
        if (size == 0) {
            return null;
        } else {
            Nodo temp = front;
            front = front.getNext();
            size--;
            return (T) temp.getElemento();
        }
    }

    public T first() {
        if (size == 0) {
            return null;
        } else {
            return (T) front.getElemento();
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        front = new Nodo();
        rear = front;
        size = 0;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
}
