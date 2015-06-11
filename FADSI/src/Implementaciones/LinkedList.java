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
public class LinkedList<T> {

    public Nodo head;
    public Nodo current;
    public Nodo tail;
    public int position;
    public int size;

    public LinkedList() {
        this.head = new Nodo();
        this.current = this.head;
        this.tail = this.head;
        this.size = 0;
        this.position = -1;
    }

    public void insert(T element) {
        Nodo newNode = new Nodo(element, this.current.getNext());
        this.current.setNext(newNode);
        if (this.current == this.tail) {
            this.tail = tail.getNext();
        }
        this.size++;

    }

    public void append(T element) {
        if (size == 0) {
            Nodo newNode = new Nodo(element);
            this.head = newNode;
            this.current = this.head;
            this.tail = this.current;
            this.size++;
        } else {
            Nodo newNode = new Nodo(element);
            this.tail.setNext(newNode);
            this.tail = newNode;
            size++;

        }
    }

    public void remove() {
        if ((this.head == this.current) && (this.head == this.tail)) {
            System.out.println("Lista vacía, no se puede remover ningún elemento");
            return;
        }
        Nodo temp = head;
        while (temp.getNext() != this.current) {
            temp = temp.getNext();
        }
        temp.setNext(this.current.getNext());
        if (this.current == this.tail) {
            this.current = this.tail = temp;
            this.position--;
        } else {
            this.current = this.current.getNext();
        }
        this.size--;
    }

    public void clear() {
        this.head = this.tail = this.current = new Nodo();
        this.position = -1;
        this.size = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public void goToStart() {
        this.current = this.head;
        this.position = -1;
    }

    public void goToEnd() {
        this.current = this.tail;
        this.position = this.size - 1;
    }

    public void goToPos(int pos) throws IndexOutOfBoundsException {
        if (pos < -1 || pos >= this.size) {
            throw new IndexOutOfBoundsException("Fuera de indice");
        } else if (pos > this.position) {
            while (pos > this.position) {
                this.next();
            }
        } else if (pos < this.position) {
            while (pos < this.position) {
                this.previous();
            }
        }
    }

    public int getPositionOfElement(T element) {
        Nodo tempNode = this.head;
        int position = -1;
        while (tempNode != null) {
            if (tempNode.getElemento() != null && tempNode.getElemento().equals(element)) {
                return position;
            }
            tempNode = tempNode.getNext();
            position++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
        return true;
        }
        return false;
    }

    public boolean next() {
        if (this.current == this.tail) {
            System.out.println("Actualmente en último nodo, no se puede avanzar");
            return false;
        }
        this.current = this.current.getNext();
        this.position++;
        return true;
    }

    public boolean previous() {
        if (this.current == this.head) {
            System.out.println("Actualmente en primer nodo, no se puede retroceder");
            return false;
        }
        Nodo temp = head;
        this.position = -1;
        while (temp.getNext() != this.current) {
            temp = temp.getNext();
            this.position++;
        }
        this.current = temp;
        return true;
    }

    public T getElement() {
        return (T) current.getElemento();
    }

    public void ToString(){
        Nodo currentNode = this.head.getNext();
        StringBuffer result = new StringBuffer();
        for (int i = 0; currentNode != null; i++)
        {
            if (i > 0)
            {
                result.append(",");
            }
            Object element = currentNode.getElemento();
            result.append(element == null ? "" : element);
            currentNode = currentNode.getNext();
        }
        System.out.println(result.toString());
    }
}
