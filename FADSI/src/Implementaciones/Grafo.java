/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementaciones;

/**
 *
 * @author Max
 */
public class Grafo {
    
    public LinkedList Lista;
    public int NumeroAristas;
    public int NumeroNodos;
    
    public Grafo(){
        Lista = new LinkedList<NodoGrafo>();
        NumeroAristas = 0;
        NumeroNodos = 0;
    }
    
    public void Agregar (NodoGrafo Nuevo){
        Lista.append(Nuevo);
        NumeroNodos++;
    }
    
    public void AgregarRelacion(NodoGrafo R1, NodoGrafo R2, int Distancia){
        R1.añadirRelacion(R2,Distancia);
        NumeroAristas++;
    }
    
    public void EliminarRelacion(NodoGrafo R1, NodoGrafo R2){
        R1.eliminarRelacion(R2);
        NumeroAristas--;
    }
    
    public void EliminarNodo(NodoGrafo R1){
        int i=0;
        while(i<=Lista.size()){
            NodoGrafo Rx = (NodoGrafo) Lista.current.getElemento();
            if(Rx.Relaciones.getPositionOfElement(R1)!=-1){
                Rx.eliminarRelacion(R1);
                Lista.current.element=Rx;
            }
            i++;
            Lista.next();
        }
    }
    
    public static void main (String[] args){
        Grafo Graf = new Grafo();
        NodoGrafo Nodo1 = new NodoGrafo(1);
        NodoGrafo Nodo2 = new NodoGrafo(2);
        NodoGrafo Nodo3 = new NodoGrafo(3);
        NodoGrafo Nodo4 = new NodoGrafo(4);
        //************************************
        //************************************
        Graf.Agregar(Nodo1);
        Graf.Agregar(Nodo2);
        Graf.Agregar(Nodo3);
        Graf.Agregar(Nodo4);
        //************************************
        //************************************
        NodoGrafo Temp = (NodoGrafo) Graf.Lista.current.element;
        System.out.println(Temp.Dato);
        Graf.Lista.next();
        Temp = (NodoGrafo) Graf.Lista.current.element;
        System.out.println(Temp.Dato);
        Graf.Lista.next();
        Temp = (NodoGrafo) Graf.Lista.current.element;
        System.out.println(Temp.Dato);
        Graf.Lista.next();
        Temp = (NodoGrafo) Graf.Lista.current.element;
        System.out.println(Temp.Dato);
        Graf.Lista.goToStart();
        System.out.println("/************************");
        Graf.AgregarRelacion(Nodo1, Nodo2, 2);
        Graf.AgregarRelacion(Nodo2, Nodo1, 3);
        Graf.AgregarRelacion(Nodo2, Nodo3, 8);
        Graf.AgregarRelacion(Nodo1, Nodo4, 5);
        Graf.AgregarRelacion(Nodo4, Nodo1, 6);
        //***************************************
        //***************************************
        Temp = (NodoGrafo) Graf.Lista.current.element;
        System.out.println(Temp.Relaciones.current.getElemento());
        System.out.println(Temp.Distancias.current.getElemento());
        Temp.Relaciones.next();
        Temp.Distancias.next();
        System.out.println(Temp.Relaciones.current.getElemento());
        System.out.println(Temp.Distancias.current.getElemento());
        System.out.println("/************************");
        Graf.Lista.next();
        Temp = (NodoGrafo) Graf.Lista.current.element;
        System.out.println(Temp.Relaciones.current.getElemento());
        System.out.println(Temp.Distancias.current.getElemento());
        Temp.Relaciones.next();
        Temp.Distancias.next();
        System.out.println(Temp.Relaciones.current.getElemento());
        System.out.println(Temp.Distancias.current.getElemento());
        System.out.println("/************************");
        Graf.Lista.next();
        Temp = (NodoGrafo) Graf.Lista.current.element;
        System.out.println(Temp.Relaciones.current.getElemento());
        System.out.println(Temp.Distancias.current.getElemento());
        System.out.println("/************************");
        Graf.Lista.next();
        Temp = (NodoGrafo) Graf.Lista.current.element;
        System.out.println(Temp.Relaciones.current.getElemento());
        System.out.println(Temp.Distancias.current.getElemento());
    }
}
